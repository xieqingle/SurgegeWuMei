package com.cesecsh.surgegewumei.data.net;


import com.cesecsh.surgegewumei.utils.sysUtils.NetworkUtils;
import com.cesecsh.surgegewumei.utils.sysUtils.PhoneUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 上海中电
 * on 2016/12/29
 */

public class LoginRetrofit extends BaseRetrofit {


    @Override
    public OkHttpClient getHttpClient() {
        return new ICSHTTPClient().get();
    }

    private class ICSHTTPClient extends BaseOkHttpClient {

        @Override
        public OkHttpClient.Builder customize(final OkHttpClient.Builder builder) {
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("ip", PhoneUtils.getPhoneType())
                            .addHeader("clientKey", NetworkUtils.getIpAddress()).build();
                    return chain.proceed(request);
                }
            });
            return builder;
        }
    }
}
