package org.cvpcs.android.cwiidconfig.config;

import android.util.Log;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Comparable;

public class Preset implements Comparable<Preset> {
	private static final String TAG = "CWiiDConfig/Preset";
	
	protected String mName;
	protected String mSummary;
	protected File mPresetFile;
	protected Config mConfig;
	
	public Preset(File f) {
		mPresetFile = f;

		mName = mPresetFile.getName();
		mSummary = null;
		mConfig = null;

		// attempt to load metadata
		loadMetadata();
	}

	public String getName() { return mName; }
	public String getSummary() { return mSummary; }
	
	public File getFile() { return mPresetFile; }
	
	public void setName(String s) { mName = s; }
	public void setSummary(String s) { mSummary = s; }
	
	public boolean exists() { return (mPresetFile.exists()); }
	public boolean isSystem() { return (mPresetFile.exists() && !mPresetFile.canWrite()); }
	
	public Config getConfig() {
		if(mConfig == null) {
			loadConfig();
		}

		// overwrite our name/summary
		mConfig.setName(mName);
		mConfig.setSummary((mSummary == null ? "" : mSummary));
		
		return mConfig;
	}
	
	public void setConfig(Config c) {
		mConfig = c;
	}
	
	public void loadConfig() {
		mConfig = null;

		if(mPresetFile.exists()) {
			mConfig = ConfigManager.load(mPresetFile);
		}
	
		if(mConfig == null) {
			mConfig = new Config();
		}
	}
	
	public void save() {
		if(mConfig != null) {
			mConfig.setName(mName);
			mConfig.setSummary((mSummary == null ? "" : mSummary));
			ConfigManager.save(mConfig, mPresetFile);
		}
	}
	
	public boolean delete() {
		if(isSystem()) {
			return false;
		}

		boolean was_deleted = false;

		try {
			was_deleted = mPresetFile.delete();
		} catch(SecurityException e) {
			Log.e(TAG, "Error deleting preset: " + mPresetFile.getAbsolutePath(), e);
		}
		
		if(was_deleted) {
			mConfig = null;
		}

		return was_deleted;
	}

	private void loadMetadata() {
		if(!mPresetFile.exists() || !mPresetFile.isFile() || !mPresetFile.canRead()) {
			return;
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(mPresetFile));

			String line = null;
			while((line = br.readLine()) != null) {
				// first make sure we are dealing with a comment
				if(line.length() <= 0 ||
				   line.charAt(0) != '#') {
					continue;
				}

				// now begin parsing metadata
				if(line.indexOf("#name=") == 0 && line.length() > 6) {
					mName = ConfigManager.decodeMetadata(line.substring(6)); 
				} else if(line.indexOf("#summary=") == 0 && line.length() > 9) {
					mSummary = ConfigManager.decodeMetadata(line.substring(9));
				}
			}

			br.close();
		} catch(Exception e) {
			Log.e(TAG, "Error loading metadata for preset: " + mPresetFile.getAbsolutePath(), e);
		}
	}

	public int compareTo(Preset another) {
		Preset another_preset = (Preset)another;

		return mPresetFile.compareTo(another_preset.getFile());
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!Preset.class.isInstance(o)) return false;
		
		Preset other = (Preset)o;
		
		return (mPresetFile.equals(other.getFile()));
	}
	
	public int hashCode() {
		return mPresetFile.hashCode();
	}
}
