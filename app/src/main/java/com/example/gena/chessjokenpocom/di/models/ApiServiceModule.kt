package com.example.gena.chessjokenpocom.di.models

import com.example.gena.chessjokenpocom.BuildConfig
import com.example.gena.chessjokenpocom.di.servises.GamersApiService
import com.example.gena.chessjokenpocom.di.servises.LoginApiService
import com.example.gena.chessjokenpocom.di.servises.MainApiService
import com.example.gena.chessjokenpocom.di.servises.wallet.WalletApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiServiceModule {
    private val BASE_URL = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideLoginApiService(): LoginApiService {
        return LoginApiService()
    }

    @Singleton
    @Provides
    fun provideMainApiService(): MainApiService {
        return MainApiService()
    }

    @Singleton
    @Provides
    fun provideGamersApiService(): GamersApiService {
        return GamersApiService()
    }

    @Singleton
    @Provides
    fun provideWalletApiService(): WalletApiService {
        return WalletApiService()
    }
}