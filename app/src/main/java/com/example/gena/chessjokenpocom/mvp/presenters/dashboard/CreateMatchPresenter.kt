package com.example.gena.chessjokenpocom.mvp.presenters.dashboard

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.GamersApiService
import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.views.gameField.СreateMatchView
import javax.inject.Inject

@InjectViewState
class CreateMatchPresenter : MvpPresenter<СreateMatchView>() {
    @Inject
    lateinit var gamersApiService: GamersApiService

    init {
        App.appComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    fun createMatch(matches: Matches) {
        viewState.showProgress()
        val dataObservable = gamersApiService.createMatch(
            matches
        )
        RxUtils.wrapAsync(dataObservable)
            .subscribe({ data ->
                handleResponse(data)
            }, { exception ->
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<Matches>) {
        viewState.hideProgress()
        try {
            if (response.success) {
                viewState.createMatchSuccessfully(response.body!!)
            } else {
                viewState.showError(response.message!!, response.status!!)
                viewState.hideProgress()
            }
        } catch (throwable: Throwable) {
            handleError(throwable)
        }
    }

    private fun handleError(exception: Throwable) {
        viewState.hideProgress()
        viewState.showError(exception)
    }
}