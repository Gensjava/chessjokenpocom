package com.example.gena.chessjokenpocom.di.components

import com.example.gena.chessjokenpocom.di.servises.gameField.GameFieldGsonService
import com.example.gena.chessjokenpocom.mvp.presenters.dashboard.QuickPlayPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.wallet.WalletIdPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.wallet.WalletMoveSumAnotherGamerPresenter

interface GsonComponent {
    fun inject(GameFieldGsonService: GameFieldGsonService?)

    fun inject(WalletIdPresenter: WalletIdPresenter?)

    fun inject(WalletMoveSumAnotherGamerPresenter: WalletMoveSumAnotherGamerPresenter?)

    fun inject(QuickPlayPresenter: QuickPlayPresenter?)




}