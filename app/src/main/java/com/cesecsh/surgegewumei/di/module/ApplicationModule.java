package com.cesecsh.surgegewumei.di.module;

import android.app.Application;
import android.content.Context;

import com.cesecsh.surgegewumei.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

@Module
@Singleton
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


}
