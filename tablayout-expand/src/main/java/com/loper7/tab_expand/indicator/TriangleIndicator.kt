package com.loper7.tab_expand.indicator

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.*
import android.os.Build
import android.view.Gravity
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.loper7.tab_expand.R
import com.loper7.tab_expand.ext.toDp
import com.loper7.tab_expand.ext.toPx


/**
 *
 * @CreateDate:     2020/8/4 17:36
 * @Description:    TriangleIndicator 三角
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
open class TriangleIndicator : BaseIndicator() {

    protected var path = Path.POSITIVE
    private var drawable: Drawable? = null

    fun setPath(path: Path): TriangleIndicator {
        this.path = path
        return this
    }


    override fun bind() {
        tabLayout?.post {
            if(height==MATCH)
                height = tabLayout?.height!!

            if (drawable == null) {
                drawable = if (path == Path.POSITIVE) {
                    ContextCompat.getDrawable(context!!, R.drawable.tab_indicator_triangle_z)!!
                } else {
                    ContextCompat.getDrawable(context!!, R.drawable.tab_indicator_triangle_f)!!
                }
            }

            if (width == 0)
                width = 12.toPx()
            if (height == 0)
                height = 12.toPx()

            if (height == 0)
                tabLayout?.setSelectedTabIndicatorHeight(3.toPx())
            else
                tabLayout?.setSelectedTabIndicatorHeight(height)

            val layerDrawable = LayerDrawable(arrayOf(drawable))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                layerDrawable.setLayerHeight(0, height)
                layerDrawable.setLayerWidth(0, width)
                layerDrawable.setLayerGravity(0, Gravity.CENTER)
            }


            tabLayout?.setSelectedTabIndicator(layerDrawable)
        }

    }


    enum class Path {
        /**
         * POSITIVE 正
         * NEGATIVE 反
         */
        POSITIVE,
        NEGATIVE
    }
}