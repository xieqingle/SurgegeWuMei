package com.cesecsh.surgegewumei.data.net;


import com.cesecsh.surgegewumei.data.domain.Content;
import com.cesecsh.surgegewumei.data.domain.User;
import com.cesecsh.surgegewumei.data.net.response.json.NormalJson;
import com.cesecsh.surgegewumei.data.net.response.json.PageListInfo;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 上海中电
 * on 2016/12/29
 */

public interface ICSApis {
    String BASE_URL = "http://192.168.0.251:8888/ic/";

    @POST("clientUserController.app?appLogin")
    Observable<NormalJson<User>> login(@Query("params") String params);

    @POST("contentController.app?pageList")
    Observable<NormalJson<PageListInfo<Content>>> getContentPageList(@Query("params") String params);


}
