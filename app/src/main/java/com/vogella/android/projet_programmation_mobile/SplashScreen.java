package com.vogella.android.projet_programmation_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.vogella.android.projet_programmation_mobile.view.MainActivity;

public class SplashScreen extends MainActivity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
