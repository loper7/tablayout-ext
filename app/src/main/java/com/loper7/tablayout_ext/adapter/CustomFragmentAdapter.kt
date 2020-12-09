package com.loper7.tablayout_ext.adapter

import androidx.fragment.app.*
import com.loper7.tablayout_ext.SimpleFragment

/**
 *
 * @CreateDate:     2020/6/12 11:15
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class CustomFragmentAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        return SimpleFragment.newInstance("PAGE $position")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "直播"
            1-> "推荐"
            2-> "热门"
            3-> "追番"
            4-> "抗击肺炎"
            5-> "总之就是非常可爱"
            else-> "PHP"
        }
    }

}