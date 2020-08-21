package com.loper7.tablayout_ext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_simple.*

/**
 *
 * @CreateDate:     2020/7/28 11:34
 * @Description:    java类作用描述
 * @Author:         LOPER7
 * @Email:          loper7@163.com
 */
class SimpleFragment :Fragment() {
    var mRootView: View? = null

    companion object {
        fun newInstance(text: String): SimpleFragment {
            val args = Bundle()
            args.putString("text", text)
            val fragment = SimpleFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = View.inflate(context, R.layout.fragment_simple, null)
        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_text.text = requireArguments().getString("text")
    }
}