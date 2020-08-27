package com.example.hymnal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                    SplashScreenActivity.this.overridePendingTransition(0, 0);
                    finish();
            }
        }, 3000);
    }
}