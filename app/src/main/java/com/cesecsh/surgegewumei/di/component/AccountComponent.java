package com.cesecsh.surgegewumei.di.component;


import com.cesecsh.surgegewumei.di.module.AccountModule;
import com.cesecsh.surgegewumei.di.module.ActivityModule;
import com.cesecsh.surgegewumei.di.scope.PerActivity;
import com.cesecsh.surgegewumei.ui.account.LoginActivity;

import dagger.Component;
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, AccountModule.class})
public interface AccountComponent extends ActivityComponent {

    void inject(LoginActivity loginActivity);
}
