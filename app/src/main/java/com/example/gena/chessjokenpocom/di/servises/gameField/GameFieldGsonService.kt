package com.example.gena.chessjokenpocom.di.servises.gameField

import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.models.games.StepsGame

class GameFieldGsonService {

    fun GameFieldGsonService() {
        App.appComponent.inject(this)
    }


}
