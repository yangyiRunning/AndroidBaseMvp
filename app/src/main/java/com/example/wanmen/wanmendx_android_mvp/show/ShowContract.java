package com.example.wanmen.wanmendx_android_mvp.show;

import com.example.wanmen.wanmendx_android_mvp.base.BasePresenter;
import com.example.wanmen.wanmendx_android_mvp.base.BaseView;
import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;

import java.util.List;

/**
 * Created by yangyi on 2017/4/12.
 */

public interface ShowContract {

    interface View extends BaseView<Presenter> {
        void showLoading();
        void showRecycler(List<WanmenData> wanmenDataList);
        void hideLoading();
    }

    interface Presenter extends BasePresenter {
        void loadingData();
    }
}
