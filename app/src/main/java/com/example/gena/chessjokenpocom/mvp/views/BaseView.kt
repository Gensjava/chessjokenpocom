package com.example.gena.chessjokenpocom.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface BaseView : MvpView {

    fun showError(exception: Throwable)

    fun showError(message: String, codeError: Int)

    fun hideProgress()

    fun showProgress()

    fun showRequestSuccessfully(message: String)

}
