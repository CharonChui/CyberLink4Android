package com.charon.dmc.engine;

import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.device.DeviceChangeListener;

import com.charon.dmc.util.LogUtil;

/**
 * The new thread to search the devices.
 */
public class SearchThread extends Thread {
	private boolean flag = true;
	private ControlPoint mControlPoint;
	private boolean mStartComplete;
	private int mSearchTimes;
	private static final int mFastInternalTime = 15000;
	private static final int mNormalInternalTime = 3600000;
	private static final String TAG = "SearchThread";

	public SearchThread(ControlPoint mControlPoint) {
		super();
		this.mControlPoint = mControlPoint;
		this.mControlPoint.addDeviceChangeListener(mDeviceChangeListener);
	}

	@Override
	public void run() {
		while (flag) {
			if (mControlPoint == null) {
				break;
			}
			searchDevices();
		}
	}

	private void searchDevices() {
		try {
			if (mStartComplete) {
				mControlPoint.search();
				LogUtil.d(TAG, "controlpoint search...");
			} else {
				mControlPoint.stop();
				boolean startRet = mControlPoint.start();
				LogUtil.d(TAG, "controlpoint start:" + startRet);
				if (startRet) {
					mStartComplete = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		synchronized (this) {
			try {
				mSearchTimes++;
				if (mSearchTimes >= 5) {
					wait(mNormalInternalTime);
				} else {
					wait(mFastInternalTime);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void setSearcTimes(int searchTimes) {
		this.mSearchTimes = searchTimes;
	}

	public void awake() {
		synchronized (this) {
			notifyAll();
		}
	}
	
	public void stopThread() {
		flag = false;
		awake();
	}

	private DeviceChangeListener mDeviceChangeListener = new DeviceChangeListener() {

		@Override
		public void deviceRemoved(Device dev) {
			LogUtil.d(TAG, "control point remove a device");
			DLNAContainer.getInstance().removeDevice(dev);
		}

		@Override
		public void deviceAdded(Device dev) {
			LogUtil.d(TAG, "control point add a device...");
			DLNAContainer.getInstance().addDevice(dev);
		}
	};
}