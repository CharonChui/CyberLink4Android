package com.charon.dmc.engine;

import org.cybergarage.upnp.Device;

import com.charon.dmc.inter.IController;

public class MultiPointController implements IController {

	@Override
	public boolean play(Device device, String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goon(Device device, String pausePosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTransportState(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVolumeDbRange(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean seek(Device device, String targetPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPositionInfo(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMediaDuration(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setMute(Device mediaRenderDevice, String targetValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMute(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setVoice(Device device, int value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVoice(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean stop(Device mediaRenderDevice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pause(Device mediaRenderDevice) {
		// TODO Auto-generated method stub
		return false;
	}

}
