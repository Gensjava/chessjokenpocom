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
import com.example.gena.chessjokenpocom.databinding.FragmentSignInBinding
import com.example.gena.chessjokenpocom.helpers.AuthorizationHelper
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignInPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SingInFragmentPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.TokenPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.SignInFragmentView
import com.example.gena.chessjokenpocom.mvp.views.login.SignInView
import com.example.gena.chessjokenpocom.mvp.views.other.TokenView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView


class SignInFragment : BaseFragmentView(), SignInFragmentView, SignInView, TokenView {
    @InjectPresenter
    lateinit var singInFragmentPresenter: SingInFragmentPresenter

    @InjectPresenter
    lateinit var signInPresenter: SignInPresenter

    @InjectPresenter
    lateinit var tokenPresenter: TokenPresenter

    private var fragmentSignInBinding: FragmentSignInBinding? = null
    private var signInFragmentListener: OnSignInFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSignInBinding =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                R.layout.fragment_sign_in,
                container,
                false
            ) as FragmentSignInBinding?
        textWatcherPresenter.setTextWatcher(fragmentSignInBinding!!.etName)
        textWatcherPresenter.setTextWatcher(fragmentSignInBinding!!.etPassword)
        initViews()
        return fragmentSignInBinding!!.root
    }

    override fun initViews() {
        fragmentSignInBinding!!.presenter = singInFragmentPresenter
    }

    override fun onClickSingIn(id: Int) {
        AppConstants.LOGIN = fragmentSignInBinding!!.etName.text.toString().trim()
        AppConstants.PASSWORD = fragmentSignInBinding!!.etPassword.text.toString().trim()
        singInFragmentPresenter.isValidation(
            AppConstants.LOGIN!!,
            AppConstants.PASSWORD!!
        )
    }

    override fun successfullyValidation() {
        getUser()
    }

    override fun showError(number: Int?, password: Int?) {
        if (number != null) {
            fragmentSignInBinding!!.tilName.error = getString(number)
        }
        if (password != null) {
            fragmentSignInBinding!!.tilPassword.error = getString(password)
        }
    }

    override fun showSingUp() {
        signInFragmentListener!!.showSignUp()
    }

    override fun showForgotPassword() {
        signInFragmentListener!!.showForgotPassword()
    }

    override fun showSocialNetwork(id: Int) {

    }

    override fun afterTextChanged(id: Int, editable: Editable) {
        when (id) {
            R.id.et_name -> if (fragmentSignInBinding!!.tilName.error != null) {
                fragmentSignInBinding!!.tilName.error = null
                fragmentSignInBinding!!.tilName.isErrorEnabled = false
            }
            R.id.et_password -> if (fragmentSignInBinding!!.tilPassword.error != null) {
                fragmentSignInBinding!!.tilPassword.error = null
                fragmentSignInBinding!!.tilPassword.isErrorEnabled = false
            }
            else -> {
            }
        }
    }

    override fun getUser() {
        signInPresenter.getUser("000000000", "3211")
    }

    override fun SignInSuccessfully(username: String, IdUer: Int) {
        AppConstants.LOGIN = username
        AppConstants.ID_LOGIN = IdUer
        AppConstants.PASSWORD = fragmentSignInBinding!!.etPassword.text.toString().trim()
        AuthorizationHelper.setAuthorized(context)
        tokenPresenter.getToken()
    }

    override fun successfulGetToken() {
        signInFragmentListener!!.showHome()
    }

    interface OnSignInFragmentListener {
        fun showHome()

        fun showSignUp()

        fun showForgotPassword()

    }


    override fun onDetach() {
        super.onDetach()
        signInFragmentListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            signInFragmentListener = context as OnSignInFragmentListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }

    }
}