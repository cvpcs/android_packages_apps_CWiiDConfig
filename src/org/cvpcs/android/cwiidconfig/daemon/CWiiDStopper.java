package org.cvpcs.android.cwiidconfig.daemon;

import java.lang.Thread;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.activity.CWiiDConfig;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class CWiiDStopper implements Runnable {
	private static final int PDHANDLER_SLEEP_MSG = 0;
	private static final int PDHANDLER_DISMISS_MSG = 1;
	private static final int PDHANDLER_ALTERTXT_MSG = 2;
	private static final String PDHANDLER_ALTERTXT_MSG_KEY = "altertext_message";
	
	private static ProgressDialog mProgressDialog = null;
	private static Thread mStopperThread = null;
	
	private Context mContext;
	private Handler mDaemonHandler;
	
	// this is used to send progress dialog updates on the UI layer
	private static Handler mProgressHandler = new Handler() {
		public void handleMessage(Message msg) {
			// sanity check
			if(mProgressDialog == null) {
				return;
			}
			
			switch(msg.what) {
				case PDHANDLER_DISMISS_MSG:
					mProgressDialog.dismiss();
					mProgressDialog = null;
					break;
				case PDHANDLER_ALTERTXT_MSG:
					Bundle b = msg.getData();
					if(b.containsKey(PDHANDLER_ALTERTXT_MSG_KEY)) {
						String newMessage = b.getString(PDHANDLER_ALTERTXT_MSG_KEY);
						
						if(newMessage != null) {
							mProgressDialog.setMessage(newMessage);
						}
					}
					break;
				default:
					break;
			}
		}
	};
	
	public static void show(Context ctx, Handler daemonHandler) {
		// create our progress dialog
		mProgressDialog = new ProgressDialog(ctx);
		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(false);
		mProgressDialog.setMessage(ctx.getString(R.string.cwiid_stopping));
		mProgressDialog.show();
		
		mStopperThread = new Thread(new CWiiDStopper(ctx, daemonHandler));
		mStopperThread.start();
	}
	
	public CWiiDStopper(Context ctx, Handler daemonHandler) {
		mContext = ctx;
		mDaemonHandler = daemonHandler;
	}
	
	public void run() {
		// stock state
		CWiiDManager.State state = CWiiDManager.State.UNKNOWN;
		
		// start the daemon
		CWiiDManager.stopDaemon();
		
		// keep looping until we either finish or error out
		while(state != CWiiDManager.State.STOPPED &&
		      state != CWiiDManager.State.ERROR) {
			// attempt to sleep briefly (0.5 sec)
			try {
				Thread.sleep(500);
			} catch(Exception e) { }
			
			state = CWiiDManager.getState();
			
			Message m = new Message();
			m.what = PDHANDLER_SLEEP_MSG;
			m.setTarget(mProgressHandler);
			Bundle b = new Bundle();
			
			switch(state) {
				case STOPPING:
					m.what = PDHANDLER_ALTERTXT_MSG;
					b.putString(PDHANDLER_ALTERTXT_MSG_KEY, mContext.getString(R.string.cwiid_stopping));
					break;
				case STOPPED:
					m.what = PDHANDLER_ALTERTXT_MSG;
					b.putString(PDHANDLER_ALTERTXT_MSG_KEY, mContext.getString(R.string.cwiid_stopped));
					break;
				case ERROR:
					m.what = PDHANDLER_ALTERTXT_MSG;
					b.putString(PDHANDLER_ALTERTXT_MSG_KEY, mContext.getString(R.string.cwiid_error));
					break;
			}
			
			// encapsulate our data
			m.setData(b);
			// send an update on the UI thread
			m.sendToTarget();
		}
		
		// we are now preparing to dismiss our dialog, so keep it displayed for 2 seconds so they may
		// read the final message
		try {
			Thread.sleep(2000);
		} catch(Exception e) { }
		
		mProgressHandler.sendEmptyMessage(PDHANDLER_DISMISS_MSG);
		
		// update main UI thread
		if(state == CWiiDManager.State.STOPPED) {
			mDaemonHandler.sendEmptyMessage(CWiiDConfig.DAEMON_STOPPED_MSG);
		} else {
			mDaemonHandler.sendEmptyMessage(CWiiDConfig.DAEMON_ERROR_MSG);
		}
	}
}
