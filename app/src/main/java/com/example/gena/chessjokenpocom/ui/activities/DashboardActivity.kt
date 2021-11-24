package com.example.gena.chessjokenpocom.ui.activities

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.helpers.BundleHelper
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.presenters.home.DashBoardPresenter
import com.example.gena.chessjokenpocom.mvp.views.home.DashBoardView
import com.example.gena.chessjokenpocom.ui.fragments.dashboard.DashboardFragment

class DashboardActivity : BaseActionBarActivity(), DashBoardView, DashboardFragment.OnClickListener {
    @InjectPresenter
    lateinit var dashBoardPresenter: DashBoardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDashBoard()
    }

    override fun showDashBoard() {
        WindowHelper.showFragment(DashboardFragment::class.java, this)
    }

    override fun showLobby() {
        WindowHelper.showActivity(GamersActivity::class.java, this)
    }

    override fun showInventory() {

    }

    override fun showOptions() {

    }

    override fun createQuickPlay(idMatch: Long?) {
        val intent = Intent(this, GameFieldActivity::class.java)
        intent.putExtra(BundleHelper.ID_MATCH, idMatch)
        startActivity(intent)
        finish()
    }

    override fun createMatch(matches: Matches) {
        WindowHelper.showActivity(GameFieldActivity::class.java, this)
    }
}
