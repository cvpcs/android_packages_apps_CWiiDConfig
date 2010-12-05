package org.cvpcs.android.cwiidconfig.config;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Comparable;
import java.util.HashMap;

public class Preset implements Comparable {
	// a map from device button <-> key
	private HashMap<String, String> map;
	private String name;
	private String summary;
	private File presetFile;

	public Preset(File f) {
		map = new HashMap<String, String>();

		presetFile = f;

		name = presetFile.getName();
		summary = null;

		// attempt to load metadata
		loadMetadata();
	}

	public String getName() { return name; }
	public String getSummary() { return summary; }
	public boolean isValid() { return (presetFile.exists() && presetFile.canRead()); }
	public boolean canDelete() { return (presetFile.exists() && presetFile.canWrite()); }

	public void save() {}
	public boolean delete() {
		if(!canDelete()) {
			return false;
		}

		boolean was_deleted = false;

		try {
			was_deleted = presetFile.delete();
		} catch(SecurityException e) {
			// if we got here, then we were not allowed to delete due to security
			e.printStackTrace();
		}

		return was_deleted;
	}

	private void loadMetadata() {
		if(!presetFile.exists() || !presetFile.isFile() || !presetFile.canRead()) {
			return;
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(presetFile));

			String line = null;
			while((line = br.readLine()) != null) {
				// first make sure we are dealing with a comment
				if(line.charAt(0) != '#') {
					continue;
				}

				// now begin parsing metadata
				if(line.indexOf("#name=") == 0 && line.length() > 6) {
					name = line.substring(6);
				} else if(line.indexOf("#summary=") == 0 && line.length() > 9) {
					summary = line.substring(9);
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

		return name.compareTo(another_preset.getName());
	}
}
