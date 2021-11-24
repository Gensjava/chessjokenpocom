package com.example.gena.chessjokenpocom.mvp.presenters.gamers

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.GamersApiService
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import com.example.gena.chessjokenpocom.mvp.views.gamers.ListOfGamersView
import javax.inject.Inject

@InjectViewState
class ListOfGamersPresenter : MvpPresenter<ListOfGamersView>() {
    @Inject
    lateinit var gamersApiService: GamersApiService

    init {
        App.appComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    fun getListOfGamers() {
        viewState.showProgress()
        val dataObservable = gamersApiService.getUserGamersList(
        )

        RxUtils.wrapAsync(dataObservable)
            .subscribe({ user ->
                viewState.hideProgress()
                handleResponse(user)
            }, { exception ->
                viewState.hideProgress()
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<List<UsersPersonalInformation>>) {
        try {
            if (response.success) {
                viewState.getListOfGamersSuccessfully(response.body)
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