package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;
import org.cvpcs.android.cwiidconfig.config.ClassicController;
import org.cvpcs.android.cwiidconfig.config.Device;

public class ConfigClassic extends Activity {
	private static final String TAG = "CWiidConfig/ConfigClassic";
	
	private static final int BUTTON_ALPHA = 0x66;
	
	private static final ArrayList<String> ANDROID_KEYS = new ArrayList<String>();
	
	static {
		ANDROID_KEYS.add("[ Unmapped ]");
		ANDROID_KEYS.addAll(ConfigManager.ANDROID_KEYS);
	}
	
	private ArrayAdapter<String> mWiiAdapter;
	private ArrayAdapter<String> mKeyAdapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config_classic);
		
		final Spinner wii_spinner = (Spinner)findViewById(R.id.config_classic_wiibutton);
		final Spinner key_spinner = (Spinner)findViewById(R.id.config_classic_keybutton);
		
		mWiiAdapter = new ArrayAdapter<String>(this, R.layout.sexy_combo, ClassicController.BUTTONS);
		mWiiAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		wii_spinner.setAdapter(mWiiAdapter);
		wii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String button = ClassicController.BUTTONS.get(position).toString();
				
				setImageButton(button);
				
				// do we have a config
				Device classic = CWiiDConfig.mAutoPreset.getConfig().getDevice(ClassicController.NAME);
				
				if(classic == null) {
					Log.e(TAG, "Classic controller device not found!");
					return;
				}
				
				Integer cursym = classic.getButton(button);
				
				boolean clearConfig = true;
				
				if(cursym != null) {
					for(int i = 0; i < ANDROID_KEYS.size(); i++) {
						String key = ANDROID_KEYS.get(i).toString();
						if(cursym.equals(Integer.valueOf(ConfigManager.convertHRToKeySym(key)))) {
							key_spinner.setSelection(i);
							clearConfig = false;
							break;
						}
					}
				}
				
				if(clearConfig) {
					key_spinner.setSelection(0);
				}
			}

			public void onNothingSelected(AdapterView<?> parent) {
				setImageButton(null);
			}
		});
		
		mKeyAdapter = new ArrayAdapter<String>(this, R.layout.sexy_combo, ANDROID_KEYS);
		mKeyAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		key_spinner.setAdapter(mKeyAdapter);
		key_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				setConfig(
						ClassicController.BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(position).toString()
						);
			}
	
			public void onNothingSelected(AdapterView<?> parent) {
				setConfig(
						ClassicController.BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(0).toString()
						);
			}
		});
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		menu = CWiiDConfig.createGlobalOptionsMenu(menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	return CWiiDConfig.handleGlobalOptionsMenu(this, item, android.R.drawable.ic_menu_help);
    }
	
	private void setConfig(String wiiButton, String keyButton) {
		int keysym = ConfigManager.convertHRToKeySym(keyButton);
		
		Device classic = CWiiDConfig.mAutoPreset.getConfig().getDevice(ClassicController.NAME);
		
		if(classic == null) {
			Log.e(TAG, "Classic controller device not found!");
			return;
		}
		
		if(keysym > 0) {
			classic.setButton(wiiButton, Integer.valueOf(keysym));
		} else {
			classic.setButton(wiiButton, null);
		}
		
		CWiiDConfig.mAutoPreset.save();
	}
	
	private void setImageButton(String button) {
		if(button == null) {
			button = "";
		}
		
		if(button.equals(ClassicController.BUTTON_UP)) {
			setImageButton(R.drawable.classic_button_up);
		} else if(button.equals(ClassicController.BUTTON_LEFT)) {
			setImageButton(R.drawable.classic_button_left);
		} else if(button.equals(ClassicController.BUTTON_RIGHT)) {
			setImageButton(R.drawable.classic_button_right);
		} else if(button.equals(ClassicController.BUTTON_DOWN)) {
			setImageButton(R.drawable.classic_button_down);
		} else if(button.equals(ClassicController.BUTTON_A)) {
			setImageButton(R.drawable.classic_button_a);
		} else if(button.equals(ClassicController.BUTTON_B)) {
			setImageButton(R.drawable.classic_button_b);
		} else if(button.equals(ClassicController.BUTTON_X)) {
			setImageButton(R.drawable.classic_button_x);
		} else if(button.equals(ClassicController.BUTTON_Y)) {
			setImageButton(R.drawable.classic_button_y);
		} else if(button.equals(ClassicController.BUTTON_L)) {
			setImageButton(R.drawable.classic_button_l);
		} else if(button.equals(ClassicController.BUTTON_R)) {
			setImageButton(R.drawable.classic_button_r);
		} else if(button.equals(ClassicController.BUTTON_ZL)) {
			setImageButton(R.drawable.classic_button_zl);
		} else if(button.equals(ClassicController.BUTTON_ZR)) {
			setImageButton(R.drawable.classic_button_zr);
		} else if(button.equals(ClassicController.BUTTON_PLUS)) {
			setImageButton(R.drawable.classic_button_plus);
		} else if(button.equals(ClassicController.BUTTON_HOME)) {
			setImageButton(R.drawable.classic_button_home);
		} else if(button.equals(ClassicController.BUTTON_MINUS)) {
			setImageButton(R.drawable.classic_button_minus);
		} else {
			setImageButton();
		}
	}
	
	private void setImageButton() {
		final ImageView classic_front_button = (ImageView)findViewById(R.id.config_classic_front_view_button);
		
		classic_front_button.setVisibility(View.GONE);
	}
	
	private void setImageButton(int resId) {
		setImageButton(resId, BUTTON_ALPHA);
	}
	
	private void setImageButton(int resId, int alpha) {
		final ImageView classic_front_button = (ImageView)findViewById(R.id.config_classic_front_view_button);
		
		classic_front_button.setImageResource(resId);
		classic_front_button.setAlpha(alpha);
		classic_front_button.setVisibility(View.VISIBLE);
	}
}
