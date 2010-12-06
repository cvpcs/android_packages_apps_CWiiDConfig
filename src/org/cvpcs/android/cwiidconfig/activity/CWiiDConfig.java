package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.daemon.CWiiDManager;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDStarter;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDStopper;

public class CWiiDConfig extends Activity {
	private static final int BT_ENABLE_FOR_DAEMON_START_RESULT = 1;
	
	private static boolean mPowerOn = false;
	public static String mCurrentConfig = "buttons";
	private static BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// retrieve all of our needed views
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final ImageButton load_preset = (ImageButton)findViewById(R.id.main_load_preset_button);
		final ImageView wiimote_view = (ImageView)findViewById(R.id.main_wiimote_view);

		// read in the status of the daemon and alter the display accordingly
		updateDaemonStatus();

		power_toggle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// actually turn CWiiD on/off
				togglePower();

				// update our views
				updateDaemonStatus();
			}
		});
		load_preset.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), LoadPreset.class));
			}
		});
		wiimote_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), ConfigWiimote.class));
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onResume();
		updateDaemonStatus();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
			case BT_ENABLE_FOR_DAEMON_START_RESULT:
				if(resultCode == RESULT_OK && mBluetoothAdapter.isEnabled()) {
					// we have bluetooth! start daemon!
					CWiiDStarter.show(this, mCurrentConfig);
				} else {
					
				}
				break;
			default:
				break;
		}
	}

	/**
	 * Toggle power on/off, performing the appropriate UI interactions in the process
	 */
	private void togglePower() {
		
		if (mPowerOn) {
			// just stop the daemon
			CWiiDStopper.show(this);
		} else {
			// first we verify that bluetooth has started
			if (!mBluetoothAdapter.isEnabled()) {
				// bluetooth isn't enabled, so request the user to enable it
				// if we get bluetooth, then we'll start the daemon
			    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			    startActivityForResult(enableBtIntent, BT_ENABLE_FOR_DAEMON_START_RESULT);
			} else {
				// bluetooth already enabled, just start
				CWiiDStarter.show(this, mCurrentConfig);
			}
		}
	}

	private void updateDaemonStatus() {
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final TextView power_toggle_text = (TextView)findViewById(R.id.main_power_toggle_text);

		if (CWiiDManager.getState() == CWiiDManager.State.STOPPED ||
		    CWiiDManager.getState() == CWiiDManager.State.STOPPING) {
			mPowerOn = false;
		} else {
			mPowerOn = true;
		}

		if (mPowerOn) {
			power_toggle.setImageResource(R.drawable.ic_menu_power_on);
			power_toggle_text.setText(R.string.power_off_text);
		} else {
			power_toggle.setImageResource(R.drawable.ic_menu_power_off);
			power_toggle_text.setText(R.string.power_on_text);
		}
	}
}
