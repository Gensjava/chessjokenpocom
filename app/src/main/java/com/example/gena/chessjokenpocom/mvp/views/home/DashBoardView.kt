package com.example.gena.chessjokenpocom.mvp.views.home

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface DashBoardView : BaseView {

    fun showDashBoard()

}