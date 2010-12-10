package org.cvpcs.android.cwiidconfig.config;

import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
	public static final String TAG = "CWiiDConfig/ConfigManager";
	
	private static final HashMap<Integer, String> KEYSYMS = new HashMap<Integer, String>();
	public static final ArrayList<String> ANDROID_KEYS = new ArrayList<String>();
	
	static {
		// Fill our keysyms
		KEYSYMS.put(Integer.valueOf(1), "KEY_ESC");
		KEYSYMS.put(Integer.valueOf(2), "KEY_1");
		KEYSYMS.put(Integer.valueOf(3), "KEY_2");
		KEYSYMS.put(Integer.valueOf(4), "KEY_3");
		KEYSYMS.put(Integer.valueOf(5), "KEY_4");
		KEYSYMS.put(Integer.valueOf(6), "KEY_5");
		KEYSYMS.put(Integer.valueOf(7), "KEY_6");
		KEYSYMS.put(Integer.valueOf(8), "KEY_7");
		KEYSYMS.put(Integer.valueOf(9), "KEY_8");
		KEYSYMS.put(Integer.valueOf(10), "KEY_9");
		KEYSYMS.put(Integer.valueOf(11), "KEY_0");
		KEYSYMS.put(Integer.valueOf(12), "KEY_MINUS");
		KEYSYMS.put(Integer.valueOf(13), "KEY_EQUAL");
		KEYSYMS.put(Integer.valueOf(14), "KEY_BACKSPACE");
		KEYSYMS.put(Integer.valueOf(15), "KEY_TAB");
		KEYSYMS.put(Integer.valueOf(16), "KEY_Q");
		KEYSYMS.put(Integer.valueOf(17), "KEY_W");
		KEYSYMS.put(Integer.valueOf(18), "KEY_E");
		KEYSYMS.put(Integer.valueOf(19), "KEY_R");
		KEYSYMS.put(Integer.valueOf(20), "KEY_T");
		KEYSYMS.put(Integer.valueOf(21), "KEY_Y");
		KEYSYMS.put(Integer.valueOf(22), "KEY_U");
		KEYSYMS.put(Integer.valueOf(23), "KEY_I");
		KEYSYMS.put(Integer.valueOf(24), "KEY_O");
		KEYSYMS.put(Integer.valueOf(25), "KEY_P");
		KEYSYMS.put(Integer.valueOf(26), "KEY_LEFTBRACE");
		KEYSYMS.put(Integer.valueOf(27), "KEY_RIGHTBRACE");
		KEYSYMS.put(Integer.valueOf(28), "KEY_ENTER");
		KEYSYMS.put(Integer.valueOf(29), "KEY_LEFTCTRL");
		KEYSYMS.put(Integer.valueOf(30), "KEY_A");
		KEYSYMS.put(Integer.valueOf(31), "KEY_S");
		KEYSYMS.put(Integer.valueOf(32), "KEY_D");
		KEYSYMS.put(Integer.valueOf(33), "KEY_F");
		KEYSYMS.put(Integer.valueOf(34), "KEY_G");
		KEYSYMS.put(Integer.valueOf(35), "KEY_H");
		KEYSYMS.put(Integer.valueOf(36), "KEY_J");
		KEYSYMS.put(Integer.valueOf(37), "KEY_K");
		KEYSYMS.put(Integer.valueOf(38), "KEY_L");
		KEYSYMS.put(Integer.valueOf(39), "KEY_SEMICOLON");
		KEYSYMS.put(Integer.valueOf(40), "KEY_APOSTROPHE");
		KEYSYMS.put(Integer.valueOf(41), "KEY_GRAVE");
		KEYSYMS.put(Integer.valueOf(42), "KEY_LEFTSHIFT");
		KEYSYMS.put(Integer.valueOf(43), "KEY_BACKSLASH");
		KEYSYMS.put(Integer.valueOf(44), "KEY_Z");
		KEYSYMS.put(Integer.valueOf(45), "KEY_X");
		KEYSYMS.put(Integer.valueOf(46), "KEY_C");
		KEYSYMS.put(Integer.valueOf(47), "KEY_V");
		KEYSYMS.put(Integer.valueOf(48), "KEY_B");
		KEYSYMS.put(Integer.valueOf(49), "KEY_N");
		KEYSYMS.put(Integer.valueOf(50), "KEY_M");
		KEYSYMS.put(Integer.valueOf(51), "KEY_COMMA");
		KEYSYMS.put(Integer.valueOf(52), "KEY_DOT");
		KEYSYMS.put(Integer.valueOf(53), "KEY_SLASH");
		KEYSYMS.put(Integer.valueOf(54), "KEY_RIGHTSHIFT");
		KEYSYMS.put(Integer.valueOf(55), "KEY_KPASTERISK");
		KEYSYMS.put(Integer.valueOf(56), "KEY_LEFTALT");
		KEYSYMS.put(Integer.valueOf(57), "KEY_SPACE");
		KEYSYMS.put(Integer.valueOf(58), "KEY_CAPSLOCK");
		KEYSYMS.put(Integer.valueOf(59), "KEY_F1");
		KEYSYMS.put(Integer.valueOf(60), "KEY_F2");
		KEYSYMS.put(Integer.valueOf(61), "KEY_F3");
		KEYSYMS.put(Integer.valueOf(62), "KEY_F4");
		KEYSYMS.put(Integer.valueOf(63), "KEY_F5");
		KEYSYMS.put(Integer.valueOf(64), "KEY_F6");
		KEYSYMS.put(Integer.valueOf(65), "KEY_F7");
		KEYSYMS.put(Integer.valueOf(66), "KEY_F8");
		KEYSYMS.put(Integer.valueOf(67), "KEY_F9");
		KEYSYMS.put(Integer.valueOf(68), "KEY_F10");
		KEYSYMS.put(Integer.valueOf(69), "KEY_NUMLOCK");
		KEYSYMS.put(Integer.valueOf(70), "KEY_SCROLLLOCK");
		KEYSYMS.put(Integer.valueOf(71), "KEY_KP7");
		KEYSYMS.put(Integer.valueOf(72), "KEY_KP8");
		KEYSYMS.put(Integer.valueOf(73), "KEY_KP9");
		KEYSYMS.put(Integer.valueOf(74), "KEY_KPMINUS");
		KEYSYMS.put(Integer.valueOf(75), "KEY_KP4");
		KEYSYMS.put(Integer.valueOf(76), "KEY_KP5");
		KEYSYMS.put(Integer.valueOf(77), "KEY_KP6");
		KEYSYMS.put(Integer.valueOf(78), "KEY_KPPLUS");
		KEYSYMS.put(Integer.valueOf(79), "KEY_KP1");
		KEYSYMS.put(Integer.valueOf(80), "KEY_KP2");
		KEYSYMS.put(Integer.valueOf(81), "KEY_KP3");
		KEYSYMS.put(Integer.valueOf(82), "KEY_KP0");
		KEYSYMS.put(Integer.valueOf(83), "KEY_KPDOT");
		KEYSYMS.put(Integer.valueOf(85), "KEY_ZENKAKUHANKAKU");
		KEYSYMS.put(Integer.valueOf(86), "KEY_102ND");
		KEYSYMS.put(Integer.valueOf(87), "KEY_F11");
		KEYSYMS.put(Integer.valueOf(88), "KEY_F12");
		KEYSYMS.put(Integer.valueOf(89), "KEY_RO");
		KEYSYMS.put(Integer.valueOf(90), "KEY_KATAKANA");
		KEYSYMS.put(Integer.valueOf(91), "KEY_HIRAGANA");
		KEYSYMS.put(Integer.valueOf(92), "KEY_HENKAN");
		KEYSYMS.put(Integer.valueOf(93), "KEY_KATAKANAHIRAGANA");
		KEYSYMS.put(Integer.valueOf(94), "KEY_MUHENKAN");
		KEYSYMS.put(Integer.valueOf(95), "KEY_KPJPCOMMA");
		KEYSYMS.put(Integer.valueOf(96), "KEY_KPENTER");
		KEYSYMS.put(Integer.valueOf(97), "KEY_RIGHTCTRL");
		KEYSYMS.put(Integer.valueOf(98), "KEY_KPSLASH");
		KEYSYMS.put(Integer.valueOf(99), "KEY_SYSRQ");
		KEYSYMS.put(Integer.valueOf(100), "KEY_RIGHTALT");
		KEYSYMS.put(Integer.valueOf(101), "KEY_LINEFEED");
		KEYSYMS.put(Integer.valueOf(102), "KEY_HOME");
		KEYSYMS.put(Integer.valueOf(103), "KEY_UP");
		KEYSYMS.put(Integer.valueOf(104), "KEY_PAGEUP");
		KEYSYMS.put(Integer.valueOf(105), "KEY_LEFT");
		KEYSYMS.put(Integer.valueOf(106), "KEY_RIGHT");
		KEYSYMS.put(Integer.valueOf(107), "KEY_END");
		KEYSYMS.put(Integer.valueOf(108), "KEY_DOWN");
		KEYSYMS.put(Integer.valueOf(109), "KEY_PAGEDOWN");
		KEYSYMS.put(Integer.valueOf(110), "KEY_INSERT");
		KEYSYMS.put(Integer.valueOf(111), "KEY_DELETE");
		KEYSYMS.put(Integer.valueOf(112), "KEY_MACRO");
		KEYSYMS.put(Integer.valueOf(113), "KEY_MUTE");
		KEYSYMS.put(Integer.valueOf(114), "KEY_VOLUMEDOWN");
		KEYSYMS.put(Integer.valueOf(115), "KEY_VOLUMEUP");
		KEYSYMS.put(Integer.valueOf(116), "KEY_POWER");
		KEYSYMS.put(Integer.valueOf(117), "KEY_KPEQUAL");
		KEYSYMS.put(Integer.valueOf(118), "KEY_KPPLUSMINUS");
		KEYSYMS.put(Integer.valueOf(119), "KEY_PAUSE");
		KEYSYMS.put(Integer.valueOf(121), "KEY_KPCOMMA");
		KEYSYMS.put(Integer.valueOf(122), "KEY_HANGUEL");
		KEYSYMS.put(Integer.valueOf(123), "KEY_HANJA");
		KEYSYMS.put(Integer.valueOf(124), "KEY_YEN");
		KEYSYMS.put(Integer.valueOf(125), "KEY_LEFTMETA");
		KEYSYMS.put(Integer.valueOf(126), "KEY_RIGHTMETA");
		KEYSYMS.put(Integer.valueOf(127), "KEY_COMPOSE");
		KEYSYMS.put(Integer.valueOf(128), "KEY_STOP");
		KEYSYMS.put(Integer.valueOf(129), "KEY_AGAIN");
		KEYSYMS.put(Integer.valueOf(130), "KEY_PROPS");
		KEYSYMS.put(Integer.valueOf(131), "KEY_UNDO");
		KEYSYMS.put(Integer.valueOf(132), "KEY_FRONT");
		KEYSYMS.put(Integer.valueOf(133), "KEY_COPY");
		KEYSYMS.put(Integer.valueOf(134), "KEY_OPEN");
		KEYSYMS.put(Integer.valueOf(135), "KEY_PASTE");
		KEYSYMS.put(Integer.valueOf(136), "KEY_FIND");
		KEYSYMS.put(Integer.valueOf(137), "KEY_CUT");
		KEYSYMS.put(Integer.valueOf(138), "KEY_HELP");
		KEYSYMS.put(Integer.valueOf(139), "KEY_MENU");
		KEYSYMS.put(Integer.valueOf(140), "KEY_CALC");
		KEYSYMS.put(Integer.valueOf(141), "KEY_SETUP");
		KEYSYMS.put(Integer.valueOf(142), "KEY_SLEEP");
		KEYSYMS.put(Integer.valueOf(143), "KEY_WAKEUP");
		KEYSYMS.put(Integer.valueOf(144), "KEY_FILE");
		KEYSYMS.put(Integer.valueOf(145), "KEY_SENDFILE");
		KEYSYMS.put(Integer.valueOf(146), "KEY_DELETEFILE");
		KEYSYMS.put(Integer.valueOf(147), "KEY_XFER");
		KEYSYMS.put(Integer.valueOf(148), "KEY_PROG1");
		KEYSYMS.put(Integer.valueOf(149), "KEY_PROG2");
		KEYSYMS.put(Integer.valueOf(150), "KEY_WWW");
		KEYSYMS.put(Integer.valueOf(151), "KEY_MSDOS");
		KEYSYMS.put(Integer.valueOf(152), "KEY_COFFEE");
		KEYSYMS.put(Integer.valueOf(153), "KEY_DIRECTION");
		KEYSYMS.put(Integer.valueOf(154), "KEY_CYCLEWINDOWS");
		KEYSYMS.put(Integer.valueOf(155), "KEY_MAIL");
		KEYSYMS.put(Integer.valueOf(156), "KEY_BOOKMARKS");
		KEYSYMS.put(Integer.valueOf(157), "KEY_COMPUTER");
		KEYSYMS.put(Integer.valueOf(158), "KEY_BACK");
		KEYSYMS.put(Integer.valueOf(159), "KEY_FORWARD");
		KEYSYMS.put(Integer.valueOf(160), "KEY_CLOSECD");
		KEYSYMS.put(Integer.valueOf(161), "KEY_EJECTCD");
		KEYSYMS.put(Integer.valueOf(162), "KEY_EJECTCLOSECD");
		KEYSYMS.put(Integer.valueOf(163), "KEY_NEXTSONG");
		KEYSYMS.put(Integer.valueOf(164), "KEY_PLAYPAUSE");
		KEYSYMS.put(Integer.valueOf(165), "KEY_PREVIOUSSONG");
		KEYSYMS.put(Integer.valueOf(166), "KEY_STOPCD");
		KEYSYMS.put(Integer.valueOf(167), "KEY_RECORD");
		KEYSYMS.put(Integer.valueOf(168), "KEY_REWIND");
		KEYSYMS.put(Integer.valueOf(169), "KEY_PHONE");
		KEYSYMS.put(Integer.valueOf(170), "KEY_ISO");
		KEYSYMS.put(Integer.valueOf(171), "KEY_CONFIG");
		KEYSYMS.put(Integer.valueOf(172), "KEY_HOMEPAGE");
		KEYSYMS.put(Integer.valueOf(173), "KEY_REFRESH");
		KEYSYMS.put(Integer.valueOf(174), "KEY_EXIT");
		KEYSYMS.put(Integer.valueOf(175), "KEY_MOVE");
		KEYSYMS.put(Integer.valueOf(176), "KEY_EDIT");
		KEYSYMS.put(Integer.valueOf(177), "KEY_SCROLLUP");
		KEYSYMS.put(Integer.valueOf(178), "KEY_SCROLLDOWN");
		KEYSYMS.put(Integer.valueOf(179), "KEY_KPLEFTPAREN");
		KEYSYMS.put(Integer.valueOf(180), "KEY_KPRIGHTPAREN");
		KEYSYMS.put(Integer.valueOf(181), "KEY_NEW");
		KEYSYMS.put(Integer.valueOf(182), "KEY_REDO");
		KEYSYMS.put(Integer.valueOf(183), "KEY_F13");
		KEYSYMS.put(Integer.valueOf(184), "KEY_F14");
		KEYSYMS.put(Integer.valueOf(185), "KEY_F15");
		KEYSYMS.put(Integer.valueOf(186), "KEY_F16");
		KEYSYMS.put(Integer.valueOf(187), "KEY_F17");
		KEYSYMS.put(Integer.valueOf(188), "KEY_F18");
		KEYSYMS.put(Integer.valueOf(189), "KEY_F19");
		KEYSYMS.put(Integer.valueOf(190), "KEY_F20");
		KEYSYMS.put(Integer.valueOf(191), "KEY_F21");
		KEYSYMS.put(Integer.valueOf(192), "KEY_F22");
		KEYSYMS.put(Integer.valueOf(193), "KEY_F23");
		KEYSYMS.put(Integer.valueOf(194), "KEY_F24");
		KEYSYMS.put(Integer.valueOf(200), "KEY_PLAYCD");
		KEYSYMS.put(Integer.valueOf(201), "KEY_PAUSECD");
		KEYSYMS.put(Integer.valueOf(202), "KEY_PROG3");
		KEYSYMS.put(Integer.valueOf(203), "KEY_PROG4");
		KEYSYMS.put(Integer.valueOf(205), "KEY_SUSPEND");
		KEYSYMS.put(Integer.valueOf(206), "KEY_CLOSE");
		KEYSYMS.put(Integer.valueOf(207), "KEY_PLAY");
		KEYSYMS.put(Integer.valueOf(208), "KEY_FASTFORWARD");
		KEYSYMS.put(Integer.valueOf(209), "KEY_BASSBOOST");
		KEYSYMS.put(Integer.valueOf(210), "KEY_PRINT");
		KEYSYMS.put(Integer.valueOf(211), "KEY_HP");
		KEYSYMS.put(Integer.valueOf(212), "KEY_CAMERA");
		KEYSYMS.put(Integer.valueOf(213), "KEY_SOUND");
		KEYSYMS.put(Integer.valueOf(214), "KEY_QUESTION");
		KEYSYMS.put(Integer.valueOf(215), "KEY_EMAIL");
		KEYSYMS.put(Integer.valueOf(216), "KEY_CHAT");
		KEYSYMS.put(Integer.valueOf(217), "KEY_SEARCH");
		KEYSYMS.put(Integer.valueOf(218), "KEY_CONNECT");
		KEYSYMS.put(Integer.valueOf(219), "KEY_FINANCE");
		KEYSYMS.put(Integer.valueOf(220), "KEY_SPORT");
		KEYSYMS.put(Integer.valueOf(221), "KEY_SHOP");
		KEYSYMS.put(Integer.valueOf(222), "KEY_ALTERASE");
		KEYSYMS.put(Integer.valueOf(223), "KEY_CANCEL");
		KEYSYMS.put(Integer.valueOf(224), "KEY_BRIGHTNESSDOWN");
		KEYSYMS.put(Integer.valueOf(225), "KEY_BRIGHTNESSUP");
		KEYSYMS.put(Integer.valueOf(226), "KEY_MEDIA");
		KEYSYMS.put(Integer.valueOf(227), "KEY_SWITCHVIDEOMODE");
		KEYSYMS.put(Integer.valueOf(228), "KEY_KBDILLUMTOGGLE");
		KEYSYMS.put(Integer.valueOf(229), "KEY_KBDILLUMDOWN");
		KEYSYMS.put(Integer.valueOf(230), "KEY_KBDILLUMUP");
		KEYSYMS.put(Integer.valueOf(231), "KEY_SEND");
		KEYSYMS.put(Integer.valueOf(232), "KEY_REPLY");
		KEYSYMS.put(Integer.valueOf(233), "KEY_FORWARDMAIL");
		KEYSYMS.put(Integer.valueOf(234), "KEY_SAVE");
		KEYSYMS.put(Integer.valueOf(235), "KEY_DOCUMENTS");
		KEYSYMS.put(Integer.valueOf(236), "KEY_BATTERY");
		KEYSYMS.put(Integer.valueOf(240), "KEY_UNKNOWN");
		KEYSYMS.put(Integer.valueOf(0x100), "BTN_MISC");
		KEYSYMS.put(Integer.valueOf(0x100), "BTN_0");
		KEYSYMS.put(Integer.valueOf(0x101), "BTN_1");
		KEYSYMS.put(Integer.valueOf(0x102), "BTN_2");
		KEYSYMS.put(Integer.valueOf(0x103), "BTN_3");
		KEYSYMS.put(Integer.valueOf(0x104), "BTN_4");
		KEYSYMS.put(Integer.valueOf(0x105), "BTN_5");
		KEYSYMS.put(Integer.valueOf(0x106), "BTN_6");
		KEYSYMS.put(Integer.valueOf(0x107), "BTN_7");
		KEYSYMS.put(Integer.valueOf(0x108), "BTN_8");
		KEYSYMS.put(Integer.valueOf(0x109), "BTN_9");
		KEYSYMS.put(Integer.valueOf(0x110), "BTN_MOUSE");
		KEYSYMS.put(Integer.valueOf(0x110), "BTN_LEFT");
		KEYSYMS.put(Integer.valueOf(0x111), "BTN_RIGHT");
		KEYSYMS.put(Integer.valueOf(0x112), "BTN_MIDDLE");
		KEYSYMS.put(Integer.valueOf(0x113), "BTN_SIDE");
		KEYSYMS.put(Integer.valueOf(0x114), "BTN_EXTRA");
		KEYSYMS.put(Integer.valueOf(0x115), "BTN_FORWARD");
		KEYSYMS.put(Integer.valueOf(0x116), "BTN_BACK");
		KEYSYMS.put(Integer.valueOf(0x117), "BTN_TASK");
		KEYSYMS.put(Integer.valueOf(0x120), "BTN_JOYSTICK");
		KEYSYMS.put(Integer.valueOf(0x120), "BTN_TRIGGER");
		KEYSYMS.put(Integer.valueOf(0x121), "BTN_THUMB");
		KEYSYMS.put(Integer.valueOf(0x122), "BTN_THUMB2");
		KEYSYMS.put(Integer.valueOf(0x123), "BTN_TOP");
		KEYSYMS.put(Integer.valueOf(0x124), "BTN_TOP2");
		KEYSYMS.put(Integer.valueOf(0x125), "BTN_PINKIE");
		KEYSYMS.put(Integer.valueOf(0x126), "BTN_BASE");
		KEYSYMS.put(Integer.valueOf(0x127), "BTN_BASE2");
		KEYSYMS.put(Integer.valueOf(0x128), "BTN_BASE3");
		KEYSYMS.put(Integer.valueOf(0x129), "BTN_BASE4");
		KEYSYMS.put(Integer.valueOf(0x12a), "BTN_BASE5");
		KEYSYMS.put(Integer.valueOf(0x12b), "BTN_BASE6");
		KEYSYMS.put(Integer.valueOf(0x12f), "BTN_DEAD");
		KEYSYMS.put(Integer.valueOf(0x130), "BTN_GAMEPAD");
		KEYSYMS.put(Integer.valueOf(0x130), "BTN_A");
		KEYSYMS.put(Integer.valueOf(0x131), "BTN_B");
		KEYSYMS.put(Integer.valueOf(0x132), "BTN_C");
		KEYSYMS.put(Integer.valueOf(0x133), "BTN_X");
		KEYSYMS.put(Integer.valueOf(0x134), "BTN_Y");
		KEYSYMS.put(Integer.valueOf(0x135), "BTN_Z");
		KEYSYMS.put(Integer.valueOf(0x136), "BTN_TL");
		KEYSYMS.put(Integer.valueOf(0x137), "BTN_TR");
		KEYSYMS.put(Integer.valueOf(0x138), "BTN_TL2");
		KEYSYMS.put(Integer.valueOf(0x139), "BTN_TR2");
		KEYSYMS.put(Integer.valueOf(0x13a), "BTN_SELECT");
		KEYSYMS.put(Integer.valueOf(0x13b), "BTN_START");
		KEYSYMS.put(Integer.valueOf(0x13c), "BTN_MODE");
		KEYSYMS.put(Integer.valueOf(0x13d), "BTN_THUMBL");
		KEYSYMS.put(Integer.valueOf(0x13e), "BTN_THUMBR");
		KEYSYMS.put(Integer.valueOf(0x140), "BTN_DIGI");
		KEYSYMS.put(Integer.valueOf(0x140), "BTN_TOOL_PEN");
		KEYSYMS.put(Integer.valueOf(0x141), "BTN_TOOL_RUBBER");
		KEYSYMS.put(Integer.valueOf(0x142), "BTN_TOOL_BRUSH");
		KEYSYMS.put(Integer.valueOf(0x143), "BTN_TOOL_PENCIL");
		KEYSYMS.put(Integer.valueOf(0x144), "BTN_TOOL_AIRBRUSH");
		KEYSYMS.put(Integer.valueOf(0x145), "BTN_TOOL_FINGER");
		KEYSYMS.put(Integer.valueOf(0x146), "BTN_TOOL_MOUSE");
		KEYSYMS.put(Integer.valueOf(0x147), "BTN_TOOL_LENS");
		KEYSYMS.put(Integer.valueOf(0x14a), "BTN_TOUCH");
		KEYSYMS.put(Integer.valueOf(0x14b), "BTN_STYLUS");
		KEYSYMS.put(Integer.valueOf(0x14c), "BTN_STYLUS2");
		KEYSYMS.put(Integer.valueOf(0x14d), "BTN_TOOL_DOUBLETAP");
		KEYSYMS.put(Integer.valueOf(0x14e), "BTN_TOOL_TRIPLETAP");
		KEYSYMS.put(Integer.valueOf(0x150), "BTN_WHEEL");
		KEYSYMS.put(Integer.valueOf(0x150), "BTN_GEAR_DOWN");
		KEYSYMS.put(Integer.valueOf(0x151), "BTN_GEAR_UP");
		KEYSYMS.put(Integer.valueOf(0x160), "KEY_OK");
		KEYSYMS.put(Integer.valueOf(0x161), "KEY_SELECT");
		KEYSYMS.put(Integer.valueOf(0x162), "KEY_GOTO");
		KEYSYMS.put(Integer.valueOf(0x163), "KEY_CLEAR");
		KEYSYMS.put(Integer.valueOf(0x164), "KEY_POWER2");
		KEYSYMS.put(Integer.valueOf(0x165), "KEY_OPTION");
		KEYSYMS.put(Integer.valueOf(0x166), "KEY_INFO");
		KEYSYMS.put(Integer.valueOf(0x167), "KEY_TIME");
		KEYSYMS.put(Integer.valueOf(0x168), "KEY_VENDOR");
		KEYSYMS.put(Integer.valueOf(0x169), "KEY_ARCHIVE");
		KEYSYMS.put(Integer.valueOf(0x16a), "KEY_PROGRAM");
		KEYSYMS.put(Integer.valueOf(0x16b), "KEY_CHANNEL");
		KEYSYMS.put(Integer.valueOf(0x16c), "KEY_FAVORITES");
		KEYSYMS.put(Integer.valueOf(0x16d), "KEY_EPG");
		KEYSYMS.put(Integer.valueOf(0x16e), "KEY_PVR");
		KEYSYMS.put(Integer.valueOf(0x16f), "KEY_MHP");
		KEYSYMS.put(Integer.valueOf(0x170), "KEY_LANGUAGE");
		KEYSYMS.put(Integer.valueOf(0x171), "KEY_TITLE");
		KEYSYMS.put(Integer.valueOf(0x172), "KEY_SUBTITLE");
		KEYSYMS.put(Integer.valueOf(0x173), "KEY_ANGLE");
		KEYSYMS.put(Integer.valueOf(0x174), "KEY_ZOOM");
		KEYSYMS.put(Integer.valueOf(0x175), "KEY_MODE");
		KEYSYMS.put(Integer.valueOf(0x176), "KEY_KEYBOARD");
		KEYSYMS.put(Integer.valueOf(0x177), "KEY_SCREEN");
		KEYSYMS.put(Integer.valueOf(0x178), "KEY_PC");
		KEYSYMS.put(Integer.valueOf(0x179), "KEY_TV");
		KEYSYMS.put(Integer.valueOf(0x17a), "KEY_TV2");
		KEYSYMS.put(Integer.valueOf(0x17b), "KEY_VCR");
		KEYSYMS.put(Integer.valueOf(0x17c), "KEY_VCR2");
		KEYSYMS.put(Integer.valueOf(0x17d), "KEY_SAT");
		KEYSYMS.put(Integer.valueOf(0x17e), "KEY_SAT2");
		KEYSYMS.put(Integer.valueOf(0x17f), "KEY_CD");
		KEYSYMS.put(Integer.valueOf(0x180), "KEY_TAPE");
		KEYSYMS.put(Integer.valueOf(0x181), "KEY_RADIO");
		KEYSYMS.put(Integer.valueOf(0x182), "KEY_TUNER");
		KEYSYMS.put(Integer.valueOf(0x183), "KEY_PLAYER");
		KEYSYMS.put(Integer.valueOf(0x184), "KEY_TEXT");
		KEYSYMS.put(Integer.valueOf(0x185), "KEY_DVD");
		KEYSYMS.put(Integer.valueOf(0x186), "KEY_AUX");
		KEYSYMS.put(Integer.valueOf(0x187), "KEY_MP3");
		KEYSYMS.put(Integer.valueOf(0x188), "KEY_AUDIO");
		KEYSYMS.put(Integer.valueOf(0x189), "KEY_VIDEO");
		KEYSYMS.put(Integer.valueOf(0x18a), "KEY_DIRECTORY");
		KEYSYMS.put(Integer.valueOf(0x18b), "KEY_LIST");
		KEYSYMS.put(Integer.valueOf(0x18c), "KEY_MEMO");
		KEYSYMS.put(Integer.valueOf(0x18d), "KEY_CALENDAR");
		KEYSYMS.put(Integer.valueOf(0x18e), "KEY_RED");
		KEYSYMS.put(Integer.valueOf(0x18f), "KEY_GREEN");
		KEYSYMS.put(Integer.valueOf(0x190), "KEY_YELLOW");
		KEYSYMS.put(Integer.valueOf(0x191), "KEY_BLUE");
		KEYSYMS.put(Integer.valueOf(0x192), "KEY_CHANNELUP");
		KEYSYMS.put(Integer.valueOf(0x193), "KEY_CHANNELDOWN");
		KEYSYMS.put(Integer.valueOf(0x194), "KEY_FIRST");
		KEYSYMS.put(Integer.valueOf(0x195), "KEY_LAST");
		KEYSYMS.put(Integer.valueOf(0x196), "KEY_AB");
		KEYSYMS.put(Integer.valueOf(0x197), "KEY_NEXT");
		KEYSYMS.put(Integer.valueOf(0x198), "KEY_RESTART");
		KEYSYMS.put(Integer.valueOf(0x199), "KEY_SLOW");
		KEYSYMS.put(Integer.valueOf(0x19a), "KEY_SHUFFLE");
		KEYSYMS.put(Integer.valueOf(0x19b), "KEY_BREAK");
		KEYSYMS.put(Integer.valueOf(0x19c), "KEY_PREVIOUS");
		KEYSYMS.put(Integer.valueOf(0x19d), "KEY_DIGITS");
		KEYSYMS.put(Integer.valueOf(0x19e), "KEY_TEEN");
		KEYSYMS.put(Integer.valueOf(0x19f), "KEY_TWEN");
		KEYSYMS.put(Integer.valueOf(0x1c0), "KEY_DEL_EOL");
		KEYSYMS.put(Integer.valueOf(0x1c1), "KEY_DEL_EOS");
		KEYSYMS.put(Integer.valueOf(0x1c2), "KEY_INS_LINE");
		KEYSYMS.put(Integer.valueOf(0x1c3), "KEY_DEL_LINE");
		KEYSYMS.put(Integer.valueOf(0x1d0), "KEY_FN");
		KEYSYMS.put(Integer.valueOf(0x1d1), "KEY_FN_ESC");
		KEYSYMS.put(Integer.valueOf(0x1d2), "KEY_FN_F1");
		KEYSYMS.put(Integer.valueOf(0x1d3), "KEY_FN_F2");
		KEYSYMS.put(Integer.valueOf(0x1d4), "KEY_FN_F3");
		KEYSYMS.put(Integer.valueOf(0x1d5), "KEY_FN_F4");
		KEYSYMS.put(Integer.valueOf(0x1d6), "KEY_FN_F5");
		KEYSYMS.put(Integer.valueOf(0x1d7), "KEY_FN_F6");
		KEYSYMS.put(Integer.valueOf(0x1d8), "KEY_FN_F7");
		KEYSYMS.put(Integer.valueOf(0x1d9), "KEY_FN_F8");
		KEYSYMS.put(Integer.valueOf(0x1da), "KEY_FN_F9");
		KEYSYMS.put(Integer.valueOf(0x1db), "KEY_FN_F10");
		KEYSYMS.put(Integer.valueOf(0x1dc), "KEY_FN_F11");
		KEYSYMS.put(Integer.valueOf(0x1dd), "KEY_FN_F12");
		KEYSYMS.put(Integer.valueOf(0x1de), "KEY_FN_1");
		KEYSYMS.put(Integer.valueOf(0x1df), "KEY_FN_2");
		KEYSYMS.put(Integer.valueOf(0x1e0), "KEY_FN_D");
		KEYSYMS.put(Integer.valueOf(0x1e1), "KEY_FN_E");
		KEYSYMS.put(Integer.valueOf(0x1e2), "KEY_FN_F");
		KEYSYMS.put(Integer.valueOf(0x1e3), "KEY_FN_S");
		KEYSYMS.put(Integer.valueOf(0x1e4), "KEY_FN_B");
		KEYSYMS.put(Integer.valueOf(0x1f1), "KEY_BRL_DOT1");
		KEYSYMS.put(Integer.valueOf(0x1f2), "KEY_BRL_DOT2");
		KEYSYMS.put(Integer.valueOf(0x1f3), "KEY_BRL_DOT3");
		KEYSYMS.put(Integer.valueOf(0x1f4), "KEY_BRL_DOT4");
		KEYSYMS.put(Integer.valueOf(0x1f5), "KEY_BRL_DOT5");
		KEYSYMS.put(Integer.valueOf(0x1f6), "KEY_BRL_DOT6");
		KEYSYMS.put(Integer.valueOf(0x1f7), "KEY_BRL_DOT7");
		KEYSYMS.put(Integer.valueOf(0x1f8), "KEY_BRL_DOT8");
		
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
		ANDROID_KEYS.add("Menu");
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
			bw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public static String getHumanReadable(Config config) {
		if(config == null) {
			return "";
		}
		
		BufferedWriter bw;
		StringWriter sw = new StringWriter();
		try {
			bw = new BufferedWriter(sw);
			config.saveHumanReadable(bw);
			bw.close();
		} catch (IOException e) {
			return "";
		}
		
		return sw.toString().trim();
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
			br.close();
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
	public static String convertKeysym(Integer v) {
		if(v == null) {
			return null;
		}
		
		if(KEYSYMS.containsKey(v)) {
			return KEYSYMS.get(v);
		}
		
		return null;
	}
	
	public static Integer convertHRToKeySym(String hrString) {		
		return convertString("KEY_" + hrString.toUpperCase()
								.replace("ESCAPE", "ESC")
								.replace("EQUALS", "EQUAL")
								.replace("NUMPAD", "KP")
								.replace(" ", "")
								.replace("/", ""));
	}

	/**
	 * Change KEY_* string to a keysym integer
	 * @param v KEY_* string
	 * @return keysym value
	 */
	public static Integer convertString(String v) {
		if(v == null) {
			return null;
		}

		for(Map.Entry<Integer, String> entry : KEYSYMS.entrySet()) {
			if(v.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		
		return null;
	}
	
	public static String encodeMetadata(String s) {
		try {
			return Base64.encodeToString(s.getBytes("UTF-16"),
					Base64.NO_PADDING | Base64.NO_WRAP | Base64.URL_SAFE);
		} catch(Exception e) {
			Log.e(TAG, "Error retrieving UTF-16 charset.", e);
			return "";
		}
	}
	
	public static String decodeMetadata(String s) {	
		try {
			return Charset.forName("UTF-16").decode(
					ByteBuffer.wrap(Base64.decode(s, Base64.URL_SAFE))).toString();
		} catch(Exception e) {
			Log.e(TAG, "Error retrieving UTF-16 charset.", e);
			return "";
		}
	}
}
