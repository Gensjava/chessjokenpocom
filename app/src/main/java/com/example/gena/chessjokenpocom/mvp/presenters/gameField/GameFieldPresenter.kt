package com.example.gena.chessjokenpocom.mvp.presenters.gameField

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.gameField.GameFieldView

@InjectViewState
class GameFieldPresenter : MvpPresenter<GameFieldView>() {

    fun showGameField(idMatch: Long) {
        viewState.showGameField(idMatch)
    }

}