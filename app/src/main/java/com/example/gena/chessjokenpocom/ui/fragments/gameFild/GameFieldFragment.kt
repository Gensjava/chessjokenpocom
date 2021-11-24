package com.example.gena.chessjokenpocom.ui.fragments.gameFild


import android.annotation.SuppressLint
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.chessjokenpocom.models.Other.Constants
import com.example.chessjokenpocom.models.Other.Match
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.app.common.WebSocketClient
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.app.enums.ReasonOperations
import com.example.gena.chessjokenpocom.databinding.FragmentGameFieldBinding
import com.example.gena.chessjokenpocom.helpers.BundleHelper
import com.example.gena.chessjokenpocom.models.games.StepsGame
import com.example.gena.chessjokenpocom.mvp.models.wallet.WalletMovements
import com.example.gena.chessjokenpocom.mvp.presenters.gameField.GameFieldFragmentPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.wallet.WalletIdPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.wallet.WalletMoveSumAnotherGamerPresenter
import com.example.gena.chessjokenpocom.mvp.views.gameField.GameFieldFragmentView
import com.example.gena.chessjokenpocom.mvp.views.wallet.WalletIdView
import com.example.gena.chessjokenpocom.mvp.views.wallet.WalletMoveSumAnotherGamerView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView


class GameFieldFragment : BaseFragmentView(), GameFieldFragmentView, WalletIdView,
    WalletMoveSumAnotherGamerView {

    @InjectPresenter
    lateinit var gameFieldFragmentPresenter: GameFieldFragmentPresenter

    @InjectPresenter
    lateinit var walletIdPresenter: WalletIdPresenter

    @InjectPresenter
    lateinit var walletMoveSumAnotherGamerPresenter: WalletMoveSumAnotherGamerPresenter

    private var onItemClickTile: Match.OnItemClickTile? = null
    private var onClickListener: OnClickListener? = null
    private var tvNameMyPartner: TextView? = null
    private var idPartner: String = ""
    private var match: Match? = null
    private var nameMyPartner: String? = ""
    private var myPartnerWalletId: Long = -1
    private var aBet: Double = 10.0
    var idMatch: Long = -1

    private var fragmentGameFieldBinding: FragmentGameFieldBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            nameMyPartner = arguments!!.getString(BundleHelper.NAME)
            //idPartner = arguments!!.getString(BundleHelper.ID)
            idMatch = arguments!!.getLong(BundleHelper.ID_MATCH)
        }
        onClickListener!!.showChooseColor()
        walletIdPresenter.getWalletId()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentGameFieldBinding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.fragment_game_field,
            container,
            false
        )
                as FragmentGameFieldBinding?

        initViews()
        return fragmentGameFieldBinding!!.root
    }

    override fun initViews() {
        val tvMyName = fragmentGameFieldBinding!!.tvMyName
        this.tvNameMyPartner = fragmentGameFieldBinding!!.tvNameMyPartner
        val tvWhoWon = fragmentGameFieldBinding!!.tvWhoWon

        tvMyName.text = "Me"

        this.tvNameMyPartner!!.text = nameMyPartner

        val gridView = fragmentGameFieldBinding!!.chessBoard
        gridView.horizontalSpacing = 3
        gridView.verticalSpacing = 3
        match = Match(context, gridView, tvWhoWon)
        match!!.start()
        match!!.setOnItemClickListener(onItemClickTile!!)
    }

    override fun sendNextStep(stepsGame: StepsGame?) {
        gameFieldFragmentPresenter.sendNextStep(stepsGame!!, AppConstants.ID_LOGIN, idPartner)
    }

    override fun getNextStep(stepsGame: StepsGame?) {
        match!!.move(
            Constants.boardReflection.get(stepsGame!!.idFromPosition)!!,
            Constants.boardReflection.get(stepsGame.idToPosition)!!
        )
    }

    override fun switchColor(color: Int) {
        match!!.switchColor(color)
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()
        if (WebSocketClient.mStompClient == null || !WebSocketClient.mStompClient!!.isConnected) {
            WebSocketClient.mStompClient!!.connect()
        }
        gameFieldFragmentPresenter.subscribeNextStep(idPartner, AppConstants.ID_LOGIN)
        gameFieldFragmentPresenter.addUser()
    }

    override fun onDetach() {
        super.onDetach()
        onItemClickTile = null
        if (WebSocketClient.mStompClient == null || !WebSocketClient.mStompClient!!.isConnected) {
            WebSocketClient.mStompClient!!.disconnect()
        }
    }

    interface OnClickListener {
        fun showChooseColor()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            onItemClickTile = context as Match.OnItemClickTile
            onClickListener = context as OnClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString())
        }
    }

    override fun getWalletId() {
        walletIdPresenter.getWalletId()
    }

    override fun getWalletIdSuccessfully(walletId: Long) {
        myPartnerWalletId = walletId
    }

    override fun setWalletMoveSumAnotherGamer() {
        walletMoveSumAnotherGamerPresenter.setWalletMoveSumAnotherGamer(
            WalletMovements(
                myPartnerWalletId.toInt(),
                ReasonOperations.RESPONSE_INFO_TRANSFER_MONEY_ANOTHER_PLAYER.reasonPhrase,
                System.currentTimeMillis(), aBet
            )
        )
    }

    override fun setWalletMoveSumAnotherGamerSuccessfully(boolean: Boolean) {

    }
}
