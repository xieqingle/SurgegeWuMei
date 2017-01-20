package com.cesecsh.surgegewumei.ui.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.ImageView;

import com.cesecsh.surgegewumei.BaseApplication;
import com.cesecsh.surgegewumei.R;
import com.cesecsh.surgegewumei.data.domain.User;
import com.cesecsh.surgegewumei.di.HasComponent;
import com.cesecsh.surgegewumei.di.component.AccountComponent;
import com.cesecsh.surgegewumei.di.component.DaggerAccountComponent;
import com.cesecsh.surgegewumei.di.module.AccountModule;
import com.cesecsh.surgegewumei.di.module.ActivityModule;
import com.cesecsh.surgegewumei.presenter.account.LoginPresenter;
import com.cesecsh.surgegewumei.ui.base.BaseLoadingActivity;
import com.cesecsh.surgegewumei.view.widget.ToastView;
import com.rey.material.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseLoadingActivity implements LoginView, HasComponent<AccountComponent> {


    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.username)
    EditText etUsername;
    @BindView(R.id.username_layout)
    TextInputLayout usernameLayout;
    @BindView(R.id.password)
    EditText etPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Inject
    LoginPresenter loginPresenter;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    public static void launchForResult(Activity activity) {
        activity.startActivityForResult(new Intent(activity, LoginActivity.class), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getComponent().inject(this);
        setTitle("登录");
    }

    @Override
    public AccountComponent getComponent() {
        return DaggerAccountComponent
                .builder()
                .applicationComponent(BaseApplication.get(this).getComponent())
                .accountModule(new AccountModule())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @OnClick(R.id.login_btn)
    public void onClick() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        loginPresenter.login(username, password);
    }

    @Override
    public String getLoadMessage() {
        return null;
    }

    @Override
    public void onSuccess(User user) {
        ToastView.makeText("登录成功");
    }
}
