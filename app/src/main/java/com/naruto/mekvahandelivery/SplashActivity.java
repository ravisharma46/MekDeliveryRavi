package com.naruto.mekvahandelivery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.onboarding.OnBoardingActivity;

public class SplashActivity extends AppCompatActivity {


    private LoginSessionManager mSession;
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSession=new LoginSessionManager(getApplicationContext());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(() -> {


            if (!mSession.isLoggedIn()) {
                mSession.checkLogin();
                Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                startActivity(intent);

            }
            else{
                Intent intent = new Intent(SplashActivity.this, NavActivity.class);
                startActivity(intent);
            }

           finish();
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}