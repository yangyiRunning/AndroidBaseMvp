package com.example.wanmen.wanmendx_android_mvp.data.tab;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by yangyi on 2017/4/17.
 */

public class TitleTabEntity implements CustomTabEntity{

    private String title;

    public TitleTabEntity(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
