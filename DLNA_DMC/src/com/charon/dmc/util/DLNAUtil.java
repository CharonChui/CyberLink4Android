package com.charon.dmc.util;

import org.cybergarage.upnp.Device;

public class DLNAUtil {
	/**
	 * DMR
	 * 
	 * @param device
	 * @return
	 */
	public static boolean isMediaRenderDevice(Device device) {
		if ("urn:schemas-upnp-org:device:MediaRenderer:1"
				.equalsIgnoreCase(device.getDeviceType())) {
			return true;
		}
		return false;
	}
}
