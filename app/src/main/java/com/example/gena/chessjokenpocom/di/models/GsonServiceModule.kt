package com.example.gena.chessjokenpocom.di.models

import com.example.gena.chessjokenpocom.di.servises.gameField.GameFieldGsonService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GsonServiceModule {
    @Singleton
    @Provides
    fun provideGameFieldGsonService(): GameFieldGsonService? {
        return GameFieldGsonService()
    }
}