package org.cvpcs.android.cwiidconfig.config;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Nunchuk extends Device {
	public static String NAME = "Nunchuk";
	private static String PLUGIN_STICK2BTN = "Plugin.nunchuk_stick2btn";
	private static Pattern PATTERN = Pattern.compile(
			"((nunchuk|plugin.nunchuk_stick2btn)\\.[a-z0-9_]+)[ \t]*=[ \t]*([a-z0-9_]+)",
			Pattern.CASE_INSENSITIVE);
	
	public static final ArrayList<String> BUTTONS = new ArrayList<String>();
	private static final ArrayList<String> CONFIG_BUTTONS = new ArrayList<String>();
	
	public static final String BUTTON_UP 		= "Up";
	public static final String BUTTON_LEFT		= "Left";
	public static final String BUTTON_RIGHT		= "Right";
	public static final String BUTTON_DOWN		= "Down";
	public static final String BUTTON_C			= "C";
	public static final String BUTTON_Z			= "Z";
	
	static {
		BUTTONS.add(BUTTON_UP);
		BUTTONS.add(BUTTON_LEFT);
		BUTTONS.add(BUTTON_RIGHT);
		BUTTONS.add(BUTTON_DOWN);
		BUTTONS.add(BUTTON_C);
		BUTTONS.add(BUTTON_Z);

		CONFIG_BUTTONS.add(PLUGIN_STICK2BTN + "." + BUTTON_UP);
		CONFIG_BUTTONS.add(PLUGIN_STICK2BTN + "." + BUTTON_LEFT);
		CONFIG_BUTTONS.add(PLUGIN_STICK2BTN + "." + BUTTON_RIGHT);
		CONFIG_BUTTONS.add(PLUGIN_STICK2BTN + "." + BUTTON_DOWN);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_C);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_Z);
	}
	
	public Nunchuk() {
		super();
		mName = NAME;
		mButtons = BUTTONS;
		mConfigButtons = CONFIG_BUTTONS;
		mPattern = PATTERN;
	}
}
