package com.example.gena.chessjokenpocom.di.servises

import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RetrofitClient
import com.example.gena.chessjokenpocom.app.constants.ApiUtils
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import com.example.gena.chessjokenpocom.network.MainRequestApi
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response

class MainApiService {
    val mainRequestApi: MainRequestApi

    init {
        App.appComponent.inject(this)
        mainRequestApi = RetrofitClient.retrofit.create(MainRequestApi::class.java)
    }

    fun getToken(): Observable<Response<AuthorizationResponse?>?>? {
        return mainRequestApi.getToken(
            ApiUtils.BASIC_TOKEN,
            ApiUtils.CONTENT_TYPE,
            ApiUtils.GRANT_TYPE,
            AppConstants.LOGIN,
            AppConstants.PASSWORD
        )
    }

    fun getTokenSyn(): Call<AuthorizationResponse?>? {
        return mainRequestApi.getTokenSyn(
            ApiUtils.BASIC_TOKEN,
            ApiUtils.CONTENT_TYPE,
            ApiUtils.GRANT_TYPE,
            AppConstants.LOGIN,
            AppConstants.PASSWORD
        )
    }
}