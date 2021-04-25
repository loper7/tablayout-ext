package com.loper7.tab_expand.indicator

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import android.view.Gravity
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.ext.toPx

/**
 *
 * @CreateDate:     2020/8/4 17:36
 * @Description:    LinearIndicator 线性
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
open class LinearIndicator : BaseIndicator() {

    protected var angle: Int = 0


    fun setAngle(angle: Int): LinearIndicator {
        this.angle = angle
        return this
    }

    override fun bind() {
        tabLayout?.post {
            val drawable = ShapeDrawable()
            if (height == MATCH)
                height = tabLayout?.height!!
            if (angle <= 0f)
                angle = if (height == 0) 100 else height / 2
            var f_angle = angle.toFloat()
            val outerR =
                floatArrayOf(f_angle, f_angle, f_angle, f_angle, f_angle, f_angle, f_angle, f_angle)
            val shape = RoundRectShape(outerR, null, null)
            drawable.shape = shape
            drawable.paint.style = Paint.Style.FILL

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