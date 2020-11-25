package com.loper7.tab_expand.ext

import android.content.Context
import android.content.res.Resources

/**
 *
 * @CreateDate:     2020/8/18 11:15
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
fun Double.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Double.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
