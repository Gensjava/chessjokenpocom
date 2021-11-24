package com.example.gena.chessjokenpocom.mvp.presenters.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    fun showSignUp() {
        viewState.showSignUp()
    }

    fun showSignIn() {
        viewState.showSignIn()
    }

    fun showRequestSuccessfully(message: String) {
        viewState.showRequestSuccessfully(message)
    }
}