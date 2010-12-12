package org.cvpcs.android.cwiidconfig.activity;

import java.util.HashMap;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.Nunchuk;

public class ConfigNunchuk extends ConfigDevice {
	private static final Integer DEVICE_IMAGE_RES_ID = Integer.valueOf(R.drawable.nunchuk_multi);
	private static final HashMap<String, Integer> DEVICE_BUTTON_IMAGE_MAP = new HashMap<String, Integer>();
	
	static {
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_UP,       Integer.valueOf(R.drawable.nunchuk_button_up));
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_LEFT,     Integer.valueOf(R.drawable.nunchuk_button_left));
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_RIGHT,    Integer.valueOf(R.drawable.nunchuk_button_right));
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_DOWN,     Integer.valueOf(R.drawable.nunchuk_button_down));
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_C,        Integer.valueOf(R.drawable.nunchuk_button_c));
		DEVICE_BUTTON_IMAGE_MAP.put(Nunchuk.BUTTON_Z,        Integer.valueOf(R.drawable.nunchuk_button_z));
	}
	
	public ConfigNunchuk() {
		super();
		
		mDeviceName = Nunchuk.NAME;
		mDeviceImageResourceId = DEVICE_IMAGE_RES_ID;
		mDeviceButtons = Nunchuk.BUTTONS;
		mDeviceButtonImageMap = DEVICE_BUTTON_IMAGE_MAP;
	}
}
