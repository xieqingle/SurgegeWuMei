package com.cesecsh.mvp;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;

    @Override
    public void attachView(V view) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachException();
    }

    public static class MvpViewNotAttachException extends RuntimeException {
        public MvpViewNotAttachException() {
            super("please call Presenter.attachView(MvpView) before requesting data to the Presenter");
        }
    }
}
