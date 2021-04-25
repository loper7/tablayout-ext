package com.loper7.tab_expand.indicator

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.*
import android.os.Build
import android.view.Gravity
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.R
import com.loper7.tab_expand.ext.toPx


/**
 *
 * @CreateDate:     2020/8/4 17:36
 * @Description:    CustomIndicator 自定义
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
open class CustomIndicator : BaseIndicator() {

    protected var drawable: Drawable? = null

    fun setDrawable(drawable: Drawable): CustomIndicator {
        this.drawable = drawable
        return this
    }

    fun setDrawable(@DrawableRes resId:Int):CustomIndicator{
        this.drawable = ContextCompat.getDrawable(context!!,resId)
        return this
    }

    override fun bind() {
        tabLayout?.post {

            if(height==MATCH)
                height = tabLayout?.height!!

            val layerDrawable = LayerDrawable(arrayOf(drawable))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                layerDrawable.setLayerHeight(0, height)
                layerDrawable.setLayerWidth(0, width)
                layerDrawable.setLayerGravity(0, Gravity.CENTER)
            }

            if (width == 0 && height == 0)
                tabLayout?.setSelectedTabIndicator(drawable)
            else
                tabLayout?.setSelectedTabIndicator(layerDrawable)


            if (height == 0)
                tabLayout?.setSelectedTabIndicatorHeight(3.toPx())
            else
                tabLayout?.setSelectedTabIndicatorHeight(height)

            //对自适应宽度进行处理
            if (width <= 0 && tabLayout?.tabSelectedIndicator is LayerDrawable) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    (tabLayout?.tabSelectedIndicator as LayerDrawable).setLayerWidth(
                        0,
                        tabLayout?.getTabAt(0)!!.view.width
                    )
                }
                tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabReselected(tab: TabLayout.Tab?) {
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {
                    }

                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        tab?.apply {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                (tabLayout?.tabSelectedIndicator as LayerDrawable).setLayerWidth(
                                    0,
                                    tab.view.width
                                )
                            }
                        }
                    }

                })
            }
        }
    }
}