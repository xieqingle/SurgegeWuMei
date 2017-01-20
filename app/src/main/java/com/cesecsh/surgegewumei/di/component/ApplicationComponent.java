package com.cesecsh.surgegewumei.di.component;

import android.app.Application;
import android.content.Context;

import com.cesecsh.surgegewumei.di.module.ApplicationModule;
import com.cesecsh.surgegewumei.di.qualifier.ApplicationContext;

import dagger.Component;

/**
 * Created by 上海中电
 * on 2017/1/19
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext
    Context context();

    Application application();
}

