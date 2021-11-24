package com.example.gena.chessjokenpocom.ui.activities

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.mvp.presenters.login.LoginPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.LoginView
import com.example.gena.chessjokenpocom.ui.fragments.login.SignInFragment
import com.example.gena.chessjokenpocom.ui.fragments.login.SignMain
import com.example.gena.chessjokenpocom.ui.fragments.login.SignUpFragment


@SuppressLint("Registered")
class LoginActivity : BaseActionBarActivity(), LoginView, SignMain.OnSignFragmentListener,
    SignInFragment.OnSignInFragmentListener, SignUpFragment.OnSignUpFragmentListener {

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_without_menu)
        loginPresenter.showSignIn()
        setHomeButton(getString(R.string.login))
    }

    override fun showHome() {
        WindowHelper.showActivity(DashboardActivity::class.java, this)
    }

    override fun showSignUp() {

    }

    override fun showForgotPassword() {

    }

    override fun showSignIn() {
        WindowHelper.showFragment(SignMain::class.java, this)
    }

    override fun showSignIn(pageMap: Int) {
        WindowHelper.showFragment(SignMain::class.java, this, pageMap)
    }

    override fun showSignUp(pageMap: Int) {
        WindowHelper.showFragment(SignMain::class.java, this, pageMap)
    }
}
