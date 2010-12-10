package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.config.AutoPreset;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDManager;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDDaemonService;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDStarter;
import org.cvpcs.android.cwiidconfig.daemon.CWiiDStopper;
import org.cvpcs.android.cwiidconfig.widgets.HelpDialog;
import org.cvpcs.android.cwiidconfig.widgets.ViewConfigDialog;

public class CWiiDConfig extends Activity {	
	private static final String PREF_NAME = "CWiiDConfigPreferences";
	private static final String PREF_KEY_FIRSTRUN = "FirstRun";
	
	private static final int GLOBAL_OPTIONS_MENU_VIEW_CONFIG = Menu.FIRST + 1;
	private static final int GLOBAL_OPTIONS_MENU_VIEW_HELP = Menu.FIRST + 2;
	
	private static final int ALPHA_ENABLED = 0xFF;
	private static final int ALPHA_DISABLED = 0x33;
	
	private static final int BT_ENABLE_FOR_DAEMON_START_RESULT = 1;
	
	public static final int DAEMON_STARTED_MSG = 1;
	public static final int DAEMON_STOPPED_MSG = 2;
	public static final int DAEMON_ERROR_MSG = 3;
	
	private Handler mDaemonHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch(msg.what) {
				case DAEMON_STARTED_MSG:
					// start our service
					CWiiDConfig.this.startService(new Intent(CWiiDDaemonService.ACTION_INTENT));
					break;
				case DAEMON_STOPPED_MSG:
				case DAEMON_ERROR_MSG:
					// kill service if stopped or error
					CWiiDConfig.this.stopService(new Intent(CWiiDDaemonService.ACTION_INTENT));
					break;
				default:
					break;
			}

