package org.cvpcs.android.cwiidconfig.config;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ClassicController extends Device {
	public static final String NAME = "Classic";
	private static final Pattern PATTERN = Pattern.compile(
			"((classic)\\.[a-z0-9_]+)[ \t]*=[ \t]*([a-z0-9_]+)",
			Pattern.CASE_INSENSITIVE);

	public static final ArrayList<String> BUTTONS = new ArrayList<String>();
	private static final ArrayList<String> CONFIG_BUTTONS = new ArrayList<String>();
	
	public static final String BUTTON_UP 		= "Up";
	public static final String BUTTON_LEFT		= "Left";
	public static final String BUTTON_RIGHT		= "Right";
	public static final String BUTTON_DOWN		= "Down";
	public static final String BUTTON_A			= "A";
	public static final String BUTTON_B			= "B";
	public static final String BUTTON_X			= "X";
	public static final String BUTTON_Y			= "Y";
	public static final String BUTTON_MINUS		= "Minus";
	public static final String BUTTON_HOME		= "Home";
	public static final String BUTTON_PLUS		= "Plus";
	public static final String BUTTON_L			= "L";
	public static final String BUTTON_R			= "R";
	public static final String BUTTON_ZL		= "ZL";
	public static final String BUTTON_ZR		= "ZR";
	
	static {
		BUTTONS.add(BUTTON_UP);
		BUTTONS.add(BUTTON_LEFT);
		BUTTONS.add(BUTTON_RIGHT);
		BUTTONS.add(BUTTON_DOWN);
		BUTTONS.add(BUTTON_A);
		BUTTONS.add(BUTTON_B);
		BUTTONS.add(BUTTON_X);
		BUTTONS.add(BUTTON_Y);
		BUTTONS.add(BUTTON_MINUS);
		BUTTONS.add(BUTTON_HOME);
		BUTTONS.add(BUTTON_PLUS);
		BUTTONS.add(BUTTON_L);
		BUTTONS.add(BUTTON_R);
		BUTTONS.add(BUTTON_ZL);
		BUTTONS.add(BUTTON_ZR);

		CONFIG_BUTTONS.add(NAME + "." + BUTTON_UP);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_LEFT);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_RIGHT);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_DOWN);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_A);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_B);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_X);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_Y);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_MINUS);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_HOME);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_PLUS);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_L);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_R);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_ZL);
		CONFIG_BUTTONS.add(NAME + "." + BUTTON_ZR);
	}
	
	public ClassicController() {
		super();
		mName = NAME;
		mButtons = BUTTONS;
		mConfigButtons = CONFIG_BUTTONS;
		mPattern = PATTERN;
	}
}
