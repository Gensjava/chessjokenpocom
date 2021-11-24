package com.example.gena.chessjokenpocom.di.components

import com.example.gena.chessjokenpocom.customs.TokenAuthenticator
import com.example.gena.chessjokenpocom.mvp.presenters.dashboard.CreateMatchPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.gameField.GameFieldFragmentPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.gamers.ListOfGamersPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignInPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignUpPresenter

interface PresenterComponent {
    fun inject(GameFieldFragmentPresenter: GameFieldFragmentPresenter?)

    fun inject(ListOfGamersPresenter: ListOfGamersPresenter?)

    fun inject(signInPresenter: SignInPresenter)

    fun inject(SignUpPresenter: SignUpPresenter)

    fun inject(tokenAuthenticator: TokenAuthenticator?)

    fun inject(createMatchPresenter: CreateMatchPresenter?)


}