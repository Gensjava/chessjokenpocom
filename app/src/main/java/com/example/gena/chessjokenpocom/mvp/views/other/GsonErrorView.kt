package com.example.gena.chessjokenpocom.mvp.views.other

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface GsonErrorView : MvpView {

    fun showError(error: String)

    fun showError(message: String, codeError: Int)

}