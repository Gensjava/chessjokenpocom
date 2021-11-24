package com.example.gena.chessjokenpocom.network

import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.wallet.WalletMovements
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WalletApi {
    @GET("api/wallet/get-id-wallet")
    fun getIdWallet(): Observable<BaseResponse<Long>>

    @POST("api/wallet/move-sum-another-gamer")
    fun setWalletMoveSumAnotherGamer(@Body WalletMovements: WalletMovements?): Observable<BaseResponse<Boolean>>

}