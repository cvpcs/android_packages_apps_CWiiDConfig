package org.cvpcs.android.cwiidconfig.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nunchuk {
	public static final String NUNCHUK_BUTTON_UP 		= "Up";
	public static final String NUNCHUK_BUTTON_LEFT		= "Left";
	public static final String NUNCHUK_BUTTON_RIGHT		= "Right";
	public static final String NUNCHUK_BUTTON_DOWN		= "Down";
	public static final String NUNCHUK_BUTTON_C			= "C";
	public static final String NUNCHUK_BUTTON_Z			= "Z";
	
	public static final ArrayList<CharSequence> NUNCHUK_BUTTONS = new ArrayList<CharSequence>();
	static {
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_UP);
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_LEFT);
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_RIGHT);
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_DOWN);
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_C);
		NUNCHUK_BUTTONS.add(NUNCHUK_BUTTON_Z);
	}
	
	private static Pattern nunchukPattern = Pattern.compile(
			"(nunchuk|plugin.nunchuk_stick2btn)\\.([a-z0-9_]+)[ \t]*=[ \t]*([a-z0-9_]+)",
			Pattern.CASE_INSENSITIVE);
	
	private int buttonC = 0;
	private int buttonZ = 0;
	private int buttonUp = 0;
	private int buttonDown = 0;
	private int buttonLeft = 0;
	private int buttonRight = 0;
	private Matcher nunchukMatcher;

	public void setButtonC(int keysym) {
		buttonC = keysym;
	}
	
	public void setButtonZ(int keysym) {
		buttonZ = keysym;
	}
	
	public void setButtonUp(int keysym) {
		buttonUp = keysym;
	}
	
	public void setButtonDown(int keysym) {
		buttonDown = keysym;
	}
	
	public void setButtonLeft(int keysym) {
		buttonLeft = keysym;
	}
	
	public void setButtonRight(int keysym) {
		buttonRight = keysym;
	}

	public int getButtonC() {
		return buttonC;
	}
	
	public int getButtonZ() {
		return buttonZ;
	}
	
	public int getButtonUp() {
		return buttonUp;
	}
	
	public int getButtonDown() {
		return buttonDown;
	}
	
	public int getButtonLeft() {
		return buttonLeft;
	}
	
	public int getButtonRight() {
		return buttonRight;
	}
	
	public void setButton(String button, int keysym) {
		if (button.equalsIgnoreCase(NUNCHUK_BUTTON_C)) {
			setButtonC(keysym);
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_Z)) {
			setButtonZ(keysym);
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_UP)) {
			setButtonUp(keysym);
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_DOWN)) {
			setButtonDown(keysym);
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_LEFT)) {
			setButtonLeft(keysym);
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_RIGHT)) {
			setButtonRight(keysym);
		}
	}
	
	public int getButton(String button) {
		if (button.equalsIgnoreCase(NUNCHUK_BUTTON_C)) {
			return getButtonC();
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_Z)) {
			return getButtonZ();
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_UP)) {
			return getButtonUp();
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_DOWN)) {
			return getButtonDown();
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_LEFT)) {
			return getButtonLeft();
		} else if (button.equalsIgnoreCase(NUNCHUK_BUTTON_RIGHT)) {
			return getButtonRight();
		} else {
			return 0;
		}
	}
	
	public boolean readLine(String line) {
		if (line.length() <= 0 ||
		    line.charAt(0) == '#') {
			return false;
		}
		nunchukMatcher = nunchukPattern.matcher(line);
		if (nunchukMatcher.find()) {
			String button = nunchukMatcher.group(2);
			String value = nunchukMatcher.group(3);
			setButtonValue(button, value);
			return true;
		} else {
			return false;
		}
	}
	
	public void save(BufferedWriter bw) throws IOException {
		if (buttonC != 0) {
			bw.write("Nunchuk.C=" + ConfigManager.convertKeysym(buttonC) + "\n");
		}
		if (buttonZ != 0) {
			bw.write("Nunchuk.Z=" + ConfigManager.convertKeysym(buttonZ) + "\n");
		}
		if (buttonUp != 0) {
			bw.write("Plugin.nunchuk_stick2btn.Up=" + ConfigManager.convertKeysym(buttonUp) + "\n");
		}
		if (buttonDown != 0) {
			bw.write("Plugin.nunchuk_stick2btn.Down=" + ConfigManager.convertKeysym(buttonDown) + "\n");
		}
		if (buttonLeft != 0) {
			bw.write("Plugin.nunchuk_stick2btn.Left=" + ConfigManager.convertKeysym(buttonLeft) + "\n");
		}
		if (buttonRight != 0) {
			bw.write("Plugin.nunchuk_stick2btn.Right=" + ConfigManager.convertKeysym(buttonRight) + "\n");
		}
	}
	
	private void setButtonValue(String button, String value) {
		if (button.equalsIgnoreCase("C")) {
			setButtonC(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("Z")) {
			setButtonZ(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("UP")) {
			setButtonUp(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("DOWN")) {
			setButtonDown(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("LEFT")) {
			setButtonLeft(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("RIGHT")) {
			setButtonRight(ConfigManager.convertString(value));
		}
	}
}
