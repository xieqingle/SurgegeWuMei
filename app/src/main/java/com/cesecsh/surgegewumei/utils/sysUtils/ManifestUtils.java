package com.cesecsh.surgegewumei.utils.sysUtils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.cesecsh.surgegewumei.utils.viewUtils.ResourceUtils;


/**
 * Created by Administrator on 2016/9/1.
 */
public class ManifestUtils {
    /**
     * 获取Manifest Meta Data
     *
     * @param metaKey
     * @return
     */
    public static String getMetaData(String metaKey) {
        String name = ResourceUtils.getContext().getPackageName();
        ApplicationInfo appInfo;
        String msg = "";
        try {
            appInfo = ResourceUtils.getContext().getPackageManager().getApplicationInfo(name,
                    PackageManager.GET_META_DATA);
            msg = appInfo.metaData.getString(metaKey);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(msg)) {
            return "";
        }

        return msg;
    }

    /**
     * 获得渠道号
     *
     * @param channelKey
     * @return
     */
    public static String getChannelNo(String channelKey) {
        return getMetaData(channelKey);
    }

    /**
     * 获得apk版本号
     *
     * @return 当前版本名字
     */
    public static String getVersionName() {
        String version = "";
        // 获取packagemanager的实例
        PackageManager packageManager = ResourceUtils.getContext().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(ResourceUtils.getContext().getPackageName(),
                    0);
            version = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(version)) {
            version = "";
        }

        return version;
    }

    /**
     * 获得apk版本号
     *
     * @return 当前版本号
     */
    public static int getVersionCode() {
        int versionCode = 0;
        // 获取packagemanager的实例
        PackageManager packageManager = ResourceUtils.getContext().getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(ResourceUtils.getContext().getPackageName(),
                    0);
            versionCode = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionCode;
    }
}
