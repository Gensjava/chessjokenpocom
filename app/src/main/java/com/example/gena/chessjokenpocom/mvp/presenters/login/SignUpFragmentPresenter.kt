package com.example.gena.chessjokenpocom.mvp.presenters.login

import android.text.TextUtils
import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.mvp.views.login.SignUpFragmentView

@InjectViewState
class SignUpFragmentPresenter : MvpPresenter<SignUpFragmentView>() {

    fun onClick(view: View) {
        when (view.id) {
            R.id.bt_sign_up -> viewState.onClickSingUp()
            else -> {
            }
        }
    }

    fun isValidation(
        etFirstName: String,
        etSecondName: String,
        etEmail: String,
        etPassword: String,
        etRePassword: String
    ) {
        var intFirstName: Int? = null
        var intSecondName: Int? = null
        var intEmail: Int? = null
        var intPassword: Int? = null
        var intRePassword: Int? = null

        viewState.showError(intFirstName, intSecondName, intEmail, intPassword, intRePassword)

        if (TextUtils.isEmpty(etFirstName)) {
            intFirstName = R.string.error_field_required
        }
        if (TextUtils.isEmpty(etSecondName)) {
            intSecondName = R.string.error_field_required
        }
        if (TextUtils.isEmpty(etEmail)) {
            intEmail = R.string.error_field_required
        }

        if (TextUtils.isEmpty(etPassword)) {
            intPassword = R.string.error_field_required
        }

        if (TextUtils.isEmpty(etRePassword)) {
            intRePassword = R.string.error_field_required
        }

        if (!etPassword.equals(etRePassword)) {
            intRePassword = R.string.error_field_has_an_error
            intPassword = R.string.error_field_has_an_error
        }

        if (intFirstName != null || intSecondName != null || intEmail != null || intPassword != null || intRePassword != null) {
            viewState.showError(
                intFirstName,
                intSecondName,
                intEmail,
                intPassword,
                intRePassword
            )
        } else {
            viewState.successfullyValidation()
        }
    }
}

