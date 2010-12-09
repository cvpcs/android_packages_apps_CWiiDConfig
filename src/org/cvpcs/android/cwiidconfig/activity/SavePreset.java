package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.util.Log;

import org.cvpcs.android.cwiidconfig.R;

import org.cvpcs.android.cwiidconfig.activity.CWiiDConfig;

import org.cvpcs.android.cwiidconfig.config.Preset;
import org.cvpcs.android.cwiidconfig.config.PresetManager;

public class SavePreset extends Activity {
	private  static final String TAG = "CWiiDConfig/SavePreset";
	
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
		name_text.setText(CWiiDConfig.mAutoPreset.getLoadedName());
		description_text.setText(CWiiDConfig.mAutoPreset.getLoadedSummary());
		
		save_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {				
				String name = name_text.getText().toString();
				String desc = description_text.getText().toString();
				
				// check for a name
				if(name.equals("")) {
					name_text.setError(getString(R.string.save_error_preset_name_empty));
					return; // we can return here because there's only one possible error
				}
				
				// get a preset and load the appropriate data
				final Preset p = PresetManager.getPreset(name);
				p.setSummary(desc);
				p.setConfig(CWiiDConfig.mAutoPreset.getConfig());
				
				// if it exists, we need to alert the user
				if(p.exists()) {
					if(p.isSystem()) {
						name_text.setError(getString(R.string.save_error_preset_name_system));
						return;
					}
					
					AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
					adb.setTitle(R.string.save_preset_overwrite_title);
					adb.setMessage(R.string.save_preset_overwrite_msg);
					adb.setCancelable(false);
					adb.setPositiveButton(getString(R.string.save_preset_overwrite_confirm), 
							new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// dismiss the dialog
							dialog.dismiss();
							
							// save the preset
							savePreset(p);
						}
					});
					adb.setNegativeButton(getString(R.string.save_preset_overwrite_cancel),
							new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// dismiss the dialog
							dialog.dismiss();
						}
					});
					adb.show();
				} else {
					// save the preset
					savePreset(p);
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
	
	private void savePreset(Preset p) {
		// new preset so go ahead and save it
		p.save();
		
		// reload the preset list since we save it
		PresetManager.scanPresets();
		
		// give the user a toast informing them of the save (toast lasts 5 seconds)
		Toast.makeText(this, R.string.save_preset_success, 5000).show();
		
		// reload the saved preset into the autopreset
		CWiiDConfig.mAutoPreset.loadFromPreset(p);
		
		// close the save activity
		finish();
	}
}
