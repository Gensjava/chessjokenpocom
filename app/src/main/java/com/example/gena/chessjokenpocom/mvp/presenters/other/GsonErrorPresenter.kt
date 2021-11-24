package com.example.gena.chessjokenpocom.mvp.presenters.other

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.enums.HttpStatusHelper
import com.example.gena.chessjokenpocom.helpers.EncoderHelper
import com.example.gena.chessjokenpocom.mvp.models.BaseError
import com.example.gena.chessjokenpocom.mvp.views.other.GsonErrorView
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException

@Suppress("IMPLICIT_BOXING_IN_IDENTITY_EQUALS")
@InjectViewState
class GsonErrorPresenter : MvpPresenter<GsonErrorView>() {

    fun httpException(exception: Throwable) = if (exception is HttpException) {
        try {
            val baseError: BaseError =
                EncoderHelper.converterErrorGSon(exception, BaseError::class.java)!!
            if (baseError.status === HttpStatusHelper.INTERNAL_SERVER_ERROR.value) {
                viewState.showError(baseError.message.toString(), baseError.status!!)
            } else {
                viewState.showError(baseError.message.toString())
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            viewState.showError(exception.message!!)
        }
    } else {
        val error: String = App.app.getString(R.string.failed_to_connect_to)
        if (exception.message!!.startsWith(error)) {
            viewState.showError(
                HttpStatusHelper.FAILED_TO_CONNECT.reasonPhrase,
                HttpStatusHelper.FAILED_TO_CONNECT.value
            )
        }
        try {
            throw RuntimeException(exception.message)
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            viewState.showError(throwable.message!!)
        }
    }

}
