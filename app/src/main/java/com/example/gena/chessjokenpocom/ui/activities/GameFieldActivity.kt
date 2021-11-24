package com.example.gena.chessjokenpocom.ui.activities


import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.chessjokenpocom.models.Other.Match
import com.example.gena.chessjokenpocom.app.enums.HttpStatusHelper
import com.example.gena.chessjokenpocom.helpers.BundleHelper
import com.example.gena.chessjokenpocom.helpers.WindowHelper
import com.example.gena.chessjokenpocom.models.games.StepsGame
import com.example.gena.chessjokenpocom.mvp.presenters.gameField.GameFieldPresenter
import com.example.gena.chessjokenpocom.mvp.views.gameField.GameFieldView
import com.example.gena.chessjokenpocom.ui.fragments.dialogs.ChooseColorPiece
import com.example.gena.chessjokenpocom.ui.fragments.gameFild.GameFieldFragment

class GameFieldActivity : BaseActionBarActivity(), GameFieldView, Match.OnItemClickTile,
    GameFieldFragment.OnClickListener, ChooseColorPiece.OnClickListener {

    @InjectPresenter
    lateinit var gameFieldPresenter: GameFieldPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.extras != null) {
            gameFieldPresenter.showGameField(intent.extras.getLong(BundleHelper.ID_MATCH))
        } else{
            super.showError(HttpStatusHelper.ERROR_DID_NOT_FIND_DATA.reasonPhrase, HttpStatusHelper.ERROR_DID_NOT_FIND_DATA.value)
        }
    }

    override fun showGameField(idMatch: Long) {
        WindowHelper.showFragment(
            GameFieldFragment::class.java,
            BundleHelper.getIdMatch(idMatch)!!,
            this
        )
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
