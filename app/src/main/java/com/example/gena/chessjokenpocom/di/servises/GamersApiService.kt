package com.example.gena.chessjokenpocom.di.servises


import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RetrofitClient
import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import com.example.gena.chessjokenpocom.network.GamersRequestApi
import io.reactivex.Observable

class GamersApiService {
    private val gamersRequestApi: GamersRequestApi

    init {
        App.appComponent.inject(this)
        gamersRequestApi = RetrofitClient.retrofit.create(GamersRequestApi::class.java)
    }

    fun getUserGamersList(): Observable<BaseResponse<List<UsersPersonalInformation>>> {
        return gamersRequestApi.getUserGamersList()
    }

    fun createMatch(matches: Matches):  Observable<BaseResponse<Matches>> {
        return gamersRequestApi.setCreateMatch(matches)
    }

    fun getQuickPlay(): Observable<BaseResponse<Long>> {
        return gamersRequestApi.getQuickPlay()
    }


}
