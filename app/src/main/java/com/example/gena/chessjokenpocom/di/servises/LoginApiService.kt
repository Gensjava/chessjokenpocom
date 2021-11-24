package com.example.gena.chessjokenpocom.di.servises


import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RetrofitClient
import com.example.gena.chessjokenpocom.app.constants.ApiUtils
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.*
import com.example.gena.chessjokenpocom.network.LoginRequestApi
import io.reactivex.Observable
import retrofit2.Response

class LoginApiService {
    private val loginRequestApi: LoginRequestApi

    init {
        App.appComponent.inject(this)
        loginRequestApi = RetrofitClient.retrofit.create(LoginRequestApi::class.java)
    }

    fun getUser(imei: String, token: String): Observable<BaseResponse<Users>> {
        return loginRequestApi.getUser(imei, token)
    }

    fun setUser(
        firstName: String?,
        secondName: String?,
        email: String?,
        password: String?,
        imei: String?,
        token: String?
    ): Observable<BaseResponse<Users?>?>? {
        return loginRequestApi.setUser(
            UsersContactInformationBody(
                Users(email, password),
                UsersContactInformation(email),
                UsersPersonalInformation(firstName, secondName),
                UsersCryptoInformation(imei, token)
            )
        )
    }

    fun getToken(): Observable<Response<AuthorizationResponse?>?>? {
        return loginRequestApi.getToken(
            ApiUtils.BASIC_TOKEN,
            ApiUtils.CONTENT_TYPE,
            ApiUtils.GRANT_TYPE,
            AppConstants.LOGIN,
            AppConstants.PASSWORD
        )
    }
}
