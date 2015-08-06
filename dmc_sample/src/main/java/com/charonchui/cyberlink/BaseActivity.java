package com.charon.cyberlink;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DMCApplication.getInstance().addActivity(this);
	}

	@Override
	protected void onDestroy() {
		DMCApplication.getInstance().removeActivity(this);
		super.onDestroy();
	}
}
