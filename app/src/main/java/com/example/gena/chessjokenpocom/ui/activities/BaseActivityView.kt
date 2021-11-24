package com.example.gena.chessjokenpocom.ui.activities

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.databinding.ActivityMainBinding
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.mvp.presenters.other.GsonErrorPresenter
import com.example.gena.chessjokenpocom.mvp.views.BaseView
import com.example.gena.chessjokenpocom.mvp.views.other.GsonErrorView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView
import com.example.gena.chessjokenpocom.ui.fragments.dialogs.SorryDialogOkFragment

@SuppressLint("Registered")
open class BaseActivityView : BaseActivity(), BaseView, GsonErrorView,
    BaseFragmentView.BaseViewFragmentListener,
    SorryDialogOkFragment.OnSorryDialogOkFragmentListener {

    private var tag: String? = null
    @InjectPresenter
    lateinit var gsonErrorPresenter: GsonErrorPresenter

    protected var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        tag = this.localClassName
    }

    override fun initViews() {

    }

    override fun showError(exception: Throwable) {
        gsonErrorPresenter.httpException(exception)
    }

    override fun showError(error: String) {
        WindowHelper.showDialogFragment(
            SorryDialogOkFragment::class.java, error + " "+tag, this
        )
    }

    override fun showError(message: String, codeError: Int) {
        WindowHelper.showDialogFragment(SorryDialogOkFragment::class.java, message, codeError, this)
    }

    override fun hideProgress() {

    }

    override fun showProgress() {

    }

    override fun showRequestSuccessfully(message: String) {
        // WindowHelper.showDialogFragment(SorryDialogOkFragment::class.java, BundleHelper.grtRequestSuccessfully(message, R.string.success), this)
    }

    override fun onClickSorryPositive(bundle: Bundle?) {

    }
}