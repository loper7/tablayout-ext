package com.loper7.tablayout_ext.fragment

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.loper7.tab_expand.ext.buildIndicator
import com.loper7.tab_expand.ext.buildText
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.BaseIndicator
import com.loper7.tablayout_ext.adapter.SimpleFragmentAdapter
import com.loper7.tab_expand.indicator.LinearIndicator
import com.loper7.tab_expand.text.BaseText
import com.loper7.tablayout_ext.R
import com.loper7.tablayout_ext.adapter.CustomFragmentAdapter
import kotlinx.android.synthetic.main.fragment_linear_indicator.*
import kotlinx.android.synthetic.main.fragment_linear_indicator.tabLayout
import kotlinx.android.synthetic.main.fragment_linear_indicator.tabLayout1
import kotlinx.android.synthetic.main.fragment_linear_indicator.tabLayout2
import kotlinx.android.synthetic.main.fragment_linear_indicator.tabLayout3
import kotlinx.android.synthetic.main.fragment_linear_indicator.viewPager

/**
 *
 * @CreateDate:     2020/7/28 11:34
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class LinearIndicatorFragment :Fragment() {
    var mRootView: View? = null
    private lateinit var adapter: SimpleFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = View.inflate(context,
                R.layout.fragment_linear_indicator, null)
        }
        return mRootView
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SimpleFragmentAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout_default.setupWithViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
        tabLayout1.setupWithViewPager(viewPager)
        tabLayout2.setupWithViewPager(viewPager)
        tabLayout3.setupWithViewPager(viewPager)
        tabLayout4.setupWithViewPager(viewPager)


        // LinearIndicator
        tabLayout.buildIndicator<LinearIndicator>().bind()
        tabLayout.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .setNormalTextSize(16f)
            .setSelectTextSize(18f)
            .bind()
        // LinearIndicator (w=35,h=3.5)
        tabLayout1.buildIndicator<LinearIndicator>()
            .setWidth(35.toPx())
            .setHeight(3.5.toPx())
            .bind()
        tabLayout1.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        // LinearIndicator (w=5,h=5)
        tabLayout2.buildIndicator<LinearIndicator>()
            .setWidth(5.toPx())
            .setHeight(5.toPx())
            .bind()
        tabLayout2.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        // LinearIndicator (w=auto,h=match,a=4)
        tabLayout3.buildIndicator<LinearIndicator>()
            .setAngle(4.toPx())
            .setHeight(BaseIndicator.MATCH)
            .setWidth(BaseIndicator.MATCH)
            .bind()
        tabLayout3.buildText<BaseText>()
            .setNormalTextBold(true)
            .setSelectTextBold(true)
            .bind()
        // LinearIndicator (w=auto,h=22,a=auto)
        tabLayout4.buildIndicator<LinearIndicator>()
            .setHeight(22.toPx())
            .bind()

        tabLayout4.buildText<BaseText>()
            .setNormalTextBold(true)
            .setSelectTextBold(true)
            .bind()

        tabLayout.getTabAt(1)?.orCreateBadge?.backgroundColor=Color.parseColor("#FF9900")
        tabLayout.getTabAt(1)?.orCreateBadge?.number=6

    }
}