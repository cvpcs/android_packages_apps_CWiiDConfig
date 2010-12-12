package org.cvpcs.android.cwiidconfig.activity;

import java.util.HashMap;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.Wiimote;

public class ConfigWiimote extends ConfigDevice {
	private static final Integer DEVICE_IMAGE_RES_ID = Integer.valueOf(R.drawable.wiimote_front_back);
	private static final HashMap<String, Integer> DEVICE_BUTTON_IMAGE_MAP = new HashMap<String, Integer>();
	
	static {
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_UP,       Integer.valueOf(R.drawable.wiimote_button_up));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_LEFT,     Integer.valueOf(R.drawable.wiimote_button_left));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_RIGHT,    Integer.valueOf(R.drawable.wiimote_button_right));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_DOWN,     Integer.valueOf(R.drawable.wiimote_button_down));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_A,        Integer.valueOf(R.drawable.wiimote_button_a));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_B,        Integer.valueOf(R.drawable.wiimote_button_b));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_PLUS,     Integer.valueOf(R.drawable.wiimote_button_plus));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_HOME,     Integer.valueOf(R.drawable.wiimote_button_home));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_MINUS,    Integer.valueOf(R.drawable.wiimote_button_minus));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_1,        Integer.valueOf(R.drawable.wiimote_button_1));
		DEVICE_BUTTON_IMAGE_MAP.put(Wiimote.BUTTON_2,        Integer.valueOf(R.drawable.wiimote_button_2));
	}
	
	public ConfigWiimote() {
		super();
		
		mDeviceName = Wiimote.NAME;
		mDeviceImageResourceId = DEVICE_IMAGE_RES_ID;
		mDeviceButtons = Wiimote.BUTTONS;
		mDeviceButtonImageMap = DEVICE_BUTTON_IMAGE_MAP;
	}
}
