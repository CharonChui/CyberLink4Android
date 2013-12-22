package com.charon.dmc;

import com.charon.dmc.engine.DLNAContainer;
import com.charon.dmc.service.DLNAService;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {
	private ImageView iv_splash;

	private Handler handler = new Handler();

	private static final int sDelayTime = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		startDLNAService();
		findView();
		setUp();
	}
	
	private void findView() {
		iv_splash = (ImageView) findViewById(R.id.iv_splash);
	}

	private void setUp() {

		playAnimation();

		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				goMainActivity();
			}
		}, sDelayTime);
	}

	private void playAnimation() {
		AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
		alphaAnimation.setDuration(sDelayTime);
		alphaAnimation.setFillAfter(true);
		iv_splash.startAnimation(alphaAnimation);
	}

	private void goMainActivity() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
		finish();
	}

	private void startDLNAService() {
		DLNAContainer.getInstance().clear();
		Intent intent = new Intent(getApplicationContext(), DLNAService.class);
		startService(intent);
	}

}
