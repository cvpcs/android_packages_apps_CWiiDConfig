package org.cvpcs.android.cwiidconfig.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassicController {
	public static final String CLASSIC_BUTTON_UP 		= "Up";
	public static final String CLASSIC_BUTTON_LEFT		= "Left";
	public static final String CLASSIC_BUTTON_RIGHT		= "Right";
	public static final String CLASSIC_BUTTON_DOWN		= "Down";
	public static final String CLASSIC_BUTTON_A			= "A";
	public static final String CLASSIC_BUTTON_B			= "B";
	public static final String CLASSIC_BUTTON_X			= "X";
	public static final String CLASSIC_BUTTON_Y			= "Y";
	public static final String CLASSIC_BUTTON_MINUS		= "Minus";
	public static final String CLASSIC_BUTTON_HOME		= "Home";
	public static final String CLASSIC_BUTTON_PLUS		= "Plus";
	public static final String CLASSIC_BUTTON_L			= "L";
	public static final String CLASSIC_BUTTON_R			= "R";
	public static final String CLASSIC_BUTTON_ZL		= "ZL";
	public static final String CLASSIC_BUTTON_ZR		= "ZR";
	
	public static final ArrayList<CharSequence> CLASSIC_BUTTONS = new ArrayList<CharSequence>();
	static {
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_UP);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_LEFT);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_RIGHT);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_DOWN);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_A);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_B);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_X);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_Y);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_MINUS);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_HOME);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_PLUS);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_L);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_R);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_ZL);
		CLASSIC_BUTTONS.add(CLASSIC_BUTTON_ZR);
	}
	
	private static Pattern classicControllerPattern = Pattern.compile(
			"classic\\.([a-z0-9_]+)[ \t]*=[ \t]*([a-z0-9_]+)",
			Pattern.CASE_INSENSITIVE);
	
	private int buttonA = 0;
	private int buttonB = 0;
	private int buttonX = 0;
	private int buttonY = 0;
	private int buttonR = 0;
	private int buttonL = 0;
	private int buttonZR = 0;
	private int buttonZL = 0;
	private int buttonPlus = 0;
	private int buttonMinus = 0;
	private int buttonHome = 0;
	private int buttonUp = 0;
	private int buttonDown = 0;
	private int buttonLeft = 0;
	private int buttonRight = 0;
	private Matcher classicControllerMatcher;

	public void setButtonA(int keysym) {
		buttonA = keysym;
	}
	
	public void setButtonB(int keysym) {
		buttonB = keysym;
	}
	
	public void setButtonX(int keysym) {
		buttonX = keysym;
	}
	
	public void setButtonY(int keysym) {
		buttonY = keysym;
	}
	
	public void setButtonR(int keysym) {
		buttonR = keysym;
	}
	
	public void setButtonL(int keysym) {
		buttonL = keysym;
	}
	
	public void setButtonZR(int keysym) {
		buttonZR = keysym;
	}
	
	public void setButtonZL(int keysym) {
		buttonZL = keysym;
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
	
	public int getButtonX() {
		return buttonX;
	}
	
	public int getButtonY() {
		return buttonY;
	}
	
	public int getButtonR() {
		return buttonR;
	}
	
	public int getButtonL() {
		return buttonL;
	}
	
	public int getButtonZR() {
		return buttonZR;
	}
	
	public int getButtonZL() {
		return buttonZL;
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
		if (button.equalsIgnoreCase(CLASSIC_BUTTON_A)) {
			setButtonA(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_B)) {
			setButtonB(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_X)) {
			setButtonX(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_Y)) {
			setButtonY(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_L)) {
			setButtonL(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_R)) {
			setButtonR(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_ZL)) {
			setButtonZL(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_ZR)) {
			setButtonZR(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_PLUS)) {
			setButtonPlus(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_MINUS)) {
			setButtonMinus(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_HOME)) {
			setButtonHome(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_UP)) {
			setButtonUp(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_DOWN)) {
			setButtonDown(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_LEFT)) {
			setButtonLeft(keysym);
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_RIGHT)) {
			setButtonRight(keysym);
		}
	}
	
	public int getButton(String button) {
		if (button.equalsIgnoreCase(CLASSIC_BUTTON_A)) {
			return getButtonA();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_B)) {
			return getButtonB();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_X)) {
			return getButtonX();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_Y)) {
			return getButtonY();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_L)) {
			return getButtonL();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_R)) {
			return getButtonR();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_ZL)) {
			return getButtonZL();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_ZR)) {
			return getButtonZR();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_PLUS)) {
			return getButtonPlus();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_MINUS)) {
			return getButtonMinus();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_HOME)) {
			return getButtonHome();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_UP)) {
			return getButtonUp();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_DOWN)) {
			return getButtonDown();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_LEFT)) {
			return getButtonLeft();
		} else if (button.equalsIgnoreCase(CLASSIC_BUTTON_RIGHT)) {
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
		classicControllerMatcher = classicControllerPattern.matcher(line);
		if (classicControllerMatcher.find()) {
			String button = classicControllerMatcher.group(1);
			String value = classicControllerMatcher.group(2);
			setButtonValue(button, value);
			return true;
		} else {
			return false;
		}
	}
	
	public void save(BufferedWriter bw) throws IOException {
		if (buttonA != 0) {
			bw.write("Classic.A=" + ConfigManager.convertKeysym(buttonA) + "\n");
		}
		if (buttonB != 0) {
			bw.write("Classic.B=" + ConfigManager.convertKeysym(buttonB) + "\n");
		}
		if (buttonX != 0) {
			bw.write("Classic.X=" + ConfigManager.convertKeysym(buttonX) + "\n");
		}
		if (buttonY != 0) {
			bw.write("Classic.Y=" + ConfigManager.convertKeysym(buttonY) + "\n");
		}
		if (buttonR != 0) {
			bw.write("Classic.R=" + ConfigManager.convertKeysym(buttonR) + "\n");
		}
		if (buttonL != 0) {
			bw.write("Classic.L=" + ConfigManager.convertKeysym(buttonL) + "\n");
		}
		if (buttonZR != 0) {
			bw.write("Classic.ZR=" + ConfigManager.convertKeysym(buttonZR) + "\n");
		}
		if (buttonZL != 0) {
			bw.write("Classic.ZL=" + ConfigManager.convertKeysym(buttonZL) + "\n");
		}
		if (buttonPlus != 0) {
			bw.write("Classic.Plus=" + ConfigManager.convertKeysym(buttonPlus) + "\n");
		}
		if (buttonMinus != 0) {
			bw.write("Classic.Minus=" + ConfigManager.convertKeysym(buttonMinus) + "\n");
		}
		if (buttonHome != 0) {
			bw.write("Classic.Home=" + ConfigManager.convertKeysym(buttonHome) + "\n");
		}
		if (buttonUp != 0) {
			bw.write("Classic.Up=" + ConfigManager.convertKeysym(buttonUp) + "\n");
		}
		if (buttonDown != 0) {
			bw.write("Classic.Down=" + ConfigManager.convertKeysym(buttonDown) + "\n");
		}
		if (buttonLeft != 0) {
			bw.write("Classic.Left=" + ConfigManager.convertKeysym(buttonLeft) + "\n");
		}
		if (buttonRight != 0) {
			bw.write("Classic.Right=" + ConfigManager.convertKeysym(buttonRight) + "\n");
		}
	}
	
	private void setButtonValue(String button, String value) {
		if (button.equalsIgnoreCase("A")) {
			setButtonA(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("B")) {
			setButtonB(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("X")) {
			setButtonX(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("Y")) {
			setButtonY(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("R")) {
			setButtonR(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("L")) {
			setButtonL(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("ZR")) {
			setButtonZR(ConfigManager.convertString(value));
		} else if (button.equalsIgnoreCase("ZL")) {
			setButtonZL(ConfigManager.convertString(value));
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
