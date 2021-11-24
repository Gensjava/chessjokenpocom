package com.example.gena.chessjokenpocom.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.chessjokenpocom.models.Other.Match
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.adapters.ListOfGamersAdapter
import com.example.gena.chessjokenpocom.helpers.BundleHelper
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.models.games.StepsGame
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import com.example.gena.chessjokenpocom.mvp.presenters.gamers.GamersPresenter
import com.example.gena.chessjokenpocom.mvp.views.login.GamersView
import com.example.gena.chessjokenpocom.ui.fragments.dialogs.ChooseColorPiece
import com.example.gena.chessjokenpocom.ui.fragments.gameFild.GameFieldFragment
import com.example.gena.chessjokenpocom.ui.fragments.gamers.ListOfGamersFragment

@SuppressLint("Registered")
class GamersActivity : BaseActionBarActivity(), GamersView, ListOfGamersAdapter.OnItemClickListener,
    Match.OnItemClickTile, GameFieldFragment.OnClickListener,
    ChooseColorPiece.OnClickListener {

    @InjectPresenter
    lateinit var loginPresenter: GamersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showListOfGamers()
        setHomeButton(getString(R.string.list_of_gamers))
    }

    override fun onItemClick(item: UsersPersonalInformation?) {
        BundleHelper.getNameAndID(item!!.firstName, item.userId)?.let {
            WindowHelper.showFragment(
                GameFieldFragment::class.java,
                it, this
            )
        }
        setHomeButton(getString(R.string.match))
    }

    override fun showListOfGamers() {
        WindowHelper.showFragment(ListOfGamersFragment::class.java, this)
    }

    override fun showGameFieldFragment() {
        WindowHelper.showFragment(GameFieldFragment::class.java, this)
        //(WindowHelper.getLinkFragment(GameFieldFragment::class.java, this) as GameFieldFragment?)?.setNameMyPartner(color!!)
        // setHomeButton( getString(R.string.match))
    }

    override fun onMove(idFromPosition: Int, idToPosition: Int, namePiece: String) {
        (WindowHelper.getLinkFragment(
            GameFieldFragment::class.java,
            this
        ) as GameFieldFragment?)?.sendNextStep(StepsGame(idFromPosition, idToPosition, namePiece))
    }

    override fun moveSumAnotherGamer(colorsTurn: Int) {

    }

    override fun showChooseColor() {
        WindowHelper.showDialogFragment(ChooseColorPiece::class.java, this)
    }

    override fun onClickChoose(color: Int?) {
        (WindowHelper.getLinkFragment(
            GameFieldFragment::class.java,
            this
        ) as GameFieldFragment?)?.switchColor(color!!)
    }
}
