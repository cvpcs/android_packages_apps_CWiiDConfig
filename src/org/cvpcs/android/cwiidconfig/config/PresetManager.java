package org.cvpcs.android.cwiidconfig.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class PresetManager {
	// directories we know cwiid will scan for config files
	public static File[] PRESET_SCAN_DIRECTORIES = {
		new File("/system/etc/cwiid/wminput"),
		new File("/sdcard/.cwiid/wminput")
	};

	private static ArrayList<Preset> PRESETS = null;

	public static void scanPresets() {
		if(PRESETS == null) {
			PRESETS = new ArrayList<Preset>();
		}

		PRESETS.clear();

		// scan the known config directories for presets
		for(File config_dir : PRESET_SCAN_DIRECTORIES) {
			// sanity check
			if(!config_dir.exists() || !config_dir.isDirectory()) {
				continue;
			}

			// we don't scan recursively because cwiid won't
			for(File config_file : config_dir.listFiles()) {
				// ignore directories/sanity check
				if(!config_file.exists() || !config_file.isFile()) {
					continue;
				}

				PRESETS.add(new Preset(config_file));
			}
		}

		Collections.sort(PRESETS);
	}

	public static int getNumPresets() {
		if(PRESETS == null) {
			scanPresets();
		}

		return PRESETS.size();
	}

	public static Preset getPreset(int idx) {
		if(PRESETS == null) {
			scanPresets();
		}

		if(idx < PRESETS.size()) {
			return PRESETS.get(idx);
		} else {
			return null;
		}
	}
}
