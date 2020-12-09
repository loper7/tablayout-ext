package com.loper7.tablayout_ext.fragment

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.loper7.tab_expand.ext.buildIndicator
import com.loper7.tab_expand.ext.buildText
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.BaseIndicator
import com.loper7.tab_expand.indicator.CustomIndicator
import com.loper7.tab_expand.indicator.TriangleIndicator
import com.loper7.tab_expand.text.BaseText
import com.loper7.tablayout_ext.R
import com.loper7.tablayout_ext.adapter.CustomFragmentAdapter
import com.loper7.tablayout_ext.adapter.SimpleFragmentAdapter
import kotlinx.android.synthetic.main.fragment_other_indicator.*
import kotlinx.android.synthetic.main.fragment_other_indicator.tabLayout
import kotlinx.android.synthetic.main.fragment_other_indicator.tabLayout1
import kotlinx.android.synthetic.main.fragment_other_indicator.tabLayout2
import kotlinx.android.synthetic.main.fragment_other_indicator.tabLayout3
import kotlinx.android.synthetic.main.fragment_other_indicator.viewPager

/**
 *
 * @CreateDate:     2020/7/28 11:34
 * @Description:    OtherIndicatorFragment
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class CustomIndicatorFragment :Fragment() {
    var mRootView: View? = null
    private lateinit var adapter: CustomFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = View.inflate(context, R.layout.fragment_other_indicator, null)
        }
        return mRootView
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CustomFragmentAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout1.setupWithViewPager(viewPager)
        tabLayout2.setupWithViewPager(viewPager)
        tabLayout3.setupWithViewPager(viewPager)
        tabLayout4.setupWithViewPager(viewPager)


        // custom1
        tabLayout.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_fire)!!)
            .setWidth(15.toPx())
            .setHeight(15.toPx())
            .bind()
        tabLayout.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        // custom2
        tabLayout1.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_t)!!)
            .setWidth(BaseIndicator.MATCH)
            .setHeight(BaseIndicator.MATCH)
            .bind()
        tabLayout1.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        // custom3
        tabLayout2.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_finger)!!)
            .setWidth(15.toPx())
            .setHeight(15.toPx())
            .bind()
        tabLayout2.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        // custom4
        tabLayout3.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_index)!!)
            .setHeight(8.toPx())
            .setWidth(50.toPx())
            .bind()
        tabLayout3.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()
        //custom5
        tabLayout4.buildIndicator<CustomIndicator>()
            .setDrawable(ColorDrawable(ContextCompat.getColor(context!!,R.color.colorAccent)))
            .setHeight(BaseIndicator.MATCH)
            .setWidth(BaseIndicator.MATCH)
            .bind()
        tabLayout4.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .bind()

    }
}