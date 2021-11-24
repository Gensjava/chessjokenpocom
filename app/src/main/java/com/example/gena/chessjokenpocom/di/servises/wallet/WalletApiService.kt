package com.example.gena.chessjokenpocom.di.servises.wallet

import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RetrofitClient
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.wallet.WalletMovements
import com.example.gena.chessjokenpocom.network.WalletApi
import io.reactivex.Observable

class WalletApiService {
    private val walletApi: WalletApi

    init {
        App.appComponent.inject(this)
        walletApi = RetrofitClient.retrofit.create(WalletApi::class.java)
    }

    fun getIdWallet(): Observable<BaseResponse<Long>> {
        return walletApi.getIdWallet()
    }

    fun setWalletMoveSumAnotherGamer(walletMovements: WalletMovements): Observable<BaseResponse<Boolean>> {
        return walletApi.setWalletMoveSumAnotherGamer(walletMovements)
    }
}