package com.example.gena.chessjokenpocom.network

import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface MainRequestApi {
    @POST("oauth/token")
    fun getToken(
        @Header("Authorization") token: String?,
        @Header("Content-Type") contentType: String?,
        @Query("grant_type") grant_type: String?,
        @Query("username") username: String?,
        @Query("password") password: String?
    ): Observable<Response<AuthorizationResponse?>?>?

    @POST("oauth/token")
    fun getTokenSyn(
        @Header("Authorization") token: String?,
        @Header("Content-Type") contentType: String?,
        @Query("grant_type") grant_type: String?,
        @Query("username") username: String?,
        @Query("password") password: String?
    ): Call<AuthorizationResponse?>?
}