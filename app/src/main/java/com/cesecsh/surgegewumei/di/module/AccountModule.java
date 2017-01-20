package com.cesecsh.surgegewumei.di.module;

import com.cesecsh.surgegewumei.data.api.AccountApi;
import com.cesecsh.surgegewumei.di.AccountDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 上海中电
 * on 2017/1/19
 */

@Module
public class AccountModule {

    @Provides
    AccountApi provideAccountApi(AccountDataSource accountDataSource) {
        return accountDataSource;
    }
}
