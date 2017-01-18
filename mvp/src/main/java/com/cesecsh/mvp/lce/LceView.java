package com.cesecsh.mvp.lce;

import android.support.annotation.UiThread;

import com.cesecsh.mvp.MvpView;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public interface LceView<M> extends MvpView {
    @UiThread
    void showLoading();

    @UiThread
    void showContent(M data);

    @UiThread
    void dismissLoading();

    @UiThread
    void showError(Throwable e);

    @UiThread
    void showEmpty();
}
