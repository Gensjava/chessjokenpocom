package com.example.gena.chessjokenpocom.app

import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.app.Application
import com.example.gena.chessjokenpocom.di.components.AppComponent
import com.example.gena.chessjokenpocom.di.components.DaggerAppComponent
import com.example.gena.chessjokenpocom.di.models.ApiServiceModule
import com.example.gena.chessjokenpocom.di.models.AppModule
import com.example.gena.chessjokenpocom.di.models.GsonServiceModule


@SuppressLint("Registered")
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var app: App
        lateinit var accountManager: AccountManager
    }

    fun getAppComponent(): AppComponent? {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        createDagger()
        accountManager = AccountManager.get(this)
    }

    private fun createDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .gsonServiceModule(GsonServiceModule())
            .apiServiceModule(ApiServiceModule()).build()
    }

    public fun getAccountManager(): AccountManager? {
        return accountManager
    }

}