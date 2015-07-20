package com.charon.cyberlink.util;

import android.util.Log;

/**
 * Log utilities that can control whether print the log.
 */
public class LogUtil {
	private static final int LOG_LEVEL = 6;

	private static final int VERBOSE = 5;
	private static final int DEBUG = 4;
	private static final int INFO = 3;
	private static final int WARN = 2;
	private static final int ERROR = 1;

	public static void v(String tag, String msg) {
		if (LOG_LEVEL > VERBOSE) {
			Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (LOG_LEVEL > DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (LOG_LEVEL > INFO) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (LOG_LEVEL > WARN) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (LOG_LEVEL > ERROR) {
			Log.e(tag, msg);
		}
	}
}
