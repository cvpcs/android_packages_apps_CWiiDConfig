package org.cvpcs.android.cwiidconfig.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.ConfigManager;

public class ConfigWiimote extends Activity {
	private static final int BUTTON_ALPHA = 0x66;
	
	private static final String WIIMOTE_BUTTON_UP 		= "Up";
	private static final String WIIMOTE_BUTTON_LEFT		= "Left";
	private static final String WIIMOTE_BUTTON_RIGHT	= "Right";
	private static final String WIIMOTE_BUTTON_DOWN		= "Down";
	private static final String WIIMOTE_BUTTON_A		= "A";
	private static final String WIIMOTE_BUTTON_B		= "B";
	private static final String WIIMOTE_BUTTON_MINUS	= "Minus";
	private static final String WIIMOTE_BUTTON_HOME		= "Home";
	private static final String WIIMOTE_BUTTON_PLUS		= "Plus";
	private static final String WIIMOTE_BUTTON_1		= "1";
	private static final String WIIMOTE_BUTTON_2		= "2";
	
	private static final ArrayList<CharSequence> WIIMOTE_BUTTONS = new ArrayList<CharSequence>();
	private static final ArrayList<CharSequence> ANDROID_KEYS = new ArrayList<CharSequence>();
	
	static {
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_UP);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_LEFT);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_RIGHT);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_DOWN);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_A);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_B);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_MINUS);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_HOME);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_PLUS);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_1);
		WIIMOTE_BUTTONS.add(WIIMOTE_BUTTON_2);
		
		ANDROID_KEYS.add("** Unmap Key **");
		ANDROID_KEYS.addAll(ConfigManager.ANDROID_KEYS);
	}
	
	private int mPosition;
	private String mSelection;
	
	private ArrayAdapter<CharSequence> mWiiAdapter;
	private ArrayAdapter<CharSequence> mKeyAdapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config_wiimote);
		
		final Spinner wii_spinner = (Spinner)findViewById(R.id.config_wiimote_wiibutton);
		final Spinner key_spinner = (Spinner)findViewById(R.id.config_wiimote_keybutton);
		
		mWiiAdapter = new ArrayAdapter<CharSequence>(this, R.layout.sexy_combo, WIIMOTE_BUTTONS);
		mWiiAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		wii_spinner.setAdapter(mWiiAdapter);
		wii_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				setImageButton(WIIMOTE_BUTTONS.get(position).toString());
			}

			public void onNothingSelected(AdapterView<?> parent) {
				setImageButton(null);
			}
		});
		
		mKeyAdapter = new ArrayAdapter<CharSequence>(this, R.layout.sexy_combo, ANDROID_KEYS);
		mKeyAdapter.setDropDownViewResource(R.layout.sexy_combo_dropdown);
		key_spinner.setAdapter(mKeyAdapter);
		key_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				setConfig(
						WIIMOTE_BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(position).toString()
						);
			}
	
			public void onNothingSelected(AdapterView<?> parent) {
				setConfig(
						WIIMOTE_BUTTONS.get(wii_spinner.getSelectedItemPosition()).toString(),
						ANDROID_KEYS.get(0).toString()
						);
			}
		});
	}
	
	private void setConfig(String wiiButton, String keyButton) {
		int keysym = ConfigManager.convertString(ConfigManager.convertHRToKeySym(keyButton));
		
		if(keysym > 0) {
			Toast.makeText(this, "Wiimote." + wiiButton + " = " + keyButton + " (" + keysym + ")", 5000).show();
		} else {
			Toast.makeText(this, "Key reset", 2000).show();
		}
	}
	
	private void setImageButton(String button) {
		if(button == null) {
			button = "";
		}
		
		if(button.equals(WIIMOTE_BUTTON_UP)) {
			setImageButton(1, R.drawable.wiimote_button_up);
		} else if(button.equals(WIIMOTE_BUTTON_LEFT)) {
			setImageButton(1, R.drawable.wiimote_button_left);
		} else if(button.equals(WIIMOTE_BUTTON_RIGHT)) {
			setImageButton(1, R.drawable.wiimote_button_right);
		} else if(button.equals(WIIMOTE_BUTTON_DOWN)) {
			setImageButton(1, R.drawable.wiimote_button_down);
		} else if(button.equals(WIIMOTE_BUTTON_A)) {
			setImageButton(1, R.drawable.wiimote_button_a);
		} else if(button.equals(WIIMOTE_BUTTON_B)) {
			setImageButton(-1, R.drawable.wiimote_button_b);
		} else if(button.equals(WIIMOTE_BUTTON_MINUS)) {
			setImageButton(1, R.drawable.wiimote_button_minus);
		} else if(button.equals(WIIMOTE_BUTTON_HOME)) {
			setImageButton(1, R.drawable.wiimote_button_home);
		} else if(button.equals(WIIMOTE_BUTTON_PLUS)) {
			setImageButton(1, R.drawable.wiimote_button_plus);
		} else if(button.equals(WIIMOTE_BUTTON_1)) {
			setImageButton(1, R.drawable.wiimote_button_1);
		} else if(button.equals(WIIMOTE_BUTTON_2)) {
			setImageButton(1, R.drawable.wiimote_button_2);
		} else {
			setImageButton(0, 0);
		}
	}
	
	private void setImageButton(int which, int resId) {
		setImageButton(which, resId, BUTTON_ALPHA);
	}
	
	private void setImageButton(int which, int resId, int alpha) {
		final ImageView wiimote_front_button = (ImageView)findViewById(R.id.config_wiimote_front_view_button);
		final ImageView wiimote_back_button = (ImageView)findViewById(R.id.config_wiimote_back_view_button);
		
		if (which > 0) {
			wiimote_front_button.setImageResource(resId);
			wiimote_front_button.setAlpha(alpha);
			wiimote_front_button.setVisibility(View.VISIBLE);
			wiimote_back_button.setVisibility(View.GONE);
		} else if(which < 0) {
			wiimote_back_button.setImageResource(resId);
			wiimote_back_button.setAlpha(alpha);
			wiimote_back_button.setVisibility(View.VISIBLE);
			wiimote_front_button.setVisibility(View.GONE);
		} else {
			wiimote_front_button.setVisibility(View.GONE);
			wiimote_back_button.setVisibility(View.GONE);
		}
	}
}
