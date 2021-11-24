package com.example.gena.chessjokenpocom.di.components

import com.example.gena.chessjokenpocom.di.models.ApiServiceModule
import com.example.gena.chessjokenpocom.di.models.AppModule
import com.example.gena.chessjokenpocom.di.models.GsonServiceModule
import com.example.gena.chessjokenpocom.di.servises.*
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignInPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.login.SignUpPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.other.TokenPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApiServiceModule::class, GsonServiceModule::class, AppModule::class))
interface AppComponent : GsonComponent, PresenterComponent, ApiComponent {
    fun inject(tokenPresenter: TokenPresenter?)

}