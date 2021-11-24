package com.example.gena.chessjokenpocom.ui.fragments.login


import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentTabHost
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.databinding.FragmentSignMainBinding
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView


class SignMain : BaseFragmentView() {
    private var fragmentSignMainBinding: FragmentSignMainBinding? = null
    private var onSignFragmentListener: OnSignFragmentListener? = null
    private var mTabHost: FragmentTabHost? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignMainBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                R.layout.fragment_sign_main,
                container,
                false
            ) as FragmentSignMainBinding?
        initViews()
        return fragmentSignMainBinding!!.root
    }

    override fun initViews() {
        mTabHost = fragmentSignMainBinding!!.tabhost
        mTabHost!!.setup(activity, activity!!.supportFragmentManager, R.id.realtabcontent)

        mTabHost!!.addTab(
            mTabHost!!.newTabSpec("tab1").setIndicator("Sign-in"),
            SignInFragment::class.java, null
        )
        mTabHost!!.addTab(
            mTabHost!!.newTabSpec("tab2").setIndicator("Sign-up"),
            SignUpFragment::class.java, null
        )
    }

    interface OnSignFragmentListener {
        fun showSignIn(pageMap: Int)
        fun showSignUp(pageMap: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            onSignFragmentListener = context as OnSignFragmentListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }

    }
}