package com.example.gena.chessjokenpocom.mvp.presenters.login

import android.text.TextUtils
import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.mvp.views.login.SignInFragmentView

@InjectViewState
class SingInFragmentPresenter : MvpPresenter<SignInFragmentView>() {

    fun onClick(view: View) {
        when (view.id) {
            R.id.bt_sign_in -> viewState.onClickSingIn(view.id)
            else -> {
            }
        }
    }

    fun isValidation(number: String, password: String) {
        var intNumber: Int? = null
        var intPassword: Int? = null

        viewState.showError(intNumber, intPassword)

        if (TextUtils.isEmpty(number)) {
            intNumber = R.string.error_field_required
        }
        if (TextUtils.isEmpty(password)) {
            intPassword = R.string.error_field_required
        }

        if (intNumber != null || intPassword != null) {
            viewState.showError(intNumber, intPassword)
        } else {
            viewState.successfullyValidation()
        }
    }
}