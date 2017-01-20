package com.cesecsh.surgegewumei.data.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 上海中电
 * on 2016/12/29
 */

public abstract class BaseRetrofit {
    public Retrofit getICSAPiService() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(ICSApis.BASE_URL)
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }


    public abstract OkHttpClient getHttpClient();
}
