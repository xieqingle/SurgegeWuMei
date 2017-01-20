package com.cesecsh.surgegewumei.data.api;

import com.cesecsh.surgegewumei.data.domain.User;
import com.cesecsh.surgegewumei.data.net.response.json.NormalJson;

import rx.Observable;

/**
 * Created by mingjun on 16/7/27.
 */
public interface AccountApi {
    Observable<NormalJson<User>> login(String username, String password);
}
