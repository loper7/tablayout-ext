package com.loper7.tab_expand.ext

import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.indicator.BaseIndicator

/**
 * 绑定tabLayout指示器
 */
inline fun <reified T : BaseIndicator> TabLayout.buildIndicator():T {
    val indicator = T::class.java.newInstance()
    indicator.bindTabLayout(this)
    return indicator
}