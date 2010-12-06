package org.cvpcs.android.cwiidconfig.daemon;

import android.os.SystemProperties;

public class CWiiDManager {
	public static final String CTRL_PROPERTY = "gem.cwiid.on";
	public static final String STATE_PROPERTY = "gem.cwiid.status";
	public static final String CONF_PROPERTY = "persist.gem.cwiid.conf";

	public static enum State {
		INITIALIZING,
		DISCOVERING,
		READY,
		RECONNECTING,
		STOPPING,
		STOPPED,
		ERROR,
		UNKNOWN
	};

	private static final String STATE_INITIALIZING = "initializing";
	private static final String STATE_DISCOVERING = "discovering";
	private static final String STATE_READY = "ready";
	private static final String STATE_RECONNECTING = "reconnecting";
	private static final String STATE_STOPPING = "stopping";
	private static final String STATE_STOPPED = "stopped";
	private static final String STATE_ERROR = "error";

	public static void startDaemon(String config) {
		// set our configuration
		SystemProperties.set(CONF_PROPERTY, config);

		// reset our state to stopped
		SystemProperties.set(STATE_PROPERTY, STATE_STOPPED);

		// signal the system to start
		SystemProperties.set(CTRL_PROPERTY, "1");
	}

	public static void stopDaemon() {
		// signal the system to stop
		SystemProperties.set(CTRL_PROPERTY, "0");
	}

	public static void zapDaemon() {
		stopDaemon();
		
		SystemProperties.set(STATE_PROPERTY, STATE_STOPPED);
	}
	
	public static State getState() {
		// get the cwiid state, assumed stopped if it doesn't exist
		String state = SystemProperties.get(STATE_PROPERTY, STATE_STOPPED);

		if(state.equals(STATE_INITIALIZING)) {
			return State.INITIALIZING;
		} else if(state.equals(STATE_DISCOVERING)) {
			return State.DISCOVERING;
		} else if(state.equals(STATE_READY)) {
			return State.READY;
		} else if(state.equals(STATE_RECONNECTING)) {
			return State.RECONNECTING;
		} else if(state.equals(STATE_STOPPING)) {
			return State.STOPPING;
		} else if(state.equals(STATE_STOPPED)) {
			return State.STOPPED;
		} else if(state.equals(STATE_ERROR)) {
			return State.ERROR;
		} else {
			return State.UNKNOWN;
		}
	}
}
