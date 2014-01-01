package com.charon.dmc;

import java.util.ArrayList;
import java.util.List;

import org.cybergarage.upnp.ControlPoint;

import android.app.Activity;
import android.app.Application;

public class DMCApplication extends Application {
	private static DMCApplication mDmcApplication;

	private List<Activity> activities;

	public ControlPoint mControlPoint;

	@Override
	public void onCreate() {
		super.onCreate();
		if (activities != null) {
			activities = null;
		}
		activities = new ArrayList<Activity>();
		mDmcApplication = this;
	}

	/**
	 * Add this activity to the list set. Please use this on the activity's
	 * onCreate method.
	 * 
	 * @param activity
	 *            The activity to be added.
	 */
	public void addActivity(Activity activity) {
		if (activities != null) {
			if (activities.contains(activity)) {
				activities.remove(activity);
			}
			activities.add(activity);
		}
	}

	/**
	 * Remove this activity from the list set. On every activity's onDestroy
	 * method we all should use this method.
	 * 
	 * @param activity
	 */
	public void removeActivity(Activity activity) {
		if (activities != null && activities.contains(activity)) {
			activities.remove(activity);
		}
	}

	/**
	 * Get the application instance.
	 * 
	 * @return DMCApplication
	 */
	public static DMCApplication getInstance() {
		return mDmcApplication;
	}

	/**
	 * Quit this application.
	 */
	public void quit() {
		if (activities != null) {
			for (Activity activity : activities) {
				activity.finish();
			}
			activities = null;
		}
	}

	/**
	 * Set the ControlPoint have been used in this application, to make sure it
	 * is the same one in this application.
	 * 
	 * @param controlPoint
	 *            The ControlPoint we have created first in this application.
	 */
	public void setControlPoint(ControlPoint controlPoint) {
		mControlPoint = controlPoint;
	}

	/**
	 * Get the ControlPoint have been set by setControlPoint method, this may be
	 * null.
	 * 
	 * @return The ControlPoint have been set by by setControlPoint.
	 */
	public ControlPoint getControlPoint() {
		return mControlPoint;
	}
}
