package com.cesecsh.surgegewumei;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.cesecsh.surgegewumei.di.component.ApplicationComponent;
import com.cesecsh.surgegewumei.di.component.DaggerApplicationComponent;
import com.cesecsh.surgegewumei.di.module.ApplicationModule;

/**
 * Created by 上海中电
 * on 2017/1/5
 */

public class BaseApplication extends Application {
    public static int newCounts = 0;
    private static Context mContext;
    private static Handler mHandler;
    private static int mMainThreadId;
    private ApplicationComponent applicationComponent;

    public static int getNewCounts() {
        return newCounts;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
        initDagger();
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    public static void init(Application application) {
        mContext = application.getApplicationContext();
        mHandler = new Handler();
        mMainThreadId = android.os.Process.myTid();
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }


    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }
}
