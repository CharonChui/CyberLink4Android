package com.charon.dmc;

import com.charon.dmc.inter.IController;

import android.app.Activity;
import android.os.Bundle;

public class ControlActivity extends Activity{
	private IController mController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);

	}
	
	public void setController(IController controller) {
		this.mController = controller;
	}
}
