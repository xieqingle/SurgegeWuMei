package com.cesecsh.surgegewumei.data.net.response;


import com.cesecsh.surgegewumei.data.constant.CodeState;
import com.cesecsh.surgegewumei.data.net.response.json.ListJson;
import com.cesecsh.surgegewumei.manager.ActivityManager;
import com.cesecsh.surgegewumei.manager.AlertDialogManager;
import com.cesecsh.surgegewumei.view.widget.ToastView;

import java.util.List;

import rx.Subscriber;

/**
 * Created by 上海中电
 * on 2017/1/3
 */

public abstract class ListResponse<T> extends Subscriber<ListJson> {

    @Override
    public void onNext(ListJson listJson) {
        if (listJson != null) {
            switch (Integer.valueOf(listJson.getCode())) {
                case CodeState.SUCCESS:
                    onSuccess((List<T>) listJson.getObjs());
                    break;
                case CodeState.LOGIN_OVERDUE:
                    AlertDialogManager.showLoginOverdue(ActivityManager.getInstance().getTaskTop());
                    break;
                case CodeState.PERMISSION_DENY:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.PERMISSION_DENY), ToastView.TYPE_WARNING);
                    break;
                case CodeState.PARAM_ERROR:
                    ToastView.getInstance().toast(listJson.getMessage(), ToastView.TYPE_WARNING);
                    break;
                case CodeState.SERVER_ERROR:
                    ToastView.getInstance().toast(CodeState.getMessage(CodeState.SERVER_ERROR), ToastView.TYPE_WARNING);
                    break;
                default:
            }
        }
    }


    public abstract void onSuccess(List<T> objs);
}
