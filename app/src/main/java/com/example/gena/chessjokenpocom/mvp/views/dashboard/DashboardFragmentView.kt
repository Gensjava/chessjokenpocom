package com.example.gena.chessjokenpocom.mvp.views.dashboard

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface DashboardFragmentView: BaseView {
    fun createQuickPlay()

    fun createMatch()

    fun showLobby()

    fun showInventory()

    fun showOptions()


}