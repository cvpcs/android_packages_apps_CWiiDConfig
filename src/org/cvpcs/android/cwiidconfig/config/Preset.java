package org.cvpcs.android.cwiidconfig.config;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Comparable;
import java.util.HashMap;

public class Preset implements Comparable {
	private String mName;
	private String mSummary;
	private File mPresetFile;
	private Config mConfig;

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
	public boolean isValid() { return (mPresetFile.exists() && mPresetFile.canRead()); }
	public boolean canDelete() { return (mPresetFile.exists() && mPresetFile.canWrite()); }
	public Config getConfig() {
		if(mConfig == null) {
			if(mPresetFile.exists()) {
				mConfig = ConfigManager.load(mPresetFile);
			}
			
			if(mConfig == null) {
				mConfig = new Config();
			}
		}

		// overwrite our name/summary
		mConfig.setName(mName);
		mConfig.setSummary((mSummary == null ? "" : mSummary));
		
		return mConfig;
	}
	
	public void save() {
		if(mConfig != null) {
			mConfig.setName(mName);
			mConfig.setSummary((mSummary == null ? "" : mSummary));
			ConfigManager.save(mConfig, mPresetFile);
		}
	}
	
	public boolean delete() {
		if(!canDelete()) {
			return false;
		}

		boolean was_deleted = false;

		try {
			was_deleted = mPresetFile.delete();
		} catch(SecurityException e) {
			// if we got here, then we were not allowed to delete due to security
			e.printStackTrace();
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
				if(line.charAt(0) != '#') {
					continue;
				}

				// now begin parsing metadata
				if(line.indexOf("#name=") == 0 && line.length() > 6) {
					mName = line.substring(6);
				} else if(line.indexOf("#summary=") == 0 && line.length() > 9) {
					mSummary = line.substring(9);
				}
			}

			br.close();
		} catch(Exception e) {
			// if something goes wrong we fail gracefully and assume no and/or
			// malformed metadata
			e.printStackTrace();
		}
	}

	public int compareTo(Object another) {
		Preset another_preset = (Preset)another;

		return mName.compareTo(another_preset.getName());
	}
}
