package com.example.wanmen.wanmendx_android_mvp.data.source;

import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;
import com.example.wanmen.wanmendx_android_mvp.network.api.NetBase;
import com.example.wanmen.wanmendx_android_mvp.network.api.WanmenService;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by yangyi on 2017/4/13.
 */

public class WanmenRepository implements WanmenDataSource {

    private static WanmenRepository wanmenRepository;

    @Override
    public Observable<List<WanmenData>> listReposWanmen(String content) {
        return NetBase.getNetBaseSingleTon().create(WanmenService.class)
                .listReposWanmen(content)
                .filter(new Func1<List<WanmenData>, Boolean>() {
                    @Override
                    public Boolean call(List<WanmenData> wanmenDataList) {
                        return wanmenDataList != null && wanmenDataList.size() > 0;
                    }
                })
                .first();
    }

    public static WanmenRepository getInstance() {
        if (wanmenRepository == null) {
            synchronized (WanmenRepository.class) {
                if (wanmenRepository == null) {
                    wanmenRepository = new WanmenRepository();
                }
            }
        }
        return wanmenRepository;
    }


}
