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
import org.cvpcs.android.cwiidconfig.config.Device;
import org.cvpcs.android.cwiidconfig.config.Nunchuk;

public class ConfigNunchuk extends Activity {
	private static final String TAG = "CWiiDConfig/ConfigNunchuk";
	
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
		setContentView(R.layout.config_nunchuk);
		
		final Spinner wii_spinner = (Spinner)findViewById(R.id.config_nunchuk_wiibutton);
		final Spinner key_spinner = (Spinner)findViewById(R.id.config_nunchuk_keybutton);
		
		mWiiAdapter = new ArrayAdapter<String>(this, R.layout.sexy_combo, Nunchuk.BUTTONS);
		mWiiAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		wii_spinner.setAdapter(mWiiAdapter);
		wii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String button = Nunchuk.BUTTONS.get(position).toString();
				
				setImageButton(button);
				
				// do we have a config
				Device nunchuk = CWiiDConfig.mAutoPreset.getConfig().getDevice(Nunchuk.NAME);

				if(nunchuk == null) {
					Log.e(TAG, "Nunchuk device not found!");
					return;
				}
				
				Integer cursym = nunchuk.getButton(button);
				
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
						Nunchuk.BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(position).toString()
						);
			}
	
			public void onNothingSelected(AdapterView<?> parent) {
				setConfig(
						Nunchuk.BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
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

		Device nunchuk = CWiiDConfig.mAutoPreset.getConfig().getDevice(Nunchuk.NAME);

		if(nunchuk == null) {
			Log.e(TAG, "Nunchuk device not found!");
			return;
		}
		
		if(keysym > 0) {
			nunchuk.setButton(wiiButton, Integer.valueOf(keysym));
		} else {
			nunchuk.setButton(wiiButton, null);
		}
		
		CWiiDConfig.mAutoPreset.save();
	}
	
	private void setImageButton(String button) {
		if(button == null) {
			button = "";
		}
		
		if(button.equals(Nunchuk.BUTTON_UP)) {
			setImageButton(R.drawable.nunchuk_button_up);
		} else if(button.equals(Nunchuk.BUTTON_LEFT)) {
			setImageButton(R.drawable.nunchuk_button_left);
		} else if(button.equals(Nunchuk.BUTTON_RIGHT)) {
			setImageButton(R.drawable.nunchuk_button_right);
		} else if(button.equals(Nunchuk.BUTTON_DOWN)) {
			setImageButton(R.drawable.nunchuk_button_down);
		} else if(button.equals(Nunchuk.BUTTON_C)) {
			setImageButton(R.drawable.nunchuk_button_c);
		} else if(button.equals(Nunchuk.BUTTON_Z)) {
			setImageButton(R.drawable.nunchuk_button_z);
		} else {
			setImageButton();
		}
	}
	
	private void setImageButton() {
		final ImageView nunchuk_multi_button = (ImageView)findViewById(R.id.config_nunchuk_multi_view_button);
		
		nunchuk_multi_button.setVisibility(View.GONE);
	}
	
	private void setImageButton(int resId) {
		setImageButton(resId, BUTTON_ALPHA);
	}
	
	private void setImageButton(int resId, int alpha) {
		final ImageView nunchuk_multi_button = (ImageView)findViewById(R.id.config_nunchuk_multi_view_button);
		
		nunchuk_multi_button.setImageResource(resId);
		nunchuk_multi_button.setAlpha(alpha);
		nunchuk_multi_button.setVisibility(View.VISIBLE);
	}
}
