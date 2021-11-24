package com.example.gena.chessjokenpocom.mvp.views.wallet

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.models.wallet.WalletMovements
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface WalletMoveSumAnotherGamerView : BaseView {

    fun setWalletMoveSumAnotherGamer()

    fun setWalletMoveSumAnotherGamerSuccessfully(boolean: Boolean)
}