			// update our status
			updateDaemonStatus();
		}
	};
	
	private static boolean mPowerOn = false;
	private static BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	
	public static AutoPreset mAutoPreset = AutoPreset.getAutoPreset();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// retrieve all of our needed views
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final ImageButton load_preset = (ImageButton)findViewById(R.id.main_load_preset_button);
		final ImageButton save_preset = (ImageButton)findViewById(R.id.main_save_preset_button);
		final ImageView wiimote_view = (ImageView)findViewById(R.id.main_wiimote_view);
		final ImageView nunchuk_view = (ImageView)findViewById(R.id.main_nunchuk_view);
		final ImageView classic_view = (ImageView)findViewById(R.id.main_classic_view);

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
		save_preset.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), SavePreset.class));
			}
		});
		wiimote_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), ConfigWiimote.class));
			}
		});
		nunchuk_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), ConfigNunchuk.class));
			}
		});
		classic_view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), ConfigClassic.class));
			}
		});
		
		// if it's our first run, we display a message welcoming the user and notifying
		// them of the help options in the context menu
		SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
		boolean firstRun = prefs.getBoolean(PREF_KEY_FIRSTRUN, true);
		if(firstRun) {
			new HelpDialog(this, R.drawable.help_firstrun).show();
			
			SharedPreferences.Editor editor = prefs.edit();
			editor.putBoolean(PREF_KEY_FIRSTRUN, false);
			editor.commit();
		}
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
					CWiiDStarter.show(this, mAutoPreset, mDaemonHandler);
				} else {
					
				}
				break;
			default:
				break;
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		menu = createGlobalOptionsMenu(menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	return handleGlobalOptionsMenu(this, item, R.drawable.help_main);
    }
	
	public static Menu createGlobalOptionsMenu(Menu menu) {
		menu.add(0, GLOBAL_OPTIONS_MENU_VIEW_CONFIG, 0, "View Current Configuration")
			.setIcon(R.drawable.ic_menu_compose);
		menu.add(0, GLOBAL_OPTIONS_MENU_VIEW_HELP, 0, "Help")
			.setIcon(android.R.drawable.ic_menu_help);
		
		return menu;
	}
	
	public static boolean handleGlobalOptionsMenu(Context ctx, MenuItem item, int helpImageResourceId) {
    	switch(item.getItemId()) {
    		case GLOBAL_OPTIONS_MENU_VIEW_CONFIG:
    			new ViewConfigDialog(ctx).show();
    			return true;
    		case GLOBAL_OPTIONS_MENU_VIEW_HELP:
    			new HelpDialog(ctx, helpImageResourceId).show();
    			return true;
    	}
    	
    	return false;
		
	}

	/**
	 * Toggle power on/off, performing the appropriate UI interactions in the process
	 */
	private void togglePower() {
		
		if (mPowerOn) {
			// just stop the daemon
			CWiiDStopper.show(this, mDaemonHandler);
		} else {
			// first we verify that bluetooth has started
			if (!mBluetoothAdapter.isEnabled()) {
				// bluetooth isn't enabled, so request the user to enable it
				// if we get bluetooth, then we'll start the daemon
			    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			    startActivityForResult(enableBtIntent, BT_ENABLE_FOR_DAEMON_START_RESULT);
			} else {
				CWiiDStarter.show(this, mAutoPreset, mDaemonHandler);
			}
		}
	}

	private void updateDaemonStatus() {
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final TextView power_toggle_text = (TextView)findViewById(R.id.main_power_toggle_text);
		final ImageButton load_preset = (ImageButton)findViewById(R.id.main_load_preset_button);
		final TextView load_preset_text = (TextView)findViewById(R.id.main_load_preset_text);
		final ImageButton save_preset = (ImageButton)findViewById(R.id.main_save_preset_button);
		final TextView save_preset_text = (TextView)findViewById(R.id.main_save_preset_text);
		final ImageView wiimote_view = (ImageView)findViewById(R.id.main_wiimote_view);
		final ImageView classic_view = (ImageView)findViewById(R.id.main_classic_view);
		final ImageView nunchuk_view = (ImageView)findViewById(R.id.main_nunchuk_view);
		final TextView daemon_running_text = (TextView)findViewById(R.id.main_daemon_running_text);

		if (CWiiDManager.getState() == CWiiDManager.State.STOPPED ||
		    CWiiDManager.getState() == CWiiDManager.State.ERROR) {
			mPowerOn = false;
		} else {
			mPowerOn = true;
		}

		if (mPowerOn) {
			power_toggle.setImageResource(R.drawable.ic_menu_power_on);
			power_toggle_text.setText(R.string.power_off);
			
			load_preset.setEnabled(false);
			save_preset.setEnabled(false);
			wiimote_view.setClickable(false);
			wiimote_view.setAlpha(ALPHA_DISABLED);
			classic_view.setClickable(false);
			classic_view.setAlpha(ALPHA_DISABLED);
			nunchuk_view.setClickable(false);
			nunchuk_view.setAlpha(ALPHA_DISABLED);
			
			load_preset.setVisibility(View.INVISIBLE);
			save_preset.setVisibility(View.INVISIBLE);
			load_preset_text.setVisibility(View.INVISIBLE);
			save_preset_text.setVisibility(View.INVISIBLE);
			
			daemon_running_text.setVisibility(View.VISIBLE);
		} else {
			power_toggle.setImageResource(R.drawable.ic_menu_power_off);
			power_toggle_text.setText(R.string.power_on);

			
			load_preset.setEnabled(true);
			save_preset.setEnabled(true);
			wiimote_view.setClickable(true);
			wiimote_view.setAlpha(ALPHA_ENABLED);
			classic_view.setClickable(true);
			classic_view.setAlpha(ALPHA_ENABLED);
			nunchuk_view.setClickable(true);
			nunchuk_view.setAlpha(ALPHA_ENABLED);

			load_preset.setVisibility(View.VISIBLE);
			save_preset.setVisibility(View.VISIBLE);
			load_preset_text.setVisibility(View.VISIBLE);
			save_preset_text.setVisibility(View.VISIBLE);
			
			daemon_running_text.setVisibility(View.GONE);
		}
	}
}
