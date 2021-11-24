package com.example.gena.chessjokenpocom.ui.fragments.login

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.databinding.FragmentSignUpBinding
import com.example.gena.chessjokenpocom.helpers.AuthorizationHelper
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignUpFragmentPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignUpPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.TokenPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.SignUpFragmentView
import com.example.gena.chessjokenpocom.mvp.views.login.SignUpView
import com.example.gena.chessjokenpocom.mvp.views.other.TokenView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView

class SignUpFragment : BaseFragmentView(), SignUpFragmentView, SignUpView, TokenView {

    private var fragmentSignUpBinding: FragmentSignUpBinding? = null

    @InjectPresenter
    lateinit var signUpFragmentPresenter: SignUpFragmentPresenter

    @InjectPresenter
    lateinit var tokenPresenter: TokenPresenter

    @InjectPresenter
    lateinit var signUpPresenter: SignUpPresenter
    private var signUpFragmentListener: OnSignUpFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignUpBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false
            ) as FragmentSignUpBinding?
        initViews()
        return fragmentSignUpBinding!!.root
    }

    override fun initViews() {
        fragmentSignUpBinding!!.presenter = signUpFragmentPresenter
        textWatcherPresenter.setTextWatcher(fragmentSignUpBinding!!.etFirstName)
        textWatcherPresenter.setTextWatcher(fragmentSignUpBinding!!.etSecondName)
        textWatcherPresenter.setTextWatcher(fragmentSignUpBinding!!.etEmail)
        textWatcherPresenter.setTextWatcher(fragmentSignUpBinding!!.etPassword)
    }

    override fun onClickSingUp() {
        signUpFragmentPresenter.isValidation(
            fragmentSignUpBinding!!.etFirstName.text.toString().trim(),
            fragmentSignUpBinding!!.etSecondName.text.toString().trim(),
            fragmentSignUpBinding!!.etEmail.text.toString().trim(),
            fragmentSignUpBinding!!.etPassword.text.toString().trim(),
            fragmentSignUpBinding!!.etRePassword.text.toString().trim()
        )
    }

    override fun successfullyValidation() {
        signUpPresenter.setUser()
    }

    override fun showError(
        etFirstName: Int?,
        etSecondName: Int?,
        etEmail: Int?,
        etPassword: Int?,
        etRePassword: Int?
    ) {
        if (etFirstName != null) {
            fragmentSignUpBinding!!.etFirstName.error = getString(etFirstName)
        }
        if (etSecondName != null) {
            fragmentSignUpBinding!!.etSecondName.error = getString(etSecondName)
        }
        if (etEmail != null) {
            fragmentSignUpBinding!!.etEmail.error = getString(etEmail)
        }
        if (etPassword != null) {
            fragmentSignUpBinding!!.tilPassword.error = getString(etPassword)
        }
        if (etRePassword != null) {
            fragmentSignUpBinding!!.tilRePassword.error = getString(etRePassword)
        }
    }

    override fun afterTextChanged(id: Int, editable: Editable) {
        when (id) {
            R.id.et_first_name -> if (fragmentSignUpBinding!!.tilFirstName.error != null) {
                fragmentSignUpBinding!!.tilFirstName.error = null
                fragmentSignUpBinding!!.tilFirstName.isErrorEnabled = false
            }
            R.id.et_second_name -> if (fragmentSignUpBinding!!.tilSecondName.error != null) {
                fragmentSignUpBinding!!.tilSecondName.error = null
                fragmentSignUpBinding!!.tilSecondName.isErrorEnabled = false
            }
            R.id.et_email -> if (fragmentSignUpBinding!!.tilEmail.error != null) {
                fragmentSignUpBinding!!.tilEmail.error = null
                fragmentSignUpBinding!!.tilEmail.isErrorEnabled = false
            }
            R.id.et_password -> if (fragmentSignUpBinding!!.tilPassword.error != null) {
                fragmentSignUpBinding!!.tilPassword.error = null
                fragmentSignUpBinding!!.tilPassword.isErrorEnabled = false
            }
            R.id.et_re_password -> if (fragmentSignUpBinding!!.tilRePassword != null) {
                fragmentSignUpBinding!!.tilRePassword.error = null
                fragmentSignUpBinding!!.tilRePassword.isErrorEnabled = false
            }
            else -> {
            }
        }
    }

    interface OnSignUpFragmentListener {
        fun showHome()

        fun showSignUp()

        fun showForgotPassword()
    }

    override fun setUser() {
        signUpPresenter.setUser(
            fragmentSignUpBinding!!.etFirstName.text.toString().trim(),
            fragmentSignUpBinding!!.etSecondName.text.toString().trim(),
            fragmentSignUpBinding!!.etEmail.text.toString().trim(),
            fragmentSignUpBinding!!.etPassword.text.toString().trim(), "1111", "111"
        )
    }

    override fun signUpSuccessfully(username: String, IdUer: Int) {
        AppConstants.LOGIN = username
        AppConstants.ID_LOGIN = IdUer
        AppConstants.PASSWORD = fragmentSignUpBinding!!.etPassword.getText().toString().trim()
        AuthorizationHelper.setAuthorized(context)
        tokenPresenter.getToken()
    }

    override fun successfulGetToken() {
        signUpFragmentListener!!.showHome()
    }

    override fun onDetach() {
        super.onDetach()
        signUpFragmentListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            signUpFragmentListener = context as OnSignUpFragmentListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }

    }
}