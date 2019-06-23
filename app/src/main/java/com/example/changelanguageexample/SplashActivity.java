package com.example.changelanguageexample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String CurrentLang=ConfigurationFile.getCurrentLanguage(SplashActivity.this);
        ConfigurationFile.setCurrentLanguage(SplashActivity.this,ConfigurationFile.getCurrentLanguage(SplashActivity.this));
        Log.d(TAG, "onCreate: ");

        mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        int SPLASH_DISPLAY_LENGTH = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
