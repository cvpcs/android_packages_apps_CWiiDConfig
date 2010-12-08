package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.activity.CWiiDConfig;

import org.cvpcs.android.cwiidconfig.config.Preset;
import org.cvpcs.android.cwiidconfig.config.PresetManager;

public class SavePreset extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_preset);
		
		final ImageButton save_button = (ImageButton)findViewById(R.id.save_preset_button_save);
		final ImageButton cancel_button = (ImageButton)findViewById(R.id.save_preset_button_cancel);
		final EditText name_text = (EditText)findViewById(R.id.save_preset_name);
		final EditText description_text = (EditText)findViewById(R.id.save_preset_description);
		
		// set the current preset name/description
		name_text.setText(CWiiDConfig.mAutoPreset.getName());
		description_text.setText(CWiiDConfig.mAutoPreset.getSummary());
		
		save_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// assume we will save before perfoming checks
				boolean doSave = true;
				
				// check for a name
				if(name_text.getText().toString().equals("")) {
					name_text.setError("You must specify a preset name.");
					doSave = false;
				}
				
				if(doSave) {
					Toast.makeText(v.getContext(), "F**kin' SAVED!", 2000).show();
					finish();
				}
			}
		});
		cancel_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// close the activity
				finish();
			}
		});
	}
}
