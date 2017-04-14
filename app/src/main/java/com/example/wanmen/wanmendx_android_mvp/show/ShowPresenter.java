package com.example.wanmen.wanmendx_android_mvp.show;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.wanmen.wanmendx_android_mvp.base.BaseSchedulerProvider;
import com.example.wanmen.wanmendx_android_mvp.base.BaseSubscriber;
import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;
import com.example.wanmen.wanmendx_android_mvp.data.source.WanmenRepository;
import com.example.wanmen.wanmendx_android_mvp.provider.SchedulerProvider;

import java.util.List;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by yangyi on 2017/4/12.
 */

public class ShowPresenter implements ShowContract.Presenter {

    @NonNull
    private ShowContract.View showFragment;
    @NonNull
    private WanmenRepository wanmenRepository;
    @NonNull
    private BaseSchedulerProvider baseSchedulerProvider;
    @NonNull
    private CompositeSubscription compositeSubscription;

    public ShowPresenter(@NonNull ShowContract.View showfrag,
                         WanmenRepository wanmenRepo) {

        showFragment = showfrag;//接V
        showFragment.setPresenter(this);//回传P
        wanmenRepository = wanmenRepo;//接M

        baseSchedulerProvider = SchedulerProvider.getSchedulerProviderSingleTon();
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void loadingData() {

        //读取数据 此方法写到sub内
        compositeSubscription.add(wanmenRepository
                .listReposWanmen("content")
                .compose(new SchedulerProvider<List<WanmenData>>())
                .subscribe(new BaseSubscriber<List<WanmenData>>(showFragment) {

                    @Override
                    public void success(List<WanmenData> wanmenDataList) {
                        Log.e("success", "success");
                        showFragment.showRecycler(wanmenDataList);
                    }
                }));

    }

    //这个方法会在V的resume生命周期中调用
    @Override
    public void subscribe() {
        loadingData();
    }

    @Override
    public void unsubscribe() {
        //此方法用来回收，如单例释放或者Rx释放
        compositeSubscription.clear();
    }

}
