package com.example.gena.chessjokenpocom.mvp.views.gameField

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.models.games.StepsGame
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface GameFieldFragmentView : BaseView {
    fun sendNextStep(stepsGame: StepsGame?)

    fun getNextStep(stepsGame: StepsGame?)

    fun switchColor(color: Int)
}