package org.cvpcs.android.cwiidconfig;

public class CWiiDManager {
	public static final String CTRL_PROPERTY = "service.gem.cwiid.on";
	public static final String STATE_PROPERTY = "service.gem.cwiid.status";

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

	public static void startDaemon() {
		// set CTRL_PROPERTY = 1
	}

	public static void stopDaemon() {
		// set CTRL_PROPERTY = 0
	}

	public static State getState() {
		String state = "";

		// retrieve STATUS_PROPERTY

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
