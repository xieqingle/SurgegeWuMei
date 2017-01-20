package com.cesecsh.surgegewumei.presenter.base;

import com.cesecsh.mvp.BaseMvpPresenter;
import com.cesecsh.mvp.MvpView;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by 上海中电
 * on 2017/1/19
 */

public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {
    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
            mCompositeSubscription = null;
        }
    }
}
