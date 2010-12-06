package org.cvpcs.android.cwiidconfig.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;

public class Wiimote {
	public static final String WIIMOTE_BUTTON_UP 		= "Up";
	public static final String WIIMOTE_BUTTON_LEFT		= "Left";
	public static final String WIIMOTE_BUTTON_RIGHT		= "Right";
	public static final String WIIMOTE_BUTTON_DOWN		= "Down";
	public static final String WIIMOTE_BUTTON_A			= "A";
	public static final String WIIMOTE_BUTTON_B			= "B";
	public static final String WIIMOTE_BUTTON_MINUS		= "Minus";
	public static final String WIIMOTE_BUTTON_HOME		= "Home";
	public static final String WIIMOTE_BUTTON_PLUS		= "Plus";
	public static final String WIIMOTE_BUTTON_1			= "1";
	public static final String WIIMOTE_BUTTON_2			= "2";
	
	public static final ArrayList<CharSequence> WIIMOTE_BUTTONS = new ArrayList<CharSequence>();
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
	}

	private static Pattern wiimotePattern = Pattern.compile(
			"wiimote\\.([a-z0-9_]+)[ \t]*=[ \t]*([a-z0-9_]+)",
			Pattern.CASE_INSENSITIVE);
	
	private int buttonA = 0;
	private int buttonB = 0;
	private int button1 = 0;
	private int button2 = 0;
	private int buttonPlus = 0;
	private int buttonMinus = 0;
	private int buttonHome = 0;
	private int buttonUp = 0;
	private int buttonDown = 0;
	private int buttonLeft = 0;
	private int buttonRight = 0;
	private Matcher wiimoteMatcher;
	
	public void setButtonA(int keysym) {
		buttonA = keysym;
	}
	
	public void setButtonB(int keysym) {
		buttonB = keysym;
	}
	
	public void setButton1(int keysym) {
		button1 = keysym;
	}
	
	public void setButton2(int keysym) {
		button2 = keysym;
	}
	
	public void setButtonPlus(int keysym) {
		buttonPlus = keysym;
	}
	
	public void setButtonMinus(int keysym) {
		buttonMinus = keysym;
	}
	
	public void setButtonHome(int keysym) {
		buttonHome = keysym;
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
	
	public int getButtonA() {
		return buttonA;
	}
	
	public int getButtonB() {
		return buttonB;
	}
	
	public int getButton1() {
		return button1;
	}
	
	public int getButton2() {
		return button2;
	}
	
	public int getButtonPlus() {
		return buttonPlus;
	}
	
	public int getButtonMinus() {
		return buttonMinus;
	}
	
	public int getButtonHome() {
		return buttonHome;
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
		if (button.equalsIgnoreCase(WIIMOTE_BUTTON_A)) {
			setButtonA(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_B)) {
			setButtonB(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_1)) {
			setButton1(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_2)) {
			setButton2(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_PLUS)) {
			setButtonPlus(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_MINUS)) {
			setButtonMinus(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_HOME)) {
			setButtonHome(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_UP)) {
			setButtonUp(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_DOWN)) {
			setButtonDown(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_LEFT)) {
			setButtonLeft(keysym);
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_RIGHT)) {
			setButtonRight(keysym);
		}
	}
	
	public int getButton(String button) {
		if (button.equalsIgnoreCase(WIIMOTE_BUTTON_A)) {
			return getButtonA();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_B)) {
			return getButtonB();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_1)) {
			return getButton1();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_2)) {
			return getButton2();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_PLUS)) {
			return getButtonPlus();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_MINUS)) {
			return getButtonMinus();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_HOME)) {
			return getButtonHome();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_UP)) {
			return getButtonUp();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_DOWN)) {
			return getButtonDown();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_LEFT)) {
			return getButtonLeft();
		} else if (button.equalsIgnoreCase(WIIMOTE_BUTTON_RIGHT)) {
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
		wiimoteMatcher = wiimotePattern.matcher(line);
		if (wiimoteMatcher.find()) {
			String button = wiimoteMatcher.group(1);
			String value = wiimoteMatcher.group(2);
			setButtonValue(button, value);
			return true;
		} else {
			return false;
		}
	}
	
	public void save(BufferedWriter bw) throws IOException {
		if (buttonA != 0) {
			bw.write("Wiimote.A=" + ConfigManager.convertKeysym(buttonA) + "\n");
		}
		if (buttonB != 0) {
			bw.write("Wiimote.B=" + ConfigManager.convertKeysym(buttonB) + "\n");
		}
		if (button1 != 0) {
			bw.write("Wiimote.1=" + ConfigManager.convertKeysym(button1) + "\n");
		}
		if (button2 != 0) {
			bw.write("Wiimote.2=" + ConfigManager.convertKeysym(button2) + "\n");
		}
		if (buttonPlus != 0) {
			bw.write("Wiimote.Plus=" + ConfigManager.convertKeysym(buttonPlus) + "\n");
		}
		if (buttonMinus != 0) {
			bw.write("Wiimote.Minus=" + ConfigManager.convertKeysym(buttonMinus) + "\n");
		}
		if (buttonHome != 0) {
			bw.write("Wiimote.Home=" + ConfigManager.convertKeysym(buttonHome) + "\n");
		}
		if (buttonUp != 0) {
			bw.write("Wiimote.Up=" + ConfigManager.convertKeysym(buttonUp) + "\n");
		}
		if (buttonDown != 0) {
			bw.write("Wiimote.Down=" + ConfigManager.convertKeysym(buttonDown) + "\n");
		}
		if (buttonLeft != 0) {
			bw.write("Wiimote.Left=" + ConfigManager.convertKeysym(buttonLeft) + "\n");
		}
		if (buttonRight != 0) {
			bw.write("Wiimote.Right=" + ConfigManager.convertKeysym(buttonRight) + "\n");
		}
	}
	
	private void setButtonValue(String button, String value) {
		if (button.equalsIgnoreCase("A")) {
			setButtonA(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("B")) {
			setButtonB(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("1")) {
			setButton1(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("2")) {
			setButton2(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("PLUS")) {
			setButtonPlus(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("MINUS")) {
			setButtonMinus(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("HOME")) {
			setButtonHome(ConfigManager.convertString(value));
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
