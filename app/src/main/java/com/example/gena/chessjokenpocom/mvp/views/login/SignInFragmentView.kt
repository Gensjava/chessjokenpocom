package com.example.gena.chessjokenpocom.mvp.views.login

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignInFragmentView : BaseView {

    fun onClickSingIn(id: Int)

    fun successfullyValidation()

    fun showError(number: Int?, password: Int?)

    fun showSingUp()

    fun showForgotPassword()

    fun showSocialNetwork(id: Int)

}