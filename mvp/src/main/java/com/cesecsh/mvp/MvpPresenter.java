package com.cesecsh.mvp;

import android.support.annotation.UiThread;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public interface MvpPresenter<V extends MvpView> {
    /**
     * set or attach the view to this presenter
     *
     * @param view
     */
    @UiThread
    void attachView(V view);

    /**
     * will be called if the view has been destroyed , Typically this method will be invoked from
     * Activity.detachView() or Fragment.onDestroyView()
     */
    @UiThread
    void detachView();
}
