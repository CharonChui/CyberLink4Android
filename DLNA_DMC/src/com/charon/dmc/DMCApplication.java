package com.charon.dmc;

import java.util.ArrayList;
import java.util.List;

import org.cybergarage.upnp.ControlPoint;

import android.app.Activity;
import android.app.Application;

public class DMCApplication extends Application {
	private static DMCApplication mDmcApplication;

	private List<Activity> activities;

	public static DMCApplication getInstance() {
		return mDmcApplication;
	}

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

	public void addActivity(Activity activity) {
		if (activities != null) {
			activities.add(activity);
		}
	}

	public void removeActivity(Activity activity) {
		if (activities != null) {
			activities.remove(activity);
		}
	}

	public void quit() {
		if (activities != null) {
			for (Activity activity : activities) {
				activity.finish();
			}
			activities = null;
		}
	}

	public void setControlPoint(ControlPoint controlPoint) {
		mControlPoint = controlPoint;
	}
}
