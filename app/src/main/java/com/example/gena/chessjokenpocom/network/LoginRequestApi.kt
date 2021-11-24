package com.example.gena.chessjokenpocom.network

import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.Users
import com.example.gena.chessjokenpocom.mvp.models.users.UsersContactInformationBody
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface LoginRequestApi {

    @GET("api/user/sign-in")
    fun getUser(
        @Header("imei") imei: String,
        @Header("tokenFirebase") tokenFirebase: String
    ): Observable<BaseResponse<Users>>

    @POST("oauth/token")
    fun getToken(
        @Header("Authorization") token: String?,
        @Header("Content-Type") contentType: String?,
        @Query("grant_type") grant_type: String?,
        @Query("username") username: String?,
        @Query("password") password: String?
    ): Observable<Response<AuthorizationResponse?>?>?

    @POST("api/user/sign-up")
    fun setUser(@Body usersContactInformation: UsersContactInformationBody?): Observable<BaseResponse<Users?>?>?
}
