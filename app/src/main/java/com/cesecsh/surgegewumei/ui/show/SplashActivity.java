package com.cesecsh.surgegewumei.ui.show;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.cesecsh.surgegewumei.R;
import com.cesecsh.surgegewumei.ui.account.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> LoginActivity.launch(SplashActivity.this), 2000);
    }
}
