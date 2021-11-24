package com.example.gena.chessjokenpocom.mvp.presenters.dashboard

import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.mvp.views.dashboard.DashboardFragmentView

@InjectViewState
class DashboardFragmentPresenter : MvpPresenter<DashboardFragmentView>() {
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_create_match -> viewState.createMatch()
            R.id.tv_quick_play -> viewState.createQuickPlay()
            R.id.tv_lobby -> viewState.showLobby()
            R.id.tv_inventory -> viewState.showInventory()
            R.id.tv_options -> viewState.showOptions()
            else -> {
                viewState.showError(R.string.error_label_sorry.toString(), 0)
            }
        }
    }
}