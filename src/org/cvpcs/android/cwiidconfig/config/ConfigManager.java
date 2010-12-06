package org.cvpcs.android.cwiidconfig.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigManager {
	public static final String KEYSYM_ESC = "KEY_ESC";
	public static final String KEYSYM_1 = "KEY_1";
	public static final String KEYSYM_2 = "KEY_2";
	public static final String KEYSYM_3 = "KEY_3";
	public static final String KEYSYM_4 = "KEY_4";
	public static final String KEYSYM_5 = "KEY_5";
	public static final String KEYSYM_6 = "KEY_6";
	public static final String KEYSYM_7 = "KEY_7";
	public static final String KEYSYM_8 = "KEY_8";
	public static final String KEYSYM_9 = "KEY_9";
	public static final String KEYSYM_0 = "KEY_0";
	public static final String KEYSYM_MINUS = "KEY_MINUS";
	public static final String KEYSYM_EQUAL = "KEY_EQUAL";
	public static final String KEYSYM_BACKSPACE = "KEY_BACKSPACE";
	public static final String KEYSYM_TAB = "KEY_TAB";
	public static final String KEYSYM_Q = "KEY_Q";
	public static final String KEYSYM_W = "KEY_W";
	public static final String KEYSYM_E = "KEY_E";
	public static final String KEYSYM_R = "KEY_R";
	public static final String KEYSYM_T = "KEY_T";
	public static final String KEYSYM_Y = "KEY_Y";
	public static final String KEYSYM_U = "KEY_U";
	public static final String KEYSYM_I = "KEY_I";
	public static final String KEYSYM_O = "KEY_O";
	public static final String KEYSYM_P = "KEY_P";
	public static final String KEYSYM_LEFTBRACE = "KEY_LEFTBRACE";
	public static final String KEYSYM_RIGHTBRACE = "KEY_RIGHTBRACE";
	public static final String KEYSYM_ENTER = "KEY_ENTER";
	public static final String KEYSYM_LEFTCTRL = "KEY_LEFTCTRL";
	public static final String KEYSYM_A = "KEY_A";
	public static final String KEYSYM_S = "KEY_S";
	public static final String KEYSYM_D = "KEY_D";
	public static final String KEYSYM_F = "KEY_F";
	public static final String KEYSYM_G = "KEY_G";
	public static final String KEYSYM_H = "KEY_H";
	public static final String KEYSYM_J = "KEY_J";
	public static final String KEYSYM_K = "KEY_K";
	public static final String KEYSYM_L = "KEY_L";
	public static final String KEYSYM_SEMICOLON = "KEY_SEMICOLON";
	public static final String KEYSYM_APOSTROPHE = "KEY_APOSTROPHE";
	public static final String KEYSYM_GRAVE = "KEY_GRAVE";
	public static final String KEYSYM_LEFTSHIFT = "KEY_LEFTSHIFT";
	public static final String KEYSYM_BACKSLASH = "KEY_BACKSLASH";
	public static final String KEYSYM_Z = "KEY_Z";
	public static final String KEYSYM_X = "KEY_X";
	public static final String KEYSYM_C = "KEY_C";
	public static final String KEYSYM_V = "KEY_V";
	public static final String KEYSYM_B = "KEY_B";
	public static final String KEYSYM_N = "KEY_N";
	public static final String KEYSYM_M = "KEY_M";
	public static final String KEYSYM_COMMA = "KEY_COMMA";
	public static final String KEYSYM_DOT = "KEY_DOT";
	public static final String KEYSYM_SLASH = "KEY_SLASH";
	public static final String KEYSYM_RIGHTSHIFT = "KEY_RIGHTSHIFT";
	public static final String KEYSYM_KPASTERISK = "KEY_KPASTERISK";
	public static final String KEYSYM_LEFTALT = "KEY_LEFTALT";
	public static final String KEYSYM_SPACE = "KEY_SPACE";
	public static final String KEYSYM_CAPSLOCK = "KEY_CAPSLOCK";
	public static final String KEYSYM_F1 = "KEY_F1";
	public static final String KEYSYM_F2 = "KEY_F2";
	public static final String KEYSYM_F3 = "KEY_F3";
	public static final String KEYSYM_F4 = "KEY_F4";
	public static final String KEYSYM_F5 = "KEY_F5";
	public static final String KEYSYM_F6 = "KEY_F6";
	public static final String KEYSYM_F7 = "KEY_F7";
	public static final String KEYSYM_F8 = "KEY_F8";
	public static final String KEYSYM_F9 = "KEY_F9";
	public static final String KEYSYM_F10 = "KEY_F10";
	public static final String KEYSYM_NUMLOCK = "KEY_NUMLOCK";
	public static final String KEYSYM_SCROLLLOCK = "KEY_SCROLLLOCK";
	public static final String KEYSYM_KP7 = "KEY_KP7";
	public static final String KEYSYM_KP8 = "KEY_KP8";
	public static final String KEYSYM_KP9 = "KEY_KP9";
	public static final String KEYSYM_KPMINUS = "KEY_KPMINUS";
	public static final String KEYSYM_KP4 = "KEY_KP4";
	public static final String KEYSYM_KP5 = "KEY_KP5";
	public static final String KEYSYM_KP6 = "KEY_KP6";
	public static final String KEYSYM_KPPLUS = "KEY_KPPLUS";
	public static final String KEYSYM_KP1 = "KEY_KP1";
	public static final String KEYSYM_KP2 = "KEY_KP2";
	public static final String KEYSYM_KP3 = "KEY_KP3";
	public static final String KEYSYM_KP0 = "KEY_KP0";
	public static final String KEYSYM_KPDOT = "KEY_KPDOT";
	public static final String KEYSYM_ZENKAKUHANKAKU = "KEY_ZENKAKUHANKAKU";
	public static final String KEYSYM_102ND = "KEY_102ND";
	public static final String KEYSYM_F11 = "KEY_F11";
	public static final String KEYSYM_F12 = "KEY_F12";
	public static final String KEYSYM_RO = "KEY_RO";
	public static final String KEYSYM_KATAKANA = "KEY_KATAKANA";
	public static final String KEYSYM_HIRAGANA = "KEY_HIRAGANA";
	public static final String KEYSYM_HENKAN = "KEY_HENKAN";
	public static final String KEYSYM_KATAKANAHIRAGANA = "KEY_KATAKANAHIRAGANA";
	public static final String KEYSYM_MUHENKAN = "KEY_MUHENKAN";
	public static final String KEYSYM_KPJPCOMMA = "KEY_KPJPCOMMA";
	public static final String KEYSYM_KPENTER = "KEY_KPENTER";
	public static final String KEYSYM_RIGHTCTRL = "KEY_RIGHTCTRL";
	public static final String KEYSYM_KPSLASH = "KEY_KPSLASH";
	public static final String KEYSYM_SYSRQ = "KEY_SYSRQ";
	public static final String KEYSYM_RIGHTALT = "KEY_RIGHTALT";
	public static final String KEYSYM_LINEFEED = "KEY_LINEFEED";
	public static final String KEYSYM_HOME = "KEY_HOME";
	public static final String KEYSYM_UP = "KEY_UP";
	public static final String KEYSYM_PAGEUP = "KEY_PAGEUP";
	public static final String KEYSYM_LEFT = "KEY_LEFT";
	public static final String KEYSYM_RIGHT = "KEY_RIGHT";
	public static final String KEYSYM_END = "KEY_END";
	public static final String KEYSYM_DOWN = "KEY_DOWN";
	public static final String KEYSYM_PAGEDOWN = "KEY_PAGEDOWN";
	public static final String KEYSYM_INSERT = "KEY_INSERT";
	public static final String KEYSYM_DELETE = "KEY_DELETE";
	public static final String KEYSYM_MACRO = "KEY_MACRO";
	public static final String KEYSYM_MUTE = "KEY_MUTE";
	public static final String KEYSYM_VOLUMEDOWN = "KEY_VOLUMEDOWN";
	public static final String KEYSYM_VOLUMEUP = "KEY_VOLUMEUP";
	public static final String KEYSYM_POWER = "KEY_POWER";
	public static final String KEYSYM_KPEQUAL = "KEY_KPEQUAL";
	public static final String KEYSYM_KPPLUSMINUS = "KEY_KPPLUSMINUS";
	public static final String KEYSYM_PAUSE = "KEY_PAUSE";
	public static final String KEYSYM_KPCOMMA = "KEY_KPCOMMA";
	public static final String KEYSYM_HANGUEL = "KEY_HANGUEL";
	public static final String KEYSYM_HANJA = "KEY_HANJA";
	public static final String KEYSYM_YEN = "KEY_YEN";
	public static final String KEYSYM_LEFTMETA = "KEY_LEFTMETA";
	public static final String KEYSYM_RIGHTMETA = "KEY_RIGHTMETA";
	public static final String KEYSYM_COMPOSE = "KEY_COMPOSE";
	public static final String KEYSYM_STOP = "KEY_STOP";
	public static final String KEYSYM_AGAIN = "KEY_AGAIN";
	public static final String KEYSYM_PROPS = "KEY_PROPS";
	public static final String KEYSYM_UNDO = "KEY_UNDO";
	public static final String KEYSYM_FRONT = "KEY_FRONT";
	public static final String KEYSYM_COPY = "KEY_COPY";
	public static final String KEYSYM_OPEN = "KEY_OPEN";
	public static final String KEYSYM_PASTE = "KEY_PASTE";
	public static final String KEYSYM_FIND = "KEY_FIND";
	public static final String KEYSYM_CUT = "KEY_CUT";
	public static final String KEYSYM_HELP = "KEY_HELP";
	public static final String KEYSYM_MENU = "KEY_MENU";
	public static final String KEYSYM_CALC = "KEY_CALC";
	public static final String KEYSYM_SETUP = "KEY_SETUP";
	public static final String KEYSYM_SLEEP = "KEY_SLEEP";
	public static final String KEYSYM_WAKEUP = "KEY_WAKEUP";
	public static final String KEYSYM_FILE = "KEY_FILE";
	public static final String KEYSYM_SENDFILE = "KEY_SENDFILE";
	public static final String KEYSYM_DELETEFILE = "KEY_DELETEFILE";
	public static final String KEYSYM_XFER = "KEY_XFER";
	public static final String KEYSYM_PROG1 = "KEY_PROG1";
	public static final String KEYSYM_PROG2 = "KEY_PROG2";
	public static final String KEYSYM_WWW = "KEY_WWW";
	public static final String KEYSYM_MSDOS = "KEY_MSDOS";
	public static final String KEYSYM_COFFEE = "KEY_COFFEE";
	public static final String KEYSYM_DIRECTION = "KEY_DIRECTION";
	public static final String KEYSYM_CYCLEWINDOWS = "KEY_CYCLEWINDOWS";
	public static final String KEYSYM_MAIL = "KEY_MAIL";
	public static final String KEYSYM_BOOKMARKS = "KEY_BOOKMARKS";
	public static final String KEYSYM_COMPUTER = "KEY_COMPUTER";
	public static final String KEYSYM_BACK = "KEY_BACK";
	public static final String KEYSYM_FORWARD = "KEY_FORWARD";
	public static final String KEYSYM_CLOSECD = "KEY_CLOSECD";
	public static final String KEYSYM_EJECTCD = "KEY_EJECTCD";
	public static final String KEYSYM_EJECTCLOSECD = "KEY_EJECTCLOSECD";
	public static final String KEYSYM_NEXTSONG = "KEY_NEXTSONG";
	public static final String KEYSYM_PLAYPAUSE = "KEY_PLAYPAUSE";
	public static final String KEYSYM_PREVIOUSSONG = "KEY_PREVIOUSSONG";
	public static final String KEYSYM_STOPCD = "KEY_STOPCD";
	public static final String KEYSYM_RECORD = "KEY_RECORD";
	public static final String KEYSYM_REWIND = "KEY_REWIND";
	public static final String KEYSYM_PHONE = "KEY_PHONE";
	public static final String KEYSYM_ISO = "KEY_ISO";
	public static final String KEYSYM_CONFIG = "KEY_CONFIG";
	public static final String KEYSYM_HOMEPAGE = "KEY_HOMEPAGE";
	public static final String KEYSYM_REFRESH = "KEY_REFRESH";
	public static final String KEYSYM_EXIT = "KEY_EXIT";
	public static final String KEYSYM_MOVE = "KEY_MOVE";
	public static final String KEYSYM_EDIT = "KEY_EDIT";
	public static final String KEYSYM_SCROLLUP = "KEY_SCROLLUP";
	public static final String KEYSYM_SCROLLDOWN = "KEY_SCROLLDOWN";
	public static final String KEYSYM_KPLEFTPAREN = "KEY_KPLEFTPAREN";
	public static final String KEYSYM_KPRIGHTPAREN = "KEY_KPRIGHTPAREN";
	public static final String KEYSYM_NEW = "KEY_NEW";
	public static final String KEYSYM_REDO = "KEY_REDO";
	public static final String KEYSYM_F13 = "KEY_F13";
	public static final String KEYSYM_F14 = "KEY_F14";
	public static final String KEYSYM_F15 = "KEY_F15";
	public static final String KEYSYM_F16 = "KEY_F16";
	public static final String KEYSYM_F17 = "KEY_F17";
	public static final String KEYSYM_F18 = "KEY_F18";
	public static final String KEYSYM_F19 = "KEY_F19";
	public static final String KEYSYM_F20 = "KEY_F20";
	public static final String KEYSYM_F21 = "KEY_F21";
	public static final String KEYSYM_F22 = "KEY_F22";
	public static final String KEYSYM_F23 = "KEY_F23";
	public static final String KEYSYM_F24 = "KEY_F24";
	public static final String KEYSYM_PLAYCD = "KEY_PLAYCD";
	public static final String KEYSYM_PAUSECD = "KEY_PAUSECD";
	public static final String KEYSYM_PROG3 = "KEY_PROG3";
	public static final String KEYSYM_PROG4 = "KEY_PROG4";
	public static final String KEYSYM_SUSPEND = "KEY_SUSPEND";
	public static final String KEYSYM_CLOSE = "KEY_CLOSE";
	public static final String KEYSYM_PLAY = "KEY_PLAY";
	public static final String KEYSYM_FASTFORWARD = "KEY_FASTFORWARD";
	public static final String KEYSYM_BASSBOOST = "KEY_BASSBOOST";
	public static final String KEYSYM_PRINT = "KEY_PRINT";
	public static final String KEYSYM_HP = "KEY_HP";
	public static final String KEYSYM_CAMERA = "KEY_CAMERA";
	public static final String KEYSYM_SOUND = "KEY_SOUND";
	public static final String KEYSYM_QUESTION = "KEY_QUESTION";
	public static final String KEYSYM_EMAIL = "KEY_EMAIL";
	public static final String KEYSYM_CHAT = "KEY_CHAT";
	public static final String KEYSYM_SEARCH = "KEY_SEARCH";
	public static final String KEYSYM_CONNECT = "KEY_CONNECT";
	public static final String KEYSYM_FINANCE = "KEY_FINANCE";
	public static final String KEYSYM_SPORT = "KEY_SPORT";
	public static final String KEYSYM_SHOP = "KEY_SHOP";
	public static final String KEYSYM_ALTERASE = "KEY_ALTERASE";
	public static final String KEYSYM_CANCEL = "KEY_CANCEL";
	public static final String KEYSYM_BRIGHTNESSDOWN = "KEY_BRIGHTNESSDOWN";
	public static final String KEYSYM_BRIGHTNESSUP = "KEY_BRIGHTNESSUP";
	public static final String KEYSYM_MEDIA = "KEY_MEDIA";
	public static final String KEYSYM_SWITCHVIDEOMODE = "KEY_SWITCHVIDEOMODE";
	public static final String KEYSYM_KBDILLUMTOGGLE = "KEY_KBDILLUMTOGGLE";
	public static final String KEYSYM_KBDILLUMDOWN = "KEY_KBDILLUMDOWN";
	public static final String KEYSYM_KBDILLUMUP = "KEY_KBDILLUMUP";
	public static final String KEYSYM_SEND = "KEY_SEND";
	public static final String KEYSYM_REPLY = "KEY_REPLY";
	public static final String KEYSYM_FORWARDMAIL = "KEY_FORWARDMAIL";
	public static final String KEYSYM_SAVE = "KEY_SAVE";
	public static final String KEYSYM_DOCUMENTS = "KEY_DOCUMENTS";
	public static final String KEYSYM_BATTERY = "KEY_BATTERY";
	public static final String KEYSYM_UNKNOWN = "KEY_UNKNOWN";
	
	public static final ArrayList<CharSequence> ANDROID_KEYS = new ArrayList<CharSequence>();
	
	static {
		// LETTERS
		ANDROID_KEYS.add("A");
		ANDROID_KEYS.add("B");
		ANDROID_KEYS.add("C");
		ANDROID_KEYS.add("D");
		ANDROID_KEYS.add("E");
		ANDROID_KEYS.add("F");
		ANDROID_KEYS.add("G");
		ANDROID_KEYS.add("H");
		ANDROID_KEYS.add("I");
		ANDROID_KEYS.add("J");
		ANDROID_KEYS.add("K");
		ANDROID_KEYS.add("L");
		ANDROID_KEYS.add("M");
		ANDROID_KEYS.add("N");
		ANDROID_KEYS.add("O");
		ANDROID_KEYS.add("P");
		ANDROID_KEYS.add("Q");
		ANDROID_KEYS.add("R");
		ANDROID_KEYS.add("S");
		ANDROID_KEYS.add("T");
		ANDROID_KEYS.add("U");
		ANDROID_KEYS.add("V");
		ANDROID_KEYS.add("W");
		ANDROID_KEYS.add("X");
		ANDROID_KEYS.add("Y");
		ANDROID_KEYS.add("Z");
		// NUMBERS
		ANDROID_KEYS.add("0");
		ANDROID_KEYS.add("1");
		ANDROID_KEYS.add("2");
		ANDROID_KEYS.add("3");
		ANDROID_KEYS.add("4");
		ANDROID_KEYS.add("5");
		ANDROID_KEYS.add("6");
		ANDROID_KEYS.add("7");
		ANDROID_KEYS.add("8");
		ANDROID_KEYS.add("9");
		// MOVEMENT
		ANDROID_KEYS.add("Up");
		ANDROID_KEYS.add("Down");
		ANDROID_KEYS.add("Left");
		ANDROID_KEYS.add("Right");
		// Android-associated
		ANDROID_KEYS.add("Back");
		ANDROID_KEYS.add("Home");
		ANDROID_KEYS.add("Search");
		ANDROID_KEYS.add("Camera");
		// Volume-related
		ANDROID_KEYS.add("Mute");
		ANDROID_KEYS.add("Volume Up");
		ANDROID_KEYS.add("Volume Down");
		// Music related
		ANDROID_KEYS.add("Play");
		ANDROID_KEYS.add("Pause");
		ANDROID_KEYS.add("Play/Pause");
		ANDROID_KEYS.add("Stop");
		ANDROID_KEYS.add("Next Song");
		ANDROID_KEYS.add("Previous Song");
		// Display related
		ANDROID_KEYS.add("Brightness Up");
		ANDROID_KEYS.add("Brightness Down");
		// Other
		ANDROID_KEYS.add("Escape");
		ANDROID_KEYS.add("Enter");
		ANDROID_KEYS.add("Backspace");
		ANDROID_KEYS.add("Tab");
		ANDROID_KEYS.add("Left Ctrl");
		ANDROID_KEYS.add("Left Alt");
		ANDROID_KEYS.add("Left Shift");
		ANDROID_KEYS.add("Right Ctrl");
		ANDROID_KEYS.add("Right Alt");
		ANDROID_KEYS.add("Right Shift");
		ANDROID_KEYS.add("Slash");
		ANDROID_KEYS.add("Space");
		ANDROID_KEYS.add("Caps Lock");
		ANDROID_KEYS.add("Page Up");
		ANDROID_KEYS.add("Page Down");
		ANDROID_KEYS.add("Insert");
		ANDROID_KEYS.add("Delete");
		ANDROID_KEYS.add("Search");
	}
	
	/**
	 * Saves configuration data to a file
	 * @param config config object to save
	 * @param file file to save to
	 */
	public static boolean save(Config config, File file) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(file));
			config.save(bw);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Loads configuration data into memory
	 * @param file file to load configuration data from
	 * @return config object with configuration data
	 */
	public static Config load(File file) {
		BufferedReader br;
		Config config;
		try {
			br = new BufferedReader(new FileReader(file));
			config = new Config(br);
		} catch (IOException e) {
			return null;
		}
		if (config.getName().equals("")) {
			config.setName(file.getName());
		}
		return config;
	}
	
	/**
	 * Change keysym integer to a KEY_* string
	 * @param v keysym value
	 * @return KEY_* string
	 */
	public static String convertKeysym(int v) {
		switch (v) {
		case 1:
			return KEYSYM_ESC;
		case 2:
			return KEYSYM_1;
		case 3:
			return KEYSYM_2;
		case 4:
			return KEYSYM_3;
		case 5:
			return KEYSYM_4;
		case 6:
			return KEYSYM_5;
		case 7:
			return KEYSYM_6;
		case 8:
			return KEYSYM_7;
		case 9:
			return KEYSYM_8;
		case 10:
			return KEYSYM_9;
		case 11:
			return KEYSYM_0;
		case 12:
			return KEYSYM_MINUS;
		case 13:
			return KEYSYM_EQUAL;
		case 14:
			return KEYSYM_BACKSPACE;
		case 15:
			return KEYSYM_TAB;
		case 16:
			return KEYSYM_Q;
		case 17:
			return KEYSYM_W;
		case 18:
			return KEYSYM_E;
		case 19:
			return KEYSYM_R;
		case 20:
			return KEYSYM_T;
		case 21:
			return KEYSYM_Y;
		case 22:
			return KEYSYM_U;
		case 23:
			return KEYSYM_I;
		case 24:
			return KEYSYM_O;
		case 25:
			return KEYSYM_P;
		case 26:
			return KEYSYM_LEFTBRACE;
		case 27:
			return KEYSYM_RIGHTBRACE;
		case 28:
			return KEYSYM_ENTER;
		case 29:
			return KEYSYM_LEFTCTRL;
		case 30:
			return KEYSYM_A;
		case 31:
			return KEYSYM_S;
		case 32:
			return KEYSYM_D;
		case 33:
			return KEYSYM_F;
		case 34:
			return KEYSYM_G;
		case 35:
			return KEYSYM_H;
		case 36:
			return KEYSYM_J;
		case 37:
			return KEYSYM_K;
		case 38:
			return KEYSYM_L;
		case 39:
			return KEYSYM_SEMICOLON;
		case 40:
			return KEYSYM_APOSTROPHE;
		case 41:
			return KEYSYM_GRAVE;
		case 42:
			return KEYSYM_LEFTSHIFT;
		case 43:
			return KEYSYM_BACKSLASH;
		case 44:
			return KEYSYM_Z;
		case 45:
			return KEYSYM_X;
		case 46:
			return KEYSYM_C;
		case 47:
			return KEYSYM_V;
		case 48:
			return KEYSYM_B;
		case 49:
			return KEYSYM_N;
		case 50:
			return KEYSYM_M;
		case 51:
			return KEYSYM_COMMA;
		case 52:
			return KEYSYM_DOT;
		case 53:
			return KEYSYM_SLASH;
		case 54:
			return KEYSYM_RIGHTSHIFT;
		case 55:
			return KEYSYM_KPASTERISK;
		case 56:
			return KEYSYM_LEFTALT;
		case 57:
			return KEYSYM_SPACE;
		case 58:
			return KEYSYM_CAPSLOCK;
		case 59:
			return KEYSYM_F1;
		case 60:
			return KEYSYM_F2;
		case 61:
			return KEYSYM_F3;
		case 62:
			return KEYSYM_F4;
		case 63:
			return KEYSYM_F5;
		case 64:
			return KEYSYM_F6;
		case 65:
			return KEYSYM_F7;
		case 66:
			return KEYSYM_F8;
		case 67:
			return KEYSYM_F9;
		case 68:
			return KEYSYM_F10;
		case 69:
			return KEYSYM_NUMLOCK;
		case 70:
			return KEYSYM_SCROLLLOCK;
		case 71:
			return KEYSYM_KP7;
		case 72:
			return KEYSYM_KP8;
		case 73:
			return KEYSYM_KP9;
		case 74:
			return KEYSYM_KPMINUS;
		case 75:
			return KEYSYM_KP4;
		case 76:
			return KEYSYM_KP5;
		case 77:
			return KEYSYM_KP6;
		case 78:
			return KEYSYM_KPPLUS;
		case 79:
			return KEYSYM_KP1;
		case 80:
			return KEYSYM_KP2;
		case 81:
			return KEYSYM_KP3;
		case 82:
			return KEYSYM_KP0;
		case 83:
			return KEYSYM_KPDOT;
		case 85:
			return KEYSYM_ZENKAKUHANKAKU;
		case 86:
			return KEYSYM_102ND;
		case 87:
			return KEYSYM_F11;
		case 88:
			return KEYSYM_F12;
		case 89:
			return KEYSYM_RO;
		case 90:
			return KEYSYM_KATAKANA;
		case 91:
			return KEYSYM_HIRAGANA;
		case 92:
			return KEYSYM_HENKAN;
		case 93:
			return KEYSYM_KATAKANAHIRAGANA;
		case 94:
			return KEYSYM_MUHENKAN;
		case 95:
			return KEYSYM_KPJPCOMMA;
		case 96:
			return KEYSYM_KPENTER;
		case 97:
			return KEYSYM_RIGHTCTRL;
		case 98:
			return KEYSYM_KPSLASH;
		case 99:
			return KEYSYM_SYSRQ;
		case 100:
			return KEYSYM_RIGHTALT;
		case 101:
			return KEYSYM_LINEFEED;
		case 102:
			return KEYSYM_HOME;
		case 103:
			return KEYSYM_UP;
		case 104:
			return KEYSYM_PAGEUP;
		case 105:
			return KEYSYM_LEFT;
		case 106:
			return KEYSYM_RIGHT;
		case 107:
			return KEYSYM_END;
		case 108:
			return KEYSYM_DOWN;
		case 109:
			return KEYSYM_PAGEDOWN;
		case 110:
			return KEYSYM_INSERT;
		case 111:
			return KEYSYM_DELETE;
		case 112:
			return KEYSYM_MACRO;
		case 113:
			return KEYSYM_MUTE;
		case 114:
			return KEYSYM_VOLUMEDOWN;
		case 115:
			return KEYSYM_VOLUMEUP;
		case 116:
			return KEYSYM_POWER;
		case 117:
			return KEYSYM_KPEQUAL;
		case 118:
			return KEYSYM_KPPLUSMINUS;
		case 119:
			return KEYSYM_PAUSE;
		case 121:
			return KEYSYM_KPCOMMA;
		case 122:
			return KEYSYM_HANGUEL;
		case 123:
			return KEYSYM_HANJA;
		case 124:
			return KEYSYM_YEN;
		case 125:
			return KEYSYM_LEFTMETA;
		case 126:
			return KEYSYM_RIGHTMETA;
		case 127:
			return KEYSYM_COMPOSE;
		case 128:
			return KEYSYM_STOP;
		case 129:
			return KEYSYM_AGAIN;
		case 130:
			return KEYSYM_PROPS;
		case 131:
			return KEYSYM_UNDO;
		case 132:
			return KEYSYM_FRONT;
		case 133:
			return KEYSYM_COPY;
		case 134:
			return KEYSYM_OPEN;
		case 135:
			return KEYSYM_PASTE;
		case 136:
			return KEYSYM_FIND;
		case 137:
			return KEYSYM_CUT;
		case 138:
			return KEYSYM_HELP;
		case 139:
			return KEYSYM_MENU;
		case 140:
			return KEYSYM_CALC;
		case 141:
			return KEYSYM_SETUP;
		case 142:
			return KEYSYM_SLEEP;
		case 143:
			return KEYSYM_WAKEUP;
		case 144:
			return KEYSYM_FILE;
		case 145:
			return KEYSYM_SENDFILE;
		case 146:
			return KEYSYM_DELETEFILE;
		case 147:
			return KEYSYM_XFER;
		case 148:
			return KEYSYM_PROG1;
		case 149:
			return KEYSYM_PROG2;
		case 150:
			return KEYSYM_WWW;
		case 151:
			return KEYSYM_MSDOS;
		case 152:
			return KEYSYM_COFFEE;
		case 153:
			return KEYSYM_DIRECTION;
		case 154:
			return KEYSYM_CYCLEWINDOWS;
		case 155:
			return KEYSYM_MAIL;
		case 156:
			return KEYSYM_BOOKMARKS;
		case 157:
			return KEYSYM_COMPUTER;
		case 158:
			return KEYSYM_BACK;
		case 159:
			return KEYSYM_FORWARD;
		case 160:
			return KEYSYM_CLOSECD;
		case 161:
			return KEYSYM_EJECTCD;
		case 162:
			return KEYSYM_EJECTCLOSECD;
		case 163:
			return KEYSYM_NEXTSONG;
		case 164:
			return KEYSYM_PLAYPAUSE;
		case 165:
			return KEYSYM_PREVIOUSSONG;
		case 166:
			return KEYSYM_STOPCD;
		case 167:
			return KEYSYM_RECORD;
		case 168:
			return KEYSYM_REWIND;
		case 169:
			return KEYSYM_PHONE;
		case 170:
			return KEYSYM_ISO;
		case 171:
			return KEYSYM_CONFIG;
		case 172:
			return KEYSYM_HOMEPAGE;
		case 173:
			return KEYSYM_REFRESH;
		case 174:
			return KEYSYM_EXIT;
		case 175:
			return KEYSYM_MOVE;
		case 176:
			return KEYSYM_EDIT;
		case 177:
			return KEYSYM_SCROLLUP;
		case 178:
			return KEYSYM_SCROLLDOWN;
		case 179:
			return KEYSYM_KPLEFTPAREN;
		case 180:
			return KEYSYM_KPRIGHTPAREN;
		case 181:
			return KEYSYM_NEW;
		case 182:
			return KEYSYM_REDO;
		case 183:
			return KEYSYM_F13;
		case 184:
			return KEYSYM_F14;
		case 185:
			return KEYSYM_F15;
		case 186:
			return KEYSYM_F16;
		case 187:
			return KEYSYM_F17;
		case 188:
			return KEYSYM_F18;
		case 189:
			return KEYSYM_F19;
		case 190:
			return KEYSYM_F20;
		case 191:
			return KEYSYM_F21;
		case 192:
			return KEYSYM_F22;
		case 193:
			return KEYSYM_F23;
		case 194:
			return KEYSYM_F24;
		case 200:
			return KEYSYM_PLAYCD;
		case 201:
			return KEYSYM_PAUSECD;
		case 202:
			return KEYSYM_PROG3;
		case 203:
			return KEYSYM_PROG4;
		case 205:
			return KEYSYM_SUSPEND;
		case 206:
			return KEYSYM_CLOSE;
		case 207:
			return KEYSYM_PLAY;
		case 208:
			return KEYSYM_FASTFORWARD;
		case 209:
			return KEYSYM_BASSBOOST;
		case 210:
			return KEYSYM_PRINT;
		case 211:
			return KEYSYM_HP;
		case 212:
			return KEYSYM_CAMERA;
		case 213:
			return KEYSYM_SOUND;
		case 214:
			return KEYSYM_QUESTION;
		case 215:
			return KEYSYM_EMAIL;
		case 216:
			return KEYSYM_CHAT;
		case 217:
			return KEYSYM_SEARCH;
		case 218:
			return KEYSYM_CONNECT;
		case 219:
			return KEYSYM_FINANCE;
		case 220:
			return KEYSYM_SPORT;
		case 221:
			return KEYSYM_SHOP;
		case 222:
			return KEYSYM_ALTERASE;
		case 223:
			return KEYSYM_CANCEL;
		case 224:
			return KEYSYM_BRIGHTNESSDOWN;
		case 225:
			return KEYSYM_BRIGHTNESSUP;
		case 226:
			return KEYSYM_MEDIA;
		case 227:
			return KEYSYM_SWITCHVIDEOMODE;
		case 228:
			return KEYSYM_KBDILLUMTOGGLE;
		case 229:
			return KEYSYM_KBDILLUMDOWN;
		case 230:
			return KEYSYM_KBDILLUMUP;
		case 231:
			return KEYSYM_SEND;
		case 232:
			return KEYSYM_REPLY;
		case 233:
			return KEYSYM_FORWARDMAIL;
		case 234:
			return KEYSYM_SAVE;
		case 235:
			return KEYSYM_DOCUMENTS;
		case 236:
			return KEYSYM_BATTERY;
		default:
			return KEYSYM_UNKNOWN;
		}
	}
	
	public static String convertHRToKeySym(String hrString) {		
		return "KEY_" + hrString.toUpperCase()
							.replace("ESCAPE", "ESC")
							.replace("EQUALS", "EQUAL")
							.replace("NUMPAD", "KP")
							.replace(" ", "")
							.replace("/", "");
	}

	/**
	 * Change KEY_* string to a keysym integer
	 * @param v KEY_* string
	 * @return keysym value
	 */
	public static int convertString(String v) {
		if (v.compareTo(KEYSYM_ESC) == 0) {
			return 1;
		} else if (v.compareTo(KEYSYM_1) == 0) {
			return 2;
		} else if (v.compareTo(KEYSYM_2) == 0) {
			return 3;
		} else if (v.compareTo(KEYSYM_3) == 0) {
			return 4;
		} else if (v.compareTo(KEYSYM_4) == 0) {
			return 5;
		} else if (v.compareTo(KEYSYM_5) == 0) {
			return 6;
		} else if (v.compareTo(KEYSYM_6) == 0) {
			return 7;
		} else if (v.compareTo(KEYSYM_7) == 0) {
			return 8;
		} else if (v.compareTo(KEYSYM_8) == 0) {
			return 9;
		} else if (v.compareTo(KEYSYM_9) == 0) {
			return 10;
		} else if (v.compareTo(KEYSYM_0) == 0) {
			return 11;
		} else if (v.compareTo(KEYSYM_MINUS) == 0) {
			return 12;
		} else if (v.compareTo(KEYSYM_EQUAL) == 0) {
			return 13;
		} else if (v.compareTo(KEYSYM_BACKSPACE) == 0) {
			return 14;
		} else if (v.compareTo(KEYSYM_TAB) == 0) {
			return 15;
		} else if (v.compareTo(KEYSYM_Q) == 0) {
			return 16;
		} else if (v.compareTo(KEYSYM_W) == 0) {
			return 17;
		} else if (v.compareTo(KEYSYM_E) == 0) {
			return 18;
		} else if (v.compareTo(KEYSYM_R) == 0) {
			return 19;
		} else if (v.compareTo(KEYSYM_T) == 0) {
			return 20;
		} else if (v.compareTo(KEYSYM_Y) == 0) {
			return 21;
		} else if (v.compareTo(KEYSYM_U) == 0) {
			return 22;
		} else if (v.compareTo(KEYSYM_I) == 0) {
			return 23;
		} else if (v.compareTo(KEYSYM_O) == 0) {
			return 24;
		} else if (v.compareTo(KEYSYM_P) == 0) {
			return 25;
		} else if (v.compareTo(KEYSYM_LEFTBRACE) == 0) {
			return 26;
		} else if (v.compareTo(KEYSYM_RIGHTBRACE) == 0) {
			return 27;
		} else if (v.compareTo(KEYSYM_ENTER) == 0) {
			return 28;
		} else if (v.compareTo(KEYSYM_LEFTCTRL) == 0) {
			return 29;
		} else if (v.compareTo(KEYSYM_A) == 0) {
			return 30;
		} else if (v.compareTo(KEYSYM_S) == 0) {
			return 31;
		} else if (v.compareTo(KEYSYM_D) == 0) {
			return 32;
		} else if (v.compareTo(KEYSYM_F) == 0) {
			return 33;
		} else if (v.compareTo(KEYSYM_G) == 0) {
			return 34;
		} else if (v.compareTo(KEYSYM_H) == 0) {
			return 35;
		} else if (v.compareTo(KEYSYM_J) == 0) {
			return 36;
		} else if (v.compareTo(KEYSYM_K) == 0) {
			return 37;
		} else if (v.compareTo(KEYSYM_L) == 0) {
			return 38;
		} else if (v.compareTo(KEYSYM_SEMICOLON) == 0) {
			return 39;
		} else if (v.compareTo(KEYSYM_APOSTROPHE) == 0) {
			return 40;
		} else if (v.compareTo(KEYSYM_GRAVE) == 0) {
			return 41;
		} else if (v.compareTo(KEYSYM_LEFTSHIFT) == 0) {
			return 42;
		} else if (v.compareTo(KEYSYM_BACKSLASH) == 0) {
			return 43;
		} else if (v.compareTo(KEYSYM_Z) == 0) {
			return 44;
		} else if (v.compareTo(KEYSYM_X) == 0) {
			return 45;
		} else if (v.compareTo(KEYSYM_C) == 0) {
			return 46;
		} else if (v.compareTo(KEYSYM_V) == 0) {
			return 47;
		} else if (v.compareTo(KEYSYM_B) == 0) {
			return 48;
		} else if (v.compareTo(KEYSYM_N) == 0) {
			return 49;
		} else if (v.compareTo(KEYSYM_M) == 0) {
			return 50;
		} else if (v.compareTo(KEYSYM_COMMA) == 0) {
			return 51;
		} else if (v.compareTo(KEYSYM_DOT) == 0) {
			return 52;
		} else if (v.compareTo(KEYSYM_SLASH) == 0) {
			return 53;
		} else if (v.compareTo(KEYSYM_RIGHTSHIFT) == 0) {
			return 54;
		} else if (v.compareTo(KEYSYM_KPASTERISK) == 0) {
			return 55;
		} else if (v.compareTo(KEYSYM_LEFTALT) == 0) {
			return 56;
		} else if (v.compareTo(KEYSYM_SPACE) == 0) {
			return 57;
		} else if (v.compareTo(KEYSYM_CAPSLOCK) == 0) {
			return 58;
		} else if (v.compareTo(KEYSYM_F1) == 0) {
			return 59;
		} else if (v.compareTo(KEYSYM_F2) == 0) {
			return 60;
		} else if (v.compareTo(KEYSYM_F3) == 0) {
			return 61;
		} else if (v.compareTo(KEYSYM_F4) == 0) {
			return 62;
		} else if (v.compareTo(KEYSYM_F5) == 0) {
			return 63;
		} else if (v.compareTo(KEYSYM_F6) == 0) {
			return 64;
		} else if (v.compareTo(KEYSYM_F7) == 0) {
			return 65;
		} else if (v.compareTo(KEYSYM_F8) == 0) {
			return 66;
		} else if (v.compareTo(KEYSYM_F9) == 0) {
			return 67;
		} else if (v.compareTo(KEYSYM_F10) == 0) {
			return 68;
		} else if (v.compareTo(KEYSYM_NUMLOCK) == 0) {
			return 69;
		} else if (v.compareTo(KEYSYM_SCROLLLOCK) == 0) {
			return 70;
		} else if (v.compareTo(KEYSYM_KP7) == 0) {
			return 71;
		} else if (v.compareTo(KEYSYM_KP8) == 0) {
			return 72;
		} else if (v.compareTo(KEYSYM_KP9) == 0) {
			return 73;
		} else if (v.compareTo(KEYSYM_KPMINUS) == 0) {
			return 74;
		} else if (v.compareTo(KEYSYM_KP4) == 0) {
			return 75;
		} else if (v.compareTo(KEYSYM_KP5) == 0) {
			return 76;
		} else if (v.compareTo(KEYSYM_KP6) == 0) {
			return 77;
		} else if (v.compareTo(KEYSYM_KPPLUS) == 0) {
			return 78;
		} else if (v.compareTo(KEYSYM_KP1) == 0) {
			return 79;
		} else if (v.compareTo(KEYSYM_KP2) == 0) {
			return 80;
		} else if (v.compareTo(KEYSYM_KP3) == 0) {
			return 81;
		} else if (v.compareTo(KEYSYM_KP0) == 0) {
			return 82;
		} else if (v.compareTo(KEYSYM_KPDOT) == 0) {
			return 83;
		} else if (v.compareTo(KEYSYM_ZENKAKUHANKAKU) == 0) {
			return 85;
		} else if (v.compareTo(KEYSYM_102ND) == 0) {
			return 86;
		} else if (v.compareTo(KEYSYM_F11) == 0) {
			return 87;
		} else if (v.compareTo(KEYSYM_F12) == 0) {
			return 88;
		} else if (v.compareTo(KEYSYM_RO) == 0) {
			return 89;
		} else if (v.compareTo(KEYSYM_KATAKANA) == 0) {
			return 90;
		} else if (v.compareTo(KEYSYM_HIRAGANA) == 0) {
			return 91;
		} else if (v.compareTo(KEYSYM_HENKAN) == 0) {
			return 92;
		} else if (v.compareTo(KEYSYM_KATAKANAHIRAGANA) == 0) {
			return 93;
		} else if (v.compareTo(KEYSYM_MUHENKAN) == 0) {
			return 94;
		} else if (v.compareTo(KEYSYM_KPJPCOMMA) == 0) {
			return 95;
		} else if (v.compareTo(KEYSYM_KPENTER) == 0) {
			return 96;
		} else if (v.compareTo(KEYSYM_RIGHTCTRL) == 0) {
			return 97;
		} else if (v.compareTo(KEYSYM_KPSLASH) == 0) {
			return 98;
		} else if (v.compareTo(KEYSYM_SYSRQ) == 0) {
			return 99;
		} else if (v.compareTo(KEYSYM_RIGHTALT) == 0) {
			return 100;
		} else if (v.compareTo(KEYSYM_LINEFEED) == 0) {
			return 101;
		} else if (v.compareTo(KEYSYM_HOME) == 0) {
			return 102;
		} else if (v.compareTo(KEYSYM_UP) == 0) {
			return 103;
		} else if (v.compareTo(KEYSYM_PAGEUP) == 0) {
			return 104;
		} else if (v.compareTo(KEYSYM_LEFT) == 0) {
			return 105;
		} else if (v.compareTo(KEYSYM_RIGHT) == 0) {
			return 106;
		} else if (v.compareTo(KEYSYM_END) == 0) {
			return 107;
		} else if (v.compareTo(KEYSYM_DOWN) == 0) {
			return 108;
		} else if (v.compareTo(KEYSYM_PAGEDOWN) == 0) {
			return 109;
		} else if (v.compareTo(KEYSYM_INSERT) == 0) {
			return 110;
		} else if (v.compareTo(KEYSYM_DELETE) == 0) {
			return 111;
		} else if (v.compareTo(KEYSYM_MACRO) == 0) {
			return 112;
		} else if (v.compareTo(KEYSYM_MUTE) == 0) {
			return 113;
		} else if (v.compareTo(KEYSYM_VOLUMEDOWN) == 0) {
			return 114;
		} else if (v.compareTo(KEYSYM_VOLUMEUP) == 0) {
			return 115;
		} else if (v.compareTo(KEYSYM_POWER) == 0) {
			return 116;
		} else if (v.compareTo(KEYSYM_KPEQUAL) == 0) {
			return 117;
		} else if (v.compareTo(KEYSYM_KPPLUSMINUS) == 0) {
			return 118;
		} else if (v.compareTo(KEYSYM_PAUSE) == 0) {
			return 119;
		} else if (v.compareTo(KEYSYM_KPCOMMA) == 0) {
			return 121;
		} else if (v.compareTo(KEYSYM_HANGUEL) == 0) {
			return 122;
		} else if (v.compareTo(KEYSYM_HANJA) == 0) {
			return 123;
		} else if (v.compareTo(KEYSYM_YEN) == 0) {
			return 124;
		} else if (v.compareTo(KEYSYM_LEFTMETA) == 0) {
			return 125;
		} else if (v.compareTo(KEYSYM_RIGHTMETA) == 0) {
			return 126;
		} else if (v.compareTo(KEYSYM_COMPOSE) == 0) {
			return 127;
		} else if (v.compareTo(KEYSYM_STOP) == 0) {
			return 128;
		} else if (v.compareTo(KEYSYM_AGAIN) == 0) {
			return 129;
		} else if (v.compareTo(KEYSYM_PROPS) == 0) {
			return 130;
		} else if (v.compareTo(KEYSYM_UNDO) == 0) {
			return 131;
		} else if (v.compareTo(KEYSYM_FRONT) == 0) {
			return 132;
		} else if (v.compareTo(KEYSYM_COPY) == 0) {
			return 133;
		} else if (v.compareTo(KEYSYM_OPEN) == 0) {
			return 134;
		} else if (v.compareTo(KEYSYM_PASTE) == 0) {
			return 135;
		} else if (v.compareTo(KEYSYM_FIND) == 0) {
			return 136;
		} else if (v.compareTo(KEYSYM_CUT) == 0) {
			return 137;
		} else if (v.compareTo(KEYSYM_HELP) == 0) {
			return 138;
		} else if (v.compareTo(KEYSYM_MENU) == 0) {
			return 139;
		} else if (v.compareTo(KEYSYM_CALC) == 0) {
			return 140;
		} else if (v.compareTo(KEYSYM_SETUP) == 0) {
			return 141;
		} else if (v.compareTo(KEYSYM_SLEEP) == 0) {
			return 142;
		} else if (v.compareTo(KEYSYM_WAKEUP) == 0) {
			return 143;
		} else if (v.compareTo(KEYSYM_FILE) == 0) {
			return 144;
		} else if (v.compareTo(KEYSYM_SENDFILE) == 0) {
			return 145;
		} else if (v.compareTo(KEYSYM_DELETEFILE) == 0) {
			return 146;
		} else if (v.compareTo(KEYSYM_XFER) == 0) {
			return 147;
		} else if (v.compareTo(KEYSYM_PROG1) == 0) {
			return 148;
		} else if (v.compareTo(KEYSYM_PROG2) == 0) {
			return 149;
		} else if (v.compareTo(KEYSYM_WWW) == 0) {
			return 150;
		} else if (v.compareTo(KEYSYM_MSDOS) == 0) {
			return 151;
		} else if (v.compareTo(KEYSYM_COFFEE) == 0) {
			return 152;
		} else if (v.compareTo(KEYSYM_DIRECTION) == 0) {
			return 153;
		} else if (v.compareTo(KEYSYM_CYCLEWINDOWS) == 0) {
			return 154;
		} else if (v.compareTo(KEYSYM_MAIL) == 0) {
			return 155;
		} else if (v.compareTo(KEYSYM_BOOKMARKS) == 0) {
			return 156;
		} else if (v.compareTo(KEYSYM_COMPUTER) == 0) {
			return 157;
		} else if (v.compareTo(KEYSYM_BACK) == 0) {
			return 158;
		} else if (v.compareTo(KEYSYM_FORWARD) == 0) {
			return 159;
		} else if (v.compareTo(KEYSYM_CLOSECD) == 0) {
			return 160;
		} else if (v.compareTo(KEYSYM_EJECTCD) == 0) {
			return 161;
		} else if (v.compareTo(KEYSYM_EJECTCLOSECD) == 0) {
			return 162;
		} else if (v.compareTo(KEYSYM_NEXTSONG) == 0) {
			return 163;
		} else if (v.compareTo(KEYSYM_PLAYPAUSE) == 0) {
			return 164;
		} else if (v.compareTo(KEYSYM_PREVIOUSSONG) == 0) {
			return 165;
		} else if (v.compareTo(KEYSYM_STOPCD) == 0) {
			return 166;
		} else if (v.compareTo(KEYSYM_RECORD) == 0) {
			return 167;
		} else if (v.compareTo(KEYSYM_REWIND) == 0) {
			return 168;
		} else if (v.compareTo(KEYSYM_PHONE) == 0) {
			return 169;
		} else if (v.compareTo(KEYSYM_ISO) == 0) {
			return 170;
		} else if (v.compareTo(KEYSYM_CONFIG) == 0) {
			return 171;
		} else if (v.compareTo(KEYSYM_HOMEPAGE) == 0) {
			return 172;
		} else if (v.compareTo(KEYSYM_REFRESH) == 0) {
			return 173;
		} else if (v.compareTo(KEYSYM_EXIT) == 0) {
			return 174;
		} else if (v.compareTo(KEYSYM_MOVE) == 0) {
			return 175;
		} else if (v.compareTo(KEYSYM_EDIT) == 0) {
			return 176;
		} else if (v.compareTo(KEYSYM_SCROLLUP) == 0) {
			return 177;
		} else if (v.compareTo(KEYSYM_SCROLLDOWN) == 0) {
			return 178;
		} else if (v.compareTo(KEYSYM_KPLEFTPAREN) == 0) {
			return 179;
		} else if (v.compareTo(KEYSYM_KPRIGHTPAREN) == 0) {
			return 180;
		} else if (v.compareTo(KEYSYM_NEW) == 0) {
			return 181;
		} else if (v.compareTo(KEYSYM_REDO) == 0) {
			return 182;
		} else if (v.compareTo(KEYSYM_F13) == 0) {
			return 183;
		} else if (v.compareTo(KEYSYM_F14) == 0) {
			return 184;
		} else if (v.compareTo(KEYSYM_F15) == 0) {
			return 185;
		} else if (v.compareTo(KEYSYM_F16) == 0) {
			return 186;
		} else if (v.compareTo(KEYSYM_F17) == 0) {
			return 187;
		} else if (v.compareTo(KEYSYM_F18) == 0) {
			return 188;
		} else if (v.compareTo(KEYSYM_F19) == 0) {
			return 189;
		} else if (v.compareTo(KEYSYM_F20) == 0) {
			return 190;
		} else if (v.compareTo(KEYSYM_F21) == 0) {
			return 191;
		} else if (v.compareTo(KEYSYM_F22) == 0) {
			return 192;
		} else if (v.compareTo(KEYSYM_F23) == 0) {
			return 193;
		} else if (v.compareTo(KEYSYM_F24) == 0) {
			return 194;
		} else if (v.compareTo(KEYSYM_PLAYCD) == 0) {
			return 200;
		} else if (v.compareTo(KEYSYM_PAUSECD) == 0) {
			return 201;
		} else if (v.compareTo(KEYSYM_PROG3) == 0) {
			return 202;
		} else if (v.compareTo(KEYSYM_PROG4) == 0) {
			return 203;
		} else if (v.compareTo(KEYSYM_SUSPEND) == 0) {
			return 205;
		} else if (v.compareTo(KEYSYM_CLOSE) == 0) {
			return 206;
		} else if (v.compareTo(KEYSYM_PLAY) == 0) {
			return 207;
		} else if (v.compareTo(KEYSYM_FASTFORWARD) == 0) {
			return 208;
		} else if (v.compareTo(KEYSYM_BASSBOOST) == 0) {
			return 209;
		} else if (v.compareTo(KEYSYM_PRINT) == 0) {
			return 210;
		} else if (v.compareTo(KEYSYM_HP) == 0) {
			return 211;
		} else if (v.compareTo(KEYSYM_CAMERA) == 0) {
			return 212;
		} else if (v.compareTo(KEYSYM_SOUND) == 0) {
			return 213;
		} else if (v.compareTo(KEYSYM_QUESTION) == 0) {
			return 214;
		} else if (v.compareTo(KEYSYM_EMAIL) == 0) {
			return 215;
		} else if (v.compareTo(KEYSYM_CHAT) == 0) {
			return 216;
		} else if (v.compareTo(KEYSYM_SEARCH) == 0) {
			return 217;
		} else if (v.compareTo(KEYSYM_CONNECT) == 0) {
			return 218;
		} else if (v.compareTo(KEYSYM_FINANCE) == 0) {
			return 219;
		} else if (v.compareTo(KEYSYM_SPORT) == 0) {
			return 220;
		} else if (v.compareTo(KEYSYM_SHOP) == 0) {
			return 221;
		} else if (v.compareTo(KEYSYM_ALTERASE) == 0) {
			return 222;
		} else if (v.compareTo(KEYSYM_CANCEL) == 0) {
			return 223;
		} else if (v.compareTo(KEYSYM_BRIGHTNESSDOWN) == 0) {
			return 224;
		} else if (v.compareTo(KEYSYM_BRIGHTNESSUP) == 0) {
			return 225;
		} else if (v.compareTo(KEYSYM_MEDIA) == 0) {
			return 226;
		} else if (v.compareTo(KEYSYM_SWITCHVIDEOMODE) == 0) {
			return 227;
		} else if (v.compareTo(KEYSYM_KBDILLUMTOGGLE) == 0) {
			return 228;
		} else if (v.compareTo(KEYSYM_KBDILLUMDOWN) == 0) {
			return 229;
		} else if (v.compareTo(KEYSYM_KBDILLUMUP) == 0) {
			return 230;
		} else if (v.compareTo(KEYSYM_SEND) == 0) {
			return 231;
		} else if (v.compareTo(KEYSYM_REPLY) == 0) {
			return 232;
		} else if (v.compareTo(KEYSYM_FORWARDMAIL) == 0) {
			return 233;
		} else if (v.compareTo(KEYSYM_SAVE) == 0) {
			return 234;
		} else if (v.compareTo(KEYSYM_DOCUMENTS) == 0) {
			return 235;
		} else if (v.compareTo(KEYSYM_BATTERY) == 0) {
			return 236;
		} else {
			return 0;
		}
	}
}
