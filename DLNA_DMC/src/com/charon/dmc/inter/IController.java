package com.charon.dmc.inter;

import org.cybergarage.upnp.Device;

public interface IController {

	boolean play(Device device, String path);

	/**
	 * @param pausePosition The format must be 00:00:00.
	 */
	boolean goon(Device device, String pausePosition);

	/**
	 * All the state is "STOPPED" // "PLAYING" // "TRANSITIONING"//
	 * "PAUSED_PLAYBACK"// "PAUSED_RECORDING"// "RECORDING" //
	 * "NO_MEDIA_PRESENT//
	 */
	String getTransportState(Device device);

	int getMinVolumeValue(Device device);
	
	int getMaxVolumeValue(Device device);
	
	boolean seek(Device device, String targetPosition);

	int getPositionInfo(Device device);

	int getMediaDuration(Device device);

	/**
	 * @param targetValue
	 *            1 is that want mute, 0 if you want make it off of mute.
	 */
	boolean setMute(Device mediaRenderDevice, String targetValue);

	String getMute(Device device);

	boolean setVoice(Device device, int value);

	int getVoice(Device device);

	boolean stop(Device mediaRenderDevice);

	boolean pause(Device mediaRenderDevice);
}
