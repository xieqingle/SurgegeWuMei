package com.cesecsh.surgegewumei.di;

import android.app.Application;

import com.cesecsh.surgegewumei.data.api.AccountApi;
import com.cesecsh.surgegewumei.data.domain.User;
import com.cesecsh.surgegewumei.data.net.CommonRetrofit;
import com.cesecsh.surgegewumei.data.net.ICSApis;
import com.cesecsh.surgegewumei.data.net.response.json.NormalJson;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by mingjun on 16/7/27.
 */
public class AccountDataSource implements AccountApi {

    @Inject
    CommonRetrofit mRetrofit;

    @Inject
    Application mContext;

    @Inject
    public AccountDataSource() {
    }

    @Override
    public Observable<NormalJson<User>> login(String username, String password) {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("username", username);
        requestMap.put("password", password);
        Gson gson = new Gson();
        String params = gson.toJson(requestMap);
        final ICSApis accountService = mRetrofit.getICSAPiService().create(ICSApis.class);
        return accountService.login(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
