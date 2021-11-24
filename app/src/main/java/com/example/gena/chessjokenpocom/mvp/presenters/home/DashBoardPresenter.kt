package com.example.gena.chessjokenpocom.mvp.presenters.home

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.home.DashBoardView

@InjectViewState
class DashBoardPresenter : MvpPresenter<DashBoardView>() {

    fun showSignUp() {
        viewState.showDashBoard()
    }

}