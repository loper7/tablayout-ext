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
class SimpleFragmentAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 6
    }

    override fun getItem(position: Int): Fragment {
        return SimpleFragment.newInstance("PAGE $position")
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> "JAVA"
            1-> "OBJECT-C"
            2-> "FLUTTER"
            3-> "KOTLIN"
            4-> "SWIFT"
            5-> "REACT NATIVE"
            else-> "PHP"
        }
    }

}