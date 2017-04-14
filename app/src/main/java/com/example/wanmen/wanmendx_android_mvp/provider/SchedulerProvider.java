package com.example.wanmen.wanmendx_android_mvp.provider;

import android.support.annotation.NonNull;

import com.example.wanmen.wanmendx_android_mvp.base.BaseSchedulerProvider;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yangyi on 2017/4/13.
 */

public class SchedulerProvider<T> implements BaseSchedulerProvider, Observable.Transformer<T, T> {

    private static BaseSchedulerProvider schedulerProvider;

    public SchedulerProvider() {

    }

    public static BaseSchedulerProvider getSchedulerProviderSingleTon() {
        if (schedulerProvider == null) {
            synchronized (SchedulerProvider.class) {
                if (schedulerProvider == null) {
                    schedulerProvider = new SchedulerProvider();
                }
            }
        }
        return schedulerProvider;
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler main() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.subscribeOn(io())
                .observeOn(main());
    }
}
