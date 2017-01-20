package com.cesecsh.surgegewumei.data.net.response;

import com.cesecsh.surgegewumei.data.constant.CodeState;
import com.cesecsh.surgegewumei.data.net.response.json.NormalJson;
import com.cesecsh.surgegewumei.manager.ActivityManager;
import com.cesecsh.surgegewumei.manager.AlertDialogManager;
import com.cesecsh.surgegewumei.view.widget.ToastView;

import rx.Subscriber;

/**
 * Created by 上海中电
 * on 2016/12/29
 */

public abstract class NormalResponse<T> extends Subscriber<NormalJson> {

    @Override
    public void onNext(NormalJson normalJson) {
        if (normalJson != null) {
            switch (Integer.valueOf(normalJson.getCode())) {
                case CodeState.SUCCESS:
                    onSuccess((T) normalJson.getObj());
                    break;
                case CodeState.LOGIN_OVERDUE:
                    AlertDialogManager.showLoginOverdue(ActivityManager.getInstance().getTaskTop());
                    break;
                case CodeState.PERMISSION_DENY:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.PERMISSION_DENY), ToastView.TYPE_WARNING);
                    break;
                case CodeState.PARAM_ERROR:
                    ToastView.getInstance().toast(normalJson.getMessage(), ToastView.TYPE_WARNING);
                    break;
                case CodeState.SERVER_ERROR:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.SERVER_ERROR), ToastView.TYPE_WARNING);
                    break;
                default:
            }
        }

    }

    public abstract void onSuccess(T t);
}
