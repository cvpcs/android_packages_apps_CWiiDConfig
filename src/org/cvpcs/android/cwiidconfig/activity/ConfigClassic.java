package org.cvpcs.android.cwiidconfig.activity;

import java.util.HashMap;

import org.cvpcs.android.cwiidconfig.R;
import org.cvpcs.android.cwiidconfig.config.ClassicController;

public class ConfigClassic extends ConfigDevice {
	private static final Integer DEVICE_IMAGE_RES_ID = Integer.valueOf(R.drawable.classic_front);
	private static final HashMap<String, Integer> DEVICE_BUTTON_IMAGE_MAP = new HashMap<String, Integer>();
	
	static {
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_UP,       Integer.valueOf(R.drawable.classic_button_up));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_LEFT,     Integer.valueOf(R.drawable.classic_button_left));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_RIGHT,    Integer.valueOf(R.drawable.classic_button_right));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_DOWN,     Integer.valueOf(R.drawable.classic_button_down));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_A,        Integer.valueOf(R.drawable.classic_button_a));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_B,        Integer.valueOf(R.drawable.classic_button_b));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_X,        Integer.valueOf(R.drawable.classic_button_x));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_Y,        Integer.valueOf(R.drawable.classic_button_y));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_L,        Integer.valueOf(R.drawable.classic_button_l));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_R,        Integer.valueOf(R.drawable.classic_button_r));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_ZL,       Integer.valueOf(R.drawable.classic_button_zl));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_ZR,       Integer.valueOf(R.drawable.classic_button_zr));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_PLUS,     Integer.valueOf(R.drawable.classic_button_plus));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_HOME,     Integer.valueOf(R.drawable.classic_button_home));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_MINUS,    Integer.valueOf(R.drawable.classic_button_minus));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_LS_UP,    Integer.valueOf(R.drawable.classic_button_lstick_up));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_LS_LEFT,  Integer.valueOf(R.drawable.classic_button_lstick_left));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_LS_RIGHT, Integer.valueOf(R.drawable.classic_button_lstick_right));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_LS_DOWN,  Integer.valueOf(R.drawable.classic_button_lstick_down));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_RS_UP,    Integer.valueOf(R.drawable.classic_button_rstick_up));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_RS_LEFT,  Integer.valueOf(R.drawable.classic_button_rstick_left));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_RS_RIGHT, Integer.valueOf(R.drawable.classic_button_rstick_right));
		DEVICE_BUTTON_IMAGE_MAP.put(ClassicController.BUTTON_RS_DOWN,  Integer.valueOf(R.drawable.classic_button_rstick_down));
	}
	
	public ConfigClassic() {
		super();
		
		mDeviceName = ClassicController.NAME;
		mDeviceImageResourceId = DEVICE_IMAGE_RES_ID;
		mDeviceButtons = ClassicController.BUTTONS;
		mDeviceButtonImageMap = DEVICE_BUTTON_IMAGE_MAP;
	}
}
