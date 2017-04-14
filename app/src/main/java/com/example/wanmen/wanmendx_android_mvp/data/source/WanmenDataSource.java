package com.example.wanmen.wanmendx_android_mvp.data.source;

import rx.Observable;

/**
 * Created by yangyi on 2017/4/13.
 */

public interface WanmenDataSource {

    Observable listReposWanmen(String content);
}
