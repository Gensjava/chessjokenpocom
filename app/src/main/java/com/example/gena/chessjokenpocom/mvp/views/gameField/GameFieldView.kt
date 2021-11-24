package com.example.gena.chessjokenpocom.mvp.views.gameField

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface GameFieldView : BaseView {
    fun showGameField(idMatch: Long)

}