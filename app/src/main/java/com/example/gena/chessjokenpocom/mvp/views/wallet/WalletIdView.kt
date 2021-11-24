package com.example.gena.chessjokenpocom.mvp.views.wallet

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.views.BaseView

@StateStrategyType(OneExecutionStateStrategy::class)
interface WalletIdView : BaseView {
    fun getWalletId()

    fun getWalletIdSuccessfully(walletId: Long)
}