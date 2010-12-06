package org.cvpcs.android.cwiidconfig.config;

import java.io.File;

public class AutoPreset extends Preset {
	private static final File AUTO_PRESET_FILE = new File("/sdcard/.cwiid/wminput/.autopreset");
	private static AutoPreset AUTO_PRESET = null;
	
	public static AutoPreset getAutoPreset() {
		if(AUTO_PRESET == null) {
			AUTO_PRESET = new AutoPreset();
		}
		
		return AUTO_PRESET;
	}
	
	protected AutoPreset() {
		super(AUTO_PRESET_FILE);

		loadConfig();
	}
	
	public void save() {
		if(mConfig != null) {
			mConfig.setName("");
			mConfig.setSummary("");
			ConfigManager.save(mConfig, mPresetFile);
		}
	}
	
	public void loadFromPreset(Preset p) {
		mConfig = p.getConfig();
		
		if(mConfig != null) {
			mName = mConfig.getName();
			mSummary = mConfig.getSummary();
		}
		
		save();
	}
	
	public boolean canDelete() {
		return false;
	}
	
	public boolean delete() {
		return false;
	}
}
