package com.afanou.dev.android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	private MediaPlayer mySound;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		mySound = MediaPlayer.create(Splash.this, R.raw.splash_sound);
		mySound.start();
	}

	@Override
	protected void onResume() {
		// show the money manager basic activity after few seconds
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent(
							"com.afanou.dev.android.MENU");
					startActivity(intent);
				}
			};
		};
		timer.start();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		mySound.release();
		finish();
	}

}
