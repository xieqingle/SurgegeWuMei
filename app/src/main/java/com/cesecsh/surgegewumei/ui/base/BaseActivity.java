package com.cesecsh.surgegewumei.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.LayoutInflaterCompat;

import com.cesecsh.surgegewumei.permission.PermissionActivity;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

/**
 * Created by 上海中电
 * on 2017/1/18
 */

public class BaseActivity extends PermissionActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState, persistentState);

    }
}
