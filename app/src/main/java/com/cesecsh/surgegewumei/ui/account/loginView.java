package com.cesecsh.surgegewumei.ui.account;

import com.cesecsh.mvp.lce.LoadView;
import com.cesecsh.surgegewumei.data.domain.User;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public interface LoginView extends LoadView {
    void onSuccess(User user);
}
