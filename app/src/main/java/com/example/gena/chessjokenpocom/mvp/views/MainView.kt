package com.example.gena.chessjokenpocom.mvp.views

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainView : BaseView {
    fun showHome()

    fun showError(message: String)

    fun showSplashScreen()

    fun showLogin()

    fun getUser()
}