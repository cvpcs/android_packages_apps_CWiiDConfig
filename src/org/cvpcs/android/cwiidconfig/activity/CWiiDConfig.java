package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.daemon.CWiiDManager;

public class CWiiDConfig extends Activity {
	private static boolean POWER_ON = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// retrieve all of our needed views
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final TextView power_toggle_text = (TextView)findViewById(R.id.main_power_toggle_text);
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
				Toast.makeText(v.getContext(), "ROFL YOU CLICKED ME!", 2000).show();
			}
		});
	}

	private void togglePower() {
		CWiiDManager.State state = CWiiDManager.State.UNKNOWN;

		if (POWER_ON) {
			CWiiDManager.stopDaemon();

			do {
				try {
					Thread.sleep(500);
				} catch(Exception e) {}

				state = CWiiDManager.getState();
			} while(state != CWiiDManager.State.STOPPED &&
				state != CWiiDManager.State.STOPPING &&
				state != CWiiDManager.State.ERROR);
		} else {
			CWiiDManager.startDaemon("buttons");

			do {
				try {
					Thread.sleep(500);
				} catch(Exception e) {}

				state = CWiiDManager.getState();
			} while(state != CWiiDManager.State.READY &&
				state != CWiiDManager.State.DISCOVERING &&
				state != CWiiDManager.State.ERROR);
		}
	}

	private void updateDaemonStatus() {
		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final TextView power_toggle_text = (TextView)findViewById(R.id.main_power_toggle_text);

		if (CWiiDManager.getState() == CWiiDManager.State.STOPPED ||
		    CWiiDManager.getState() == CWiiDManager.State.STOPPING) {
			POWER_ON = false;
		} else {
			POWER_ON = true;
		}

		if (POWER_ON) {
			power_toggle.setImageResource(R.drawable.ic_menu_power_on);
			power_toggle_text.setText(R.string.power_off_text);
		} else {
			power_toggle.setImageResource(R.drawable.ic_menu_power_off);
			power_toggle_text.setText(R.string.power_on_text);
		}
	}
}
