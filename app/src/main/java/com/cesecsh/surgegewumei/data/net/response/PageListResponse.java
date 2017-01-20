package com.cesecsh.surgegewumei.data.net.response;


import com.cesecsh.surgegewumei.data.constant.CodeState;
import com.cesecsh.surgegewumei.data.net.response.json.PageListInfo;
import com.cesecsh.surgegewumei.data.net.response.json.PageListJson;
import com.cesecsh.surgegewumei.manager.ActivityManager;
import com.cesecsh.surgegewumei.manager.AlertDialogManager;
import com.cesecsh.surgegewumei.view.widget.ToastView;

import rx.Subscriber;

/**
 * Created by 上海中电
 * on 2016/12/29
 */

public abstract class PageListResponse<T> extends Subscriber<PageListJson> {

    @Override
    public void onNext(PageListJson pageListJson) {
        if (pageListJson != null) {
            switch (Integer.valueOf(pageListJson.getCode())) {
                case CodeState.SUCCESS:
                    onSuccess(pageListJson.getPageListInfo());
                    break;
                case CodeState.LOGIN_OVERDUE:
                    AlertDialogManager.showLoginOverdue(ActivityManager.getInstance().getTaskTop());
                    break;
                case CodeState.PERMISSION_DENY:
                    ToastView.getInstance().toast( CodeState.getMessage(CodeState.PERMISSION_DENY), ToastView.TYPE_WARNING);
                    break;
                case CodeState.PARAM_ERROR:
                    ToastView.getInstance().toast( pageListJson.getMessage(), ToastView.TYPE_WARNING);
                    break;
                case CodeState.SERVER_ERROR:
                    ToastView.getInstance().toast( CodeState.getMessage(CodeState.SERVER_ERROR), ToastView.TYPE_WARNING);
                    break;
                default:
            }
        }

    }

    public abstract void onSuccess(PageListInfo<T> pageListInfo);
}
