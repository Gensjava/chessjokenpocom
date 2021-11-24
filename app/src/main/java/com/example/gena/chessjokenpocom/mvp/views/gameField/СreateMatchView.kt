package com.example.gena.chessjokenpocom.mvp.views.gameField

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface СreateMatchView : BaseView {

    fun createMatch()

    fun createMatchSuccessfully(matches: Matches)
}