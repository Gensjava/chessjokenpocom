package com.example.gena.chessjokenpocom.mvp.views.login

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface SignUpFragmentView : BaseView {

    fun onClickSingUp()

    fun successfullyValidation()

    fun showError(
        etFirstName: Int?,
        etSecondName: Int?,
        etEmail: Int?,
        etPassword: Int?,
        etRePassword: Int?
    )

}