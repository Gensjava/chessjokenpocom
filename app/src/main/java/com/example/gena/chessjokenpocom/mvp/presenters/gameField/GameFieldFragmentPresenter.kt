package com.example.gena.chessjokenpocom.mvp.presenters.gameField


import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.app.common.RxUtils.applySchedulers
import com.example.gena.chessjokenpocom.app.common.WebSocketClient
import com.example.gena.chessjokenpocom.helpers.GsonHelper
import com.example.gena.chessjokenpocom.models.games.StepsGame
import com.example.gena.chessjokenpocom.mvp.views.gameField.GameFieldFragmentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.naiksoftware.stomp.dto.StompMessage

@InjectViewState
class GameFieldFragmentPresenter : MvpPresenter<GameFieldFragmentView>() {

    @SuppressLint("CheckResult")
    fun subscribeNextStep(idGamerFrom: String, idGamerTo: Int) {
        WebSocketClient.mStompClient!!.topic("/topic/queue/hello")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { topicMessage: StompMessage ->
                val stepsGame: StepsGame =
                    GsonHelper.fromGsonToObject(StepsGame::class.java, topicMessage.payload)
                viewState.getNextStep(stepsGame)
            }
    }

    @SuppressLint("CheckResult")
    fun sendNextStep(stepsGame: StepsGame, idGamerFrom: Int, idGamerTo: String) {
        WebSocketClient.mStompClient!!.send(
                "/queue/hello",
                stepsGame.toString()
            )
            .compose(applySchedulers())
            .subscribe(
                { viewState.showRequestSuccessfully("") }
            ) { throwable: Throwable? ->
                viewState.showError(
                    throwable!!
                )
            }
    }

    @SuppressLint("CheckResult")
    fun addUser() {
        WebSocketClient.mStompClient!!.send("/queue/game-field/add-user")
            .compose(applySchedulers())
            .subscribe(
                { viewState.showRequestSuccessfully("") }
            ) { throwable: Throwable? ->
                viewState.showError(
                    throwable!!
                )
            }
    }
}