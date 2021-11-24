package com.example.gena.chessjokenpocom.mvp.presenters

import android.text.TextUtils
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.mvp.views.MainView

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    fun showSplashScreen() {
        viewState.showSplashScreen()
    }

    fun showHome() {
        viewState.showHome()
    }

    fun showLogin() {
        viewState.showLogin()
    }

    fun auth() {
        if (!TextUtils.isEmpty(AppConstants.LOGIN) && TextUtils.isEmpty(AppConstants.PASSWORD)) {
            viewState.showLogin()
        } else if (!TextUtils.isEmpty(AppConstants.LOGIN) && !TextUtils.isEmpty(AppConstants.PASSWORD)) {
            viewState.getUser()
        } else {
            viewState.showLogin()
        }
    }
}