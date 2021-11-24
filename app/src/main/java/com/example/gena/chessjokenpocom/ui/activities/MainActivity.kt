package com.example.gena.chessjokenpocom.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.helpers.AuthorizationHelper
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.mvp.presenters.MainPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignInPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.TokenPresenter
import com.example.gena.chessjokenpocom.mvp.views.MainView
import com.example.gena.chessjokenpocom.mvp.views.login.SignInView
import com.example.gena.chessjokenpocom.mvp.views.other.TokenView

@SuppressLint("Registered")
class MainActivity : BaseActivityView(), MainView, TokenView, SignInView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @InjectPresenter
    lateinit var signInPresenter: SignInPresenter

    @InjectPresenter
    lateinit var tokenPresenter: TokenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_without_menu)
        AuthorizationHelper.getAuthorized(this)
        mainPresenter.auth()
    }

    override fun showHome() {
        WindowHelper.showActivity(DashboardActivity::class.java, this)
    }

    override fun showError(message: String) {
        super.showError(message)
    }

    override fun showSplashScreen() {

    }

    override fun showLogin() {
        WindowHelper.showActivity(LoginActivity::class.java, this)
    }

    override fun getUser() {
        signInPresenter.getUser("123123", "123121")
    }

    override fun SignInSuccessfully(username: String, IdUer: Int) {
        AppConstants.LOGIN = username
        AppConstants.ID_LOGIN = IdUer
        AuthorizationHelper.setAuthorized(this)
        tokenPresenter.getToken()

    }

    override fun successfulGetToken() {
        mainPresenter.showHome()
    }
}
