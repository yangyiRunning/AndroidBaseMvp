package com.example.wanmen.wanmendx_android_mvp.base;

import android.support.annotation.NonNull;

import rx.Scheduler;

/**
 * Created by yangyi on 2017/4/13.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler main();

}
