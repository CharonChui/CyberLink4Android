package com.charon.dmc;

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
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
