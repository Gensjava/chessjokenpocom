package com.example.gena.chessjokenpocom.mvp.presenters.dashboard

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.GamersApiService
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.views.dashboard.QuickPlayView
import javax.inject.Inject

@InjectViewState
class QuickPlayPresenter : MvpPresenter<QuickPlayView>() {
    @Inject
    lateinit var gamersApiService: GamersApiService

    init {
        App.appComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    fun getQuickPlay() {
        viewState.showProgress()
        val dataObservable = gamersApiService.getQuickPlay()
        RxUtils.wrapAsync(dataObservable)
            .subscribe({ data ->
                handleResponse(data)
            }, { exception ->
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<Long>) {
        viewState.hideProgress()
        try {
            if (response.success) {
                viewState.getQuickPlaySuccessfully(response.body!!)
            } else {
                viewState.showError(response.message!!, response.status!!)
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