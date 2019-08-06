package com.meitu.sww.commonlistdialog.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/**
 * 上下文检查工具类
 * @author ShaoWenWen
 * @date 2019/4/29
 */
public class ContextUtils {

    /**
     * 检查当前上下文是否为可用的Activity
     */
    public static boolean isActivityValid(Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) return false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                return !activity.isDestroyed();
        }
        return true;
    }
}
