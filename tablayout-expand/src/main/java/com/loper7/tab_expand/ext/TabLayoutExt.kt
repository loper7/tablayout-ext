package com.loper7.tab_expand.ext

import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.indicator.BaseIndicator
import com.loper7.tab_expand.text.BaseText

/**
 * 绑定tabLayout指示器
 */
inline fun <reified T : BaseIndicator> TabLayout.buildIndicator():T {
    val indicator = T::class.java.newInstance()
    indicator.bindTabLayout(this)
    return indicator
}

/**
 * 绑定tabLayout文字设置
 */
inline fun <reified T : BaseText> TabLayout.buildText():T {
    val text = T::class.java.newInstance()
    text.bindTabLayout(this)
    return text
}


