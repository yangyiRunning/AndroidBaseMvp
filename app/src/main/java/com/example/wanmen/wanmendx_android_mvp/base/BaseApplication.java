package com.example.wanmen.wanmendx_android_mvp.base;

import android.app.Application;

/**
 * Created by yangyi on 2017/4/17.
 */

public abstract class BaseApplication extends Application {

    protected abstract void initApplicationConfig();

    protected abstract void initSDK();

    @Override
    public void onCreate() {
        super.onCreate();

        initApplicationConfig();
        initSDK();
    }
}
