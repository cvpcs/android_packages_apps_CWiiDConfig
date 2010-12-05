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

public class CWiiDConfig extends Activity {
	private static boolean POWER_ON = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final ImageButton power_toggle = (ImageButton)findViewById(R.id.main_power_toggle_button);
		final TextView power_toggle_text = (TextView)findViewById(R.id.main_power_toggle_text);
		final ImageButton load_preset = (ImageButton)findViewById(R.id.main_load_preset_button);
		final ImageView wiimote_view = (ImageView)findViewById(R.id.main_wiimote_view);

		power_toggle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// actually turn CWiiD on/off
				togglePower();

				// toggle our image/text
				if (POWER_ON) {
					power_toggle.setImageResource(R.drawable.ic_menu_power_on);
					power_toggle_text.setText(R.string.power_off_text);
				} else {
					power_toggle.setImageResource(R.drawable.ic_menu_power_off);
					power_toggle_text.setText(R.string.power_on_text);
				}
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

	public void togglePower() {
		if (POWER_ON) {
			// step 1: kill cwiid
		} else {
			// step 1: save current config
			// step 2: start cwiid
			// step 3: connect wiimote
		}
	}
}
