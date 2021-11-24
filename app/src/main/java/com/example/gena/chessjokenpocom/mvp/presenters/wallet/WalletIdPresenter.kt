package com.example.gena.chessjokenpocom.mvp.presenters.wallet

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.wallet.WalletApiService
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.views.wallet.WalletIdView
import javax.inject.Inject

@InjectViewState
class WalletIdPresenter : MvpPresenter<WalletIdView>() {
    @Inject
    lateinit var walletApiService: WalletApiService

    init {
        App.appComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    fun getWalletId() {
        viewState.showProgress()
        val observable = walletApiService.getIdWallet()

        RxUtils.wrapAsync(observable)
            .subscribe({ data ->
                viewState.hideProgress()
                handleResponse(data)
            }, { exception ->
                viewState.hideProgress()
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<Long>) {
        try {
            if (response.success) {
                viewState.getWalletIdSuccessfully(response.body!!)
                viewState.hideProgress()
            } else {
                viewState.showError(response.message!!, response.status!!)
                viewState.hideProgress()
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            handleError(throwable)
        }
    }

    private fun handleError(exception: Throwable) {
        viewState.hideProgress()
        viewState.showError(exception)
    }
}