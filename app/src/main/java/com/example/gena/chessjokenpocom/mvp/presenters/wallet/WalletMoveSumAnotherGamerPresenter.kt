package com.example.gena.chessjokenpocom.mvp.presenters.wallet

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.wallet.WalletApiService
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.wallet.WalletMovements
import com.example.gena.chessjokenpocom.mvp.views.wallet.WalletMoveSumAnotherGamerView
import javax.inject.Inject

@InjectViewState
class WalletMoveSumAnotherGamerPresenter : MvpPresenter<WalletMoveSumAnotherGamerView>() {
    @Inject
    lateinit var walletApiService: WalletApiService

    init {
        App.appComponent.inject(this)
    }

    fun setWalletMoveSumAnotherGamer() {
        viewState.setWalletMoveSumAnotherGamer()
    }

    @SuppressLint("CheckResult")
    fun setWalletMoveSumAnotherGamer(walletMovements: WalletMovements) {
        viewState.showProgress()
        val observable = walletApiService.setWalletMoveSumAnotherGamer(walletMovements)

        RxUtils.wrapAsync(observable)
            .subscribe({ data ->
                viewState.hideProgress()
                handleResponse(data)
            }, { exception ->
                viewState.hideProgress()
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<Boolean>) {
        try {
            if (response.success) {
                viewState.setWalletMoveSumAnotherGamerSuccessfully(response.body!!)
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