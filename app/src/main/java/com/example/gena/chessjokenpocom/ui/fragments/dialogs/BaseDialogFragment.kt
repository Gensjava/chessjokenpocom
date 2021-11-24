package com.example.gena.chessjokenpocom.ui.fragments.dialogs

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.mvp.views.BaseView
import com.example.gena.chessjokenpocom.ui.activities.BaseActivity

open class BaseDialogFragment : MvpAppCompatDialogFragment(), DialogInterface.OnClickListener,
    BaseView {
    var builder: AlertDialog.Builder? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        builder = AlertDialog.Builder(activity!!, R.style.CustomDialogTheme)
        builder!!.setCancelable(false)
        initViews()
    }

    override fun onClick(dialogInterface: DialogInterface, i: Int) {

    }

    fun initViews() {

    }

    override fun showError(exception: Throwable) {

    }

    override fun showError(message: String, codeError: Int) {

    }

    override fun hideProgress() {

    }

    override fun showProgress() {

    }

    override fun showRequestSuccessfully(message: String) {

    }
}


