package com.loper7.tablayout_ext.adapter

import androidx.fragment.app.*
import com.loper7.tablayout_ext.fragment.LinearIndicatorFragment
import com.loper7.tablayout_ext.fragment.CustomIndicatorFragment
import com.loper7.tablayout_ext.fragment.TriangleIndicatorFragment

/**
 *
 * @CreateDate:     2020/6/12 11:15
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class MainFragmentAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0->LinearIndicatorFragment()
            1-> TriangleIndicatorFragment()
            else->CustomIndicatorFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "LINEAR"
            1-> "TRIANGLE"
            2-> "CUSTOM"
            else->""
        }
    }

}