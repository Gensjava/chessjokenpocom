package com.example.gena.chessjokenpocom.mvp.presenters.other

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.Session
import com.example.gena.chessjokenpocom.app.common.RxUtils
import com.example.gena.chessjokenpocom.di.servises.LoginApiService
import com.example.gena.chessjokenpocom.di.servises.MainApiService
import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import com.example.gena.chessjokenpocom.mvp.views.other.TokenView
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject


@InjectViewState
class TokenPresenter : MvpPresenter<TokenView>() {
    @Inject
    lateinit var mainApiService: LoginApiService

    init {
        App.appComponent.inject(this)
    }

    @SuppressLint("CheckResult")
    fun getToken() {
        val responseObservable: Observable<Response<AuthorizationResponse?>?>? =
            mainApiService.getToken()
        RxUtils.wrapAsync(responseObservable!!)
            .subscribe({ response: Response<AuthorizationResponse?>? ->
                handleResponse(response)
            }, { exception: Throwable -> handleError(exception) })
    }

    private fun handleResponse(response: Response<AuthorizationResponse?>?) {
        try {
            if (response!!.isSuccessful) {
                viewState.hideProgress()
                Session.accessToken = response.body()?.accessToken
                viewState.successfulGetToken()
            } else {
                viewState.showError(response.message(), response.code())
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

