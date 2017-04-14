package com.example.wanmen.wanmendx_android_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvitity_splash);

        gotoMainActivity();
    }

    private void gotoMainActivity() {
        SplashHandler splashHandler = new SplashHandler(this);
        Message msg = new Message();
        msg.what = 1;
        splashHandler.sendMessageDelayed(msg, 2000);
    }

    private static class SplashHandler extends Handler {

        WeakReference<SplashActivity> splashActivityWeakReference;

        SplashHandler(SplashActivity splashActivity) {
            this.splashActivityWeakReference = new WeakReference<>(splashActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            SplashActivity splashActivity = splashActivityWeakReference.get();
            switch (msg.what) {
                case 1:
                    splashActivity.startActivity(new Intent(splashActivity, MainActivity.class));
                    splashActivity.finish();
                    break;
            }
        }
    }
}
