package com.loper7.tablayout_ext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.loper7.tablayout_ext.adapter.MainFragmentAdapter
import com.loper7.tablayout_ext.helper.StatusBarHelper
import com.loper7.tab_expand.ext.buildIndicator
import com.loper7.tab_expand.ext.buildText
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.LinearIndicator
import com.loper7.tab_expand.text.BaseText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:MainFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarHelper.setDarkStatusIcon(this,true)



        adapter = MainFragmentAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 3
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.buildIndicator<LinearIndicator>()
            .bind()

        tabLayout.buildText<BaseText>()
            .setNormalTextBold(true)
            .setSelectTextSize(15f)
            .setSelectTextBold(true).bind()
    }
}
