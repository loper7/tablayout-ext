package com.loper7.tab_expand.indicator

import android.R
import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.Px
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.ext.toPx


/**
 *
 * @CreateDate:     2020/8/5 9:50
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
abstract class BaseIndicator {
    companion object{
        //填充满
         val MATCH = -1
    }

    protected var width: Int = 0
    protected var height: Int = 0
    protected var context: Context? = null
    protected var tabLayout: TabLayout? = null

    fun bindTabLayout(tabLayout: TabLayout) {
        this.tabLayout = tabLayout
        this.context = tabLayout.context



    }

    fun setColor(@ColorInt color: Int): BaseIndicator {
        tabLayout?.setSelectedTabIndicatorColor(color)
        return this
    }

    fun setWidth(@Px width: Int): BaseIndicator {
        this.width = width
        return this
    }

    fun setHeight(@Px height: Int): BaseIndicator {
        this.height = height
        return this
    }

    /**
     * Indicator gravity used to align the tab selection indicator to the bottom of the {@link
     * TabLayout}. This will only take effect if the indicator height is set via the custom indicator
     * drawable's intrinsic height (preferred), via the {@code tabIndicatorHeight} attribute
     * (deprecated), or via {@link #setSelectedTabIndicatorHeight(int)} (deprecated). Otherwise, the
     * indicator will not be shown. This is the default value.
     *
     * @see #setSelectedTabIndicatorGravity(int)
     * @see #getTabIndicatorGravity()
     * @attr ref com.google.android.material.R.styleable#TabLayout_tabIndicatorGravity
     */
    fun setGravity(gravity: Int): BaseIndicator {
        tabLayout?.setSelectedTabIndicatorGravity(gravity)
        return this
    }

    abstract fun bind()
}