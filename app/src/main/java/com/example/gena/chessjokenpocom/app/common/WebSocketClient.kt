package com.example.gena.chessjokenpocom.app.common

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import com.example.gena.chessjokenpocom.BuildConfig.BASE_URL_WS
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import ua.naiksoftware.stomp.Stomp
import ua.naiksoftware.stomp.StompClient
import ua.naiksoftware.stomp.dto.LifecycleEvent

class WebSocketClient {

    companion object {
        var connectHttpHeaders =
            mutableMapOf("username" to AppConstants.LOGIN, "password" to AppConstants.PASSWORD)
        var mStompClient: StompClient? =
            Stomp.over(Stomp.ConnectionProvider.OKHTTP, BASE_URL_WS, connectHttpHeaders)

        @SuppressLint("CheckResult")
        fun getLifecycleEvent() {
            mStompClient!!.lifecycle()
                .subscribe { lifecycleEvent: LifecycleEvent ->
                    when (lifecycleEvent.type) {
                        LifecycleEvent.Type.OPENED -> Log.d(
                            ContentValues.TAG,
                            "Stomp connection opened"
                        )
                        LifecycleEvent.Type.ERROR -> Log.e(
                            ContentValues.TAG,
                            "Error",
                            lifecycleEvent.exception
                        )
                        LifecycleEvent.Type.CLOSED -> Log.d(
                            ContentValues.TAG,
                            "Stomp connection closed"
                        )
                    }
                }
        }
    }
}


// val mStompClient: StompClient

// ...

// ...
/*mStompClient = Stomp.over(
    Stomp.ConnectionProvider.JWS, "ws://192.168.100.114:5000/chess-bet/websocket"
)
mStompClient.connect()

mStompClient.topic("/user/topic/greetings/")
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe { topicMessage: StompMessage ->
        Log.d(
            TAG,
            "ооооооооооооооо " +topicMessage)
    }

mStompClient.send("/topic/game-field/", "My first STOMP message!").compose(RxUtils.applySchedulers())
    .subscribe(
        {      Log.d(
            TAG,
            "")

        }//"/gameField/send-move-step{sessionId}"
    ) { throwable: Throwable? ->
        Log.d(
            TAG,
            "33333333333333333333333")
    }
///chat/send-messages/  "/chat/add-user/{sessionId}"
// ...

// ...
//  mStompClient.disconnect()

mStompClient.lifecycle()
    .subscribe { lifecycleEvent: LifecycleEvent ->
        when (lifecycleEvent.type) {
            LifecycleEvent.Type.OPENED -> Log.d(TAG, "Stomp connection opened")
            LifecycleEvent.Type.ERROR -> Log.e(
                TAG,
                "Error",
                lifecycleEvent.exception
            )
            LifecycleEvent.Type.CLOSED -> Log.d(TAG, "Stomp connection closed")
        }
    }*/