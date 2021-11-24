package com.example.gena.chessjokenpocom.di.components

import com.example.gena.chessjokenpocom.di.servises.GamersApiService
import com.example.gena.chessjokenpocom.di.servises.LoginApiService
import com.example.gena.chessjokenpocom.di.servises.MainApiService
import com.example.gena.chessjokenpocom.di.servises.wallet.WalletApiService

interface ApiComponent {

    fun inject(WalletApiService: WalletApiService)

    fun inject(mainApiService: MainApiService)

    fun inject(gamersApiService: GamersApiService)

    fun inject(baseApiService: LoginApiService)


}