package com.example.wanmen.wanmendx_android_mvp.base;

import android.util.Log;

import com.example.wanmen.wanmendx_android_mvp.show.ShowContract;

import rx.Subscriber;

/**
 * Created by yangyi on 2017/4/13.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    private ShowContract.View showFrag;

    public BaseSubscriber(ShowContract.View show) {
        showFrag = show;
    }

    public abstract void success(T t);

    @Override
    public void onCompleted() {
        Log.e("onCompleted", "onCompleted");
        showFrag.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        Log.e("onError", "onError");
    }

    @Override
    public void onNext(T t) {
        Log.e("onNext", "onNext");
        success(t);
    }

    @Override
    public void onStart() {
        showFrag.showLoading();
    }
}
