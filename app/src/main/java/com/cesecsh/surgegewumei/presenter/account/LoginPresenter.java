package com.cesecsh.surgegewumei.presenter.account;

import android.app.Application;

import com.cesecsh.surgegewumei.data.api.AccountApi;
import com.cesecsh.surgegewumei.data.domain.User;
import com.cesecsh.surgegewumei.data.net.response.NormalResponse;
import com.cesecsh.surgegewumei.presenter.base.RxMvpPresenter;
import com.cesecsh.surgegewumei.ui.account.LoginView;

import javax.inject.Inject;

/**
 * Created by 上海中电
 * on 2017/1/19
 */

public class LoginPresenter extends RxMvpPresenter<LoginView> {
    private final AccountApi accountApi;

    @Inject
    public LoginPresenter(AccountApi accountApi) {
        this.accountApi = accountApi;
    }

    @Inject
    Application mContext;

    public void login(String username, String password) {
        mCompositeSubscription.add(accountApi.login(username, password)
                .doOnSubscribe(() -> getMvpView().showLoading())
                .doOnTerminate(() -> getMvpView().dismissLoading())
                .subscribe(new NormalResponse<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e);

                    }

                    @Override
                    public void onSuccess(User user) {
                        getMvpView().onSuccess(user);
                    }
                }))
        ;
    }
}
