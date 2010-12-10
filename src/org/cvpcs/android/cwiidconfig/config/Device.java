package org.cvpcs.android.cwiidconfig.config;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Device {
	private static final String TAG = "CWiiDConfig/Device";
	
	protected String mName;
	protected ArrayList<String> mButtons;
	protected ArrayList<String> mConfigButtons; 
	protected Pattern mPattern;
	private HashMap<String, Integer> mButtonMap;
	
	private Matcher mMatcher;
	
	public Device() {
		mName = "";
		mButtons = new ArrayList<String>();
		mConfigButtons = new ArrayList<String>();
		mPattern = Pattern.compile("(.)(.)");
		mButtonMap = new HashMap<String, Integer>();
	}
	
	public void setButton(String button, Integer keysym) {		
		// first check if they are setting a human-readable button
		if(mButtons.contains(button)) {
			if(keysym == null || keysym == 0) {
				mButtonMap.remove(button);
			} else {
				mButtonMap.put(button, keysym);
			}
		}
		
		// standard buttons not found, see if we're setting using a config button
		int i = mConfigButtons.indexOf(button);
		
		if(i >= 0 && i < mButtons.size()) {
			String cs = mButtons.get(i);
			
			if(keysym == null || keysym == 0) {
				mButtonMap.remove(cs);
			} else {
				mButtonMap.put(cs, keysym);
			}
		}
	}
	
	public Integer getButton(String button) {
		// first check if they are getting a human-readable button
		if(mButtons.contains(button) &&
				mButtonMap.containsKey(button)) {
			return mButtonMap.get(button);
		}
		
		// standard buttons not found, check if they're referencing a config button
		int i = mConfigButtons.indexOf(button);
		
		if(i >= 0 && i < mButtons.size()) {
			String cs = mButtons.get(i);
			
			if(mButtonMap.containsKey(cs)) {
				return mButtonMap.get(cs);
			}
		}
		
		return null;
	}
	
	public boolean readLine(String line) {
		if (line.length() <= 0 ||
		    line.charAt(0) == '#') {
			return false;
		}
		
		mMatcher = mPattern.matcher(line);
		
		if (mMatcher.find()) {
			String button = mMatcher.group(1);
			String value = mMatcher.group(3);
			
			setButton(button, Integer.valueOf(ConfigManager.convertString(value)));
			return true;
		} else {
			return false;
		}
	}
	
	public void saveHumanReadable(BufferedWriter bw) throws IOException {
		for(Map.Entry<String, Integer> entry : mButtonMap.entrySet()) {
			String button = entry.getKey();
			int keysym = entry.getValue().intValue();
			
			String key = null;
			
			for(String akey : ConfigManager.ANDROID_KEYS) {
				if(ConfigManager.convertHRToKeySym(akey) == keysym) {
					key = akey;
					break;
				}
			}
			
			if(key != null) {
				bw.write(mName + " " + button + " => " + key);
				bw.newLine();
			}
		}
	}
	
	public void save(BufferedWriter bw) throws IOException {
		for(Map.Entry<String, Integer> entry : mButtonMap.entrySet()) {
			String button = entry.getKey();
			int keysym = entry.getValue().intValue();
			
			int i = mButtons.indexOf(button);
			if(i >= 0 && i < mConfigButtons.size()) {
				bw.write(mConfigButtons.get(i) + "=" +
						ConfigManager.convertKeysym(keysym));
				bw.newLine();
			}
		}
	}
}
