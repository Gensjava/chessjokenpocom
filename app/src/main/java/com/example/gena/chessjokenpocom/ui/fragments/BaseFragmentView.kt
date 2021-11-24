package com.example.gena.chessjokenpocom.ui.fragments

import android.content.Context
import android.text.Editable
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.GsonErrorPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.TextWatcherPresenter
import com.example.gena.chessjokenpocom.mvp.views.BaseView
import com.example.gena.chessjokenpocom.mvp.views.other.GsonErrorView
import com.example.gena.chessjokenpocom.mvp.views.other.TextWatcherView

open class BaseFragmentView : BaseFragment(), BaseView, GsonErrorView, TextWatcherView {
    @InjectPresenter
    lateinit var gsonErrorPresenter: GsonErrorPresenter

    @InjectPresenter
    lateinit var textWatcherPresenter: TextWatcherPresenter

    lateinit var baseViewFragmentListener: BaseViewFragmentListener


    override fun initViews() {

    }

    override fun showError(exception: Throwable) {
        gsonErrorPresenter.httpException(exception)
    }

    override fun showError(message: String, codeError: Int) {
        baseViewFragmentListener.showError(message)
    }

    override fun showProgress() {
        //     baseViewFragmentListener!!.showProgress()
    }

    override fun showRequestSuccessfully(message: String) {
        //  baseViewFragmentListener!!.showRequestSuccessfully(message)
    }

    override fun hideProgress() {
        //  baseViewFragmentListener!!.hideProgress()
    }

    override fun showError(error: String) {
        baseViewFragmentListener.showError(error)
    }

    override fun afterTextChanged(id: Int, editable: Editable) {

    }

    interface BaseViewFragmentListener {
        fun showProgress()

        fun hideProgress()

        fun showError(error: String)

        fun showRequestSuccessfully(message: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            baseViewFragmentListener = (context as BaseFragmentView.BaseViewFragmentListener?)!!
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }

    }
}