package com.example.gena.chessjokenpocom.mvp.presenters.login

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.LoginApiService
import com.example.gena.chessjokenpocom.mvp.models.BaseResponse
import com.example.gena.chessjokenpocom.mvp.models.users.Users
import com.example.gena.chessjokenpocom.mvp.views.login.SignInView
import javax.inject.Inject

@InjectViewState
class SignInPresenter : MvpPresenter<SignInView>() {
    @Inject
    lateinit var loginApiService: LoginApiService

    init {
        App.appComponent.inject(this)
    }

    fun getUser() {
        viewState.getUser()
    }

    @SuppressLint("CheckResult")
    fun getUser(imei: String, token: String) {
        viewState.showProgress()
        val userObservable = loginApiService.getUser(imei, token)

        RxUtils.wrapAsync(userObservable)
            .subscribe({ user ->
                viewState.hideProgress()
                handleResponse(user)
            }, { exception ->
                viewState.hideProgress()
                handleError(exception)
            })
    }

    private fun handleResponse(response: BaseResponse<Users>) {
        try {
            if (response.success) {
                viewState.SignInSuccessfully(response.body!!.username!!, response.body!!.id)
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
