package com.sww.commontipdialog;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author ShaoWenWen
 * @date 2019-08-06
 */
public class DeviceUtils {

    /**
     * 密度转换像素
     * @param dipValue dp值
     * @return 像素
     */
    public static int dip2px(Context context,float dipValue) {
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return (int) (dipValue * dm.density + 0.5f);
    }

}
