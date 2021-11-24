package com.example.gena.chessjokenpocom.mvp.presenters.gamers

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.GamersView

@InjectViewState
class GamersPresenter : MvpPresenter<GamersView>() {

    fun showListOfGamers() {
        viewState.showListOfGamers()
    }

}