package com.loper7.tab_expand.text

import android.R
import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import androidx.annotation.Px
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.BaseIndicator


/**
 *
 * @CreateDate:     2020/8/5 9:50
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
open class BaseText {

    protected var context: Context? = null
    protected var tabLayout: TabLayout? = null
    protected var normalTextBold: Boolean = false
    protected var selectTextBold: Boolean = false
    protected var normalTextSize: Float = 14f
    protected var selectTextSize: Float = 14f

    fun bindTabLayout(tabLayout: TabLayout) {
        this.tabLayout = tabLayout
        this.context = tabLayout.context
    }

    fun setNormalTextBold(normalTextBold: Boolean): BaseText {
        this.normalTextBold = normalTextBold
        return this
    }

    fun setSelectTextBold(selectTextBold: Boolean): BaseText {
        this.selectTextBold = selectTextBold
        return this
    }

    fun setNormalTextSize(normalTextSize: Float): BaseText {
        this.normalTextSize = normalTextSize
        return this
    }

    fun setSelectTextSize(selectTextSize: Float): BaseText {
        this.selectTextSize = selectTextSize
        return this
    }

    fun bind() {
        tabLayout?.apply {
            for (i in 0 until tabCount) {
                getTabAt(i)?.let {
                    it.customView = TextView(context).apply {
                        text = it.text
                        textSize = if (isSelected) selectTextSize else normalTextSize
                        if (isSelected)
                            paint?.isFakeBoldText = selectTextBold
                        else
                            paint?.isFakeBoldText = normalTextBold
                        gravity = Gravity.CENTER
                        setTextColor(tabTextColors)
                    }
                }
            }

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                    (tab?.customView as? TextView)?.apply {
                        textSize = selectTextSize

                        paint?.isFakeBoldText = selectTextBold
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    (tab?.customView as? TextView)?.apply {
                        textSize = normalTextSize
                        paint?.isFakeBoldText = normalTextBold
                    }
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    (tab?.customView as? TextView)?.apply {
                        textSize = selectTextSize
                        paint?.isFakeBoldText = selectTextBold
                    }
                }

            })
        }
    }
}