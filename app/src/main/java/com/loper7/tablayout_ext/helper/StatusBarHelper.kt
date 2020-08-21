package com.loper7.tablayout_ext.helper

import android.app.Activity
import android.os.Build
import android.view.View

/**
 * @CreateDate: 2020/7/28 10:32
 * @Description: 状态栏帮助类
 * @Author: LOPER7
 * @Email: loper7@163.com
 */
object StatusBarHelper {
    /**
     * 是否使用深色状态栏
     *
     * @param bDark
     */
    fun setDarkStatusIcon(activity: Activity, bDark: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = activity.window.decorView
            if (decorView != null) {
                var vis = decorView.systemUiVisibility
                vis = if (bDark) {
                    vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
                decorView.systemUiVisibility = vis
            }
        }
    }
}