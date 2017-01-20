package com.cesecsh.surgegewumei.di.component;


import android.app.Activity;

import com.cesecsh.surgegewumei.di.module.ActivityModule;
import com.cesecsh.surgegewumei.di.scope.PerActivity;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
