package com.example.gena.chessjokenpocom.mvp.views.login

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface LoginView : BaseView {
    fun showSignUp()

    fun showSignIn()

    fun showHome()

}