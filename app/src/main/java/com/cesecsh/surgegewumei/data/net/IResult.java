package com.cesecsh.surgegewumei.data.net;

/**
 * Created by 上海中电
 * on 2016/12/30
 */

public interface IResult {
    void onSuccess();

    void onError();

    void onStart();

    void onComplete();
}
