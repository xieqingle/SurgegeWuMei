package com.cesecsh.surgegewumei.data.net.response;


import com.cesecsh.surgegewumei.data.constant.CodeState;
import com.cesecsh.surgegewumei.data.net.response.json.SimpleJson;
import com.cesecsh.surgegewumei.manager.ActivityManager;
import com.cesecsh.surgegewumei.manager.AlertDialogManager;
import com.cesecsh.surgegewumei.view.widget.ToastView;

import rx.Subscriber;

/**
 * Created by 上海中电
 * on 2017/1/3
 */

public abstract class SimpleResponse<T> extends Subscriber<SimpleJson> {

    @Override
    public void onNext(SimpleJson simpleJson) {
        if (simpleJson != null) {
            switch (Integer.valueOf(simpleJson.getCode())) {
                case CodeState.SUCCESS:
                    onSuccess(simpleJson);
                    break;
                case CodeState.LOGIN_OVERDUE:
                    AlertDialogManager.showLoginOverdue(ActivityManager.getInstance().getTaskTop());
                    break;
                case CodeState.PERMISSION_DENY:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.PERMISSION_DENY), ToastView.TYPE_WARNING);
                    break;
                case CodeState.PARAM_ERROR:
                    ToastView.getInstance().toast(simpleJson.getMessage(), ToastView.TYPE_WARNING);
                    break;
                case CodeState.SERVER_ERROR:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.SERVER_ERROR), ToastView.TYPE_WARNING);
                    break;
                default:
            }
        }
    }


    public abstract void onSuccess(SimpleJson simpleJson);
}
