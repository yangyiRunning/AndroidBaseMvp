package com.example.wanmen.wanmendx_android_mvp.network.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangyi on 2017/4/13.
 */

public class NetBase {

    private static int connectTimeout = 30000;
    private static int readTimeout = 5000;
    private static int writeTimeout = 5000;
    private String TEST_URL = "http://api.wanmen.org/";//https://api.github.com/
    public static NetBase NetBaseSingleTon;
    private Retrofit retrofit;

    public NetBase() {
        initRetrofit();
    }

    public static NetBase getNetBaseSingleTon() {
        if (NetBaseSingleTon == null) {
            synchronized (NetBase.class) {
                if (NetBaseSingleTon == null) {
                    return new NetBase();
                }
            }
        }
        return NetBaseSingleTon;
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(TEST_URL)
                .client(app_okHttpClient)
                .build();
    }

    private OkHttpClient app_okHttpClient = new OkHttpClient.Builder()
//            .addInterceptor(new SignInterceptor())
            .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
            .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
            .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
            .build();

    public <T> T create(Class<T> reqServer) {
        return retrofit.create(reqServer);
    }
}
