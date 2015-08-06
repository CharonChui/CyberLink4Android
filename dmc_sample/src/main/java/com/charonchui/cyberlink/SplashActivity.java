package com.charon.cyberlink;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.charon.cyberlink.engine.DLNAContainer;
import com.charon.cyberlink.service.DLNAService;

/**
 * Splash activity, show the welcome image and start the DLNAService.
 * 
 * @author CharonChui
 * 
 */
public class SplashActivity extends BaseActivity {
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
				startMainActivity();
			}
		}, sDelayTime);
	}

	private void playAnimation() {
		AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
		alphaAnimation.setDuration(sDelayTime);
		alphaAnimation.setFillAfter(true);
		iv_splash.startAnimation(alphaAnimation);
	}

	private void startMainActivity() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
		finish();
	}

	private void startDLNAService() {
		// Clear the device container.
		DLNAContainer.getInstance().clear();
		Intent intent = new Intent(getApplicationContext(), DLNAService.class);
		startService(intent);
	}

}
