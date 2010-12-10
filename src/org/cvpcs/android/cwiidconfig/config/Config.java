package org.cvpcs.android.cwiidconfig.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class Config {
	
	private String mName;
	private String mSummary;
	private HashMap<String, Device> mDevices;
	
	public Config() {
		mName = "";
		mSummary = "";
		mDevices = new HashMap<String, Device>();
		mDevices.put(Wiimote.NAME, new Wiimote());
		mDevices.put(Nunchuk.NAME, new Nunchuk());
		mDevices.put(ClassicController.NAME, new ClassicController());
	}
	
	public Config(BufferedReader br) throws IOException {
		mName = "";
		mSummary = "";
		mDevices = new HashMap<String, Device>();
		mDevices.put(Wiimote.NAME, new Wiimote());
		mDevices.put(Nunchuk.NAME, new Nunchuk());
		mDevices.put(ClassicController.NAME, new ClassicController());
		load(br);
	}
	
	public String getName() { return mName; }
	public String getSummary() { return mSummary; }

	public void setName(String n) { mName = n; }
	public void setSummary(String s) { mSummary = s; }
	
	public Device getDevice(String name) {
		if(mDevices.containsKey(name)) {
			return mDevices.get(name);
		} else {
			return null;
		}
	}
	
	private boolean readLine(String line) {
		if (line.length() <= 0 ||
		    line.charAt(0) != '#') {
			return false;
		}
		if (line.indexOf("#name=") == 0 && line.length() > 6) {
			mName = ConfigManager.decodeMetadata(line.substring(6));
			return true;
		} else if (line.indexOf("#summary=") == 0 && line.length() > 9) {
	    	mSummary = ConfigManager.decodeMetadata(line.substring(9));
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	public void saveHumanReadable(BufferedWriter bw) throws IOException {
		for(Device d : mDevices.values()) {
			d.saveHumanReadable(bw);
			bw.newLine();
		}
	}
	
	public void save(BufferedWriter bw) throws IOException {
		if (!mName.equals("")) {
			bw.write("#name=" + ConfigManager.encodeMetadata(mName) + "\n");
		}
		if (!mSummary.equals("")) {
			bw.write("#summary=" + ConfigManager.encodeMetadata(mSummary) + "\n");
		}
		
		for(Device d : mDevices.values()) {
			d.save(bw);
		}
	}
	
	private void load(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			boolean wasRead = false;
			
			for(Device d : mDevices.values()) {
				if(d.readLine(line)) {
					wasRead = true;
					break;
				}
			}
			
			if(!wasRead) {
				readLine(line);
			}
		}
	}
}
