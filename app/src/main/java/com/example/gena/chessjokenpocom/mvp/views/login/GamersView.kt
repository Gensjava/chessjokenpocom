package com.example.gena.chessjokenpocom.mvp.views.login

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface GamersView : BaseView {
    fun showListOfGamers()

    fun showGameFieldFragment()
}