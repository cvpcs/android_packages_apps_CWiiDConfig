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
import java.util.HashMap;
import java.util.Map;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;
import org.cvpcs.android.cwiidconfig.config.ClassicController;
import org.cvpcs.android.cwiidconfig.config.Device;

public abstract class ConfigDevice extends Activity {
	private static final String TAG = "CWiidConfig/ConfigDevice";
	
	private static final int BUTTON_ALPHA = 0x66;

	private static final ArrayList<String> ANDROID_KEYS = new ArrayList<String>();
	
	static {
		ANDROID_KEYS.add("[ Unmapped ]");
		ANDROID_KEYS.addAll(ConfigManager.ANDROID_KEYS);
	}
	
	protected String mDeviceName;
	protected Integer mDeviceImageResourceId;
	protected ArrayList<String> mDeviceButtons;
	protected HashMap<String, Integer> mDeviceButtonImageMap;
	
	private ArrayAdapter<String> mWiiAdapter;
	private ArrayAdapter<String> mKeyAdapter;
	
	public ConfigDevice() {
		super();
		
		mDeviceName = "";
		mDeviceImageResourceId = null;
		mDeviceButtons = new ArrayList<String>();
		mDeviceButtonImageMap = new HashMap<String, Integer>();
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config_device);
		
		final ImageView device_view = (ImageView)findViewById(R.id.config_device_view);
		final Spinner wii_spinner = (Spinner)findViewById(R.id.config_device_wiibutton);
		final Spinner key_spinner = (Spinner)findViewById(R.id.config_device_keybutton);
		
		if(mDeviceImageResourceId != null) {
			device_view.setImageResource(mDeviceImageResourceId.intValue());
		}
		
		mWiiAdapter = new ArrayAdapter<String>(this, R.layout.sexy_combo, mDeviceButtons);
		mWiiAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		wii_spinner.setAdapter(mWiiAdapter);
		wii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String button = mDeviceButtons.get(position).toString();
				
				setImageButton(button);
				
				// do we have a config
				Device device = CWiiDConfig.mAutoPreset.getConfig().getDevice(mDeviceName);
				
				if(device == null) {
					Log.e(TAG, "Device [" + mDeviceName + "] not found!");
					return;
				}
				
				Integer cursym = device.getButton(button);
				
				boolean clearConfig = true;
				
				if(cursym != null) {
					for(int i = 0; i < ANDROID_KEYS.size(); i++) {
						String key = ANDROID_KEYS.get(i).toString();
						
						Integer sym = ConfigManager.convertHRToKeySym(key);
						
						if(sym != null && cursym.equals(sym)) {
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
						mDeviceButtons.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(position).toString()
						);
			}
	
			public void onNothingSelected(AdapterView<?> parent) {
				setConfig(
						mDeviceButtons.get(wii_spinner.getSelectedItemPosition()).toString(),
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
    	return CWiiDConfig.handleGlobalOptionsMenu(this, item, R.drawable.help_configdevice);
    }
	
	private void setConfig(String wiiButton, String keyButton) {
		Integer keysym = ConfigManager.convertHRToKeySym(keyButton);
		
		Device device = CWiiDConfig.mAutoPreset.getConfig().getDevice(mDeviceName);
		
		if(device == null) {
			Log.e(TAG, "Device [" + mDeviceName + "] not found!");
			return;
		}
		
		device.setButton(wiiButton, keysym);
		
		CWiiDConfig.mAutoPreset.save();
	}
	
	private void setImageButton(String button) {
		if(button == null) {
			button = "";
		}
		
		if(mDeviceButtonImageMap.containsKey(button)) {
			Integer resId = mDeviceButtonImageMap.get(button);
			
			if(resId == null) {
				setImageButton();
			} else {
				setImageButton(resId.intValue());
			}
		} else {
			setImageButton();
		}
	}
	
	private void setImageButton() {
		final ImageView device_button = (ImageView)findViewById(R.id.config_device_view_button);
		
		device_button.setVisibility(View.GONE);
	}
	
	private void setImageButton(int resId) {
		setImageButton(resId, BUTTON_ALPHA);
	}
	
	private void setImageButton(int resId, int alpha) {
		final ImageView device_button = (ImageView)findViewById(R.id.config_device_view_button);
		
		device_button.setImageResource(resId);
		device_button.setAlpha(alpha);
		device_button.setVisibility(View.VISIBLE);
	}
}
