package com.example.wanmen.wanmendx_android_mvp.network.api;

import com.example.wanmen.wanmendx_android_mvp.data.GitHubData;
import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yangyi on 2017/4/13.
 */

public interface WanmenService {

    @GET("users/{user}/repos")
    Observable<List<GitHubData>> listRepos(@Path("user") String user);

    @GET("4.0/{content}/recommendations")
    Observable<List<WanmenData>> listReposWanmen(@Path("content") String content);

}
