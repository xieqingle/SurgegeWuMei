package com.cesecsh.surgegewumei.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;

import com.cesecsh.mvp.lce.LoadView;
import com.cesecsh.surgegewumei.view.widget.LoadingView;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public abstract class BaseLoadingActivity extends BaseActivity implements LoadView {
    protected LoadingView mLoadingView;
    private String loadMessage;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mLoadingView = new LoadingView(this, getLoadMessage());
    }

    @Override
    public void showLoading() {
        mLoadingView.show();
    }

    @Override
    public void dismissLoading() {
        mLoadingView.dismiss();
    }

    @Override
    public void showError(Throwable e) {
        Snackbar.make(getWindow().getDecorView(), e.getMessage(), Snackbar.LENGTH_SHORT).show();
    }

    public abstract String getLoadMessage();
}
