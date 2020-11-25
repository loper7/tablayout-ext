package com.loper7.tab_expand.text

import android.R
import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Px
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

    fun bind() {
        tabLayout?.apply {
            for (i in 0 until tabLayout!!.tabCount) {
                var tab = tabLayout!!.getTabAt(i)
                if (tab != null) {
                    val title =
                        ((tabLayout?.getChildAt(0) as LinearLayout).getChildAt(tab.position) as LinearLayout).getChildAt(
                            1
                        ) as TextView
                    if (tab.isSelected)
                        title.paint.isFakeBoldText = selectTextBold
                    else
                        title.paint.isFakeBoldText = normalTextBold
                }
            }

            tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val title =
                        ((tabLayout?.getChildAt(0) as LinearLayout).getChildAt(tab!!.position) as LinearLayout).getChildAt(
                            1
                        ) as TextView
                    title.paint.isFakeBoldText = normalTextBold
                }

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val title =
                        ((tabLayout?.getChildAt(0) as LinearLayout).getChildAt(tab!!.position) as LinearLayout).getChildAt(
                            1
                        ) as TextView
                    title.paint.isFakeBoldText = selectTextBold
                }

            })
        }
    }
}