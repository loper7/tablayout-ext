package com.loper7.tablayout_ext.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.ext.buildIndicator
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.TriangleIndicator
import com.loper7.tablayout_ext.R
import com.loper7.tablayout_ext.adapter.SimpleFragmentAdapter
import kotlinx.android.synthetic.main.fragment_triangle_indicator.*

/**
 *
 * @CreateDate:     2020/7/28 11:34
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class TriangleIndicatorFragment :Fragment() {
    var mRootView: View? = null
    private lateinit var adapter: SimpleFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = View.inflate(context, R.layout.fragment_triangle_indicator, null)
        }
        return mRootView
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SimpleFragmentAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout1.setupWithViewPager(viewPager)
        tabLayout2.setupWithViewPager(viewPager)


        // TriangleIndicator
        tabLayout.buildIndicator<TriangleIndicator>().bind()
        // TriangleIndicator(p=NEGATIVE)
        tabLayout1.buildIndicator<TriangleIndicator>()
            .setPath(TriangleIndicator.Path.NEGATIVE)
            .bind()
        // TriangleIndicator(w=10,h=10,p=NEGATIVE,g=top)
        tabLayout2.buildIndicator<TriangleIndicator>()
            .setPath(TriangleIndicator.Path.NEGATIVE)
            .setWidth(10.toPx())
            .setHeight(10.toPx())
            .setColor(ContextCompat.getColor(context!!,R.color.colorAccent))
            .setGravity(TabLayout.INDICATOR_GRAVITY_TOP)
            .bind()

    }
}