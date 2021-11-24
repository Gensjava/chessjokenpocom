package com.example.gena.chessjokenpocom.network

import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GamersRequestApi {

    @GET("api/info-users/gamers-list")
    fun getUserGamersList(): Observable<BaseResponse<List<UsersPersonalInformation>>>

    @POST("api/game-field/create-match")
    fun setCreateMatch(@Body matches: Matches?): Observable<BaseResponse<Matches>>

    @GET("api/game-field/quick-play")
    fun getQuickPlay(): Observable<BaseResponse<Long>>

}
