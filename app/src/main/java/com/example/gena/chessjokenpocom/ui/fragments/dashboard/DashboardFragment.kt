package com.example.gena.chessjokenpocom.ui.fragments.dashboard

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.databinding.FragmentDashbordBinding
import com.example.gena.chessjokenpocom.models.games.Matches
import com.example.gena.chessjokenpocom.mvp.presenters.dashboard.CreateMatchPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.dashboard.DashboardFragmentPresenter
import com.example.gena.chessjokenpocom.mvp.presenters.dashboard.QuickPlayPresenter
import com.example.gena.chessjokenpocom.mvp.views.dashboard.DashboardFragmentView
import com.example.gena.chessjokenpocom.mvp.views.dashboard.QuickPlayView
import com.example.gena.chessjokenpocom.mvp.views.gameField.СreateMatchView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView

class DashboardFragment : BaseFragmentView(), DashboardFragmentView, СreateMatchView,
    QuickPlayView {

    private var fragmentDashbordBinding: FragmentDashbordBinding? = null

    @InjectPresenter
    lateinit var dashboardFragmentPresenter: DashboardFragmentPresenter

    @InjectPresenter
    lateinit var quickPlayPresenter: QuickPlayPresenter

    @InjectPresenter
    lateinit var createMatchPresenter: CreateMatchPresenter

    private var clickListener: OnClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDashbordBinding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.fragment_dashbord,
            container,
            false
        )
                as FragmentDashbordBinding?

        initViews()
        return fragmentDashbordBinding!!.root
    }

    override fun initViews() {
        fragmentDashbordBinding!!.presenter = dashboardFragmentPresenter
    }

    interface OnClickListener {

        fun showLobby()

        fun showInventory()

        fun showOptions()

        fun createQuickPlay(idMatch: Long?)

        fun createMatch(matches: Matches)
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            clickListener = context as OnClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString())
        }
    }

    override fun createQuickPlay() {
        getQuickPlay()
    }

    override fun createMatch() {
        createMatchPresenter.createMatch(Matches(-1, AppConstants.ID_LOGIN,-1, Color.BLACK))
    }

    override fun createMatchSuccessfully(matches: Matches) {
        clickListener?.createMatch(matches)
    }

    override fun showLobby() {
        clickListener?.showLobby()
    }

    override fun showInventory() {
        clickListener?.showInventory()
    }

    override fun showOptions() {
        clickListener?.showOptions()
    }

    override fun getQuickPlay() {
        quickPlayPresenter.getQuickPlay()
    }

    override fun getQuickPlaySuccessfully(idMatch: Long?) {
        clickListener?.createQuickPlay(idMatch)
    }

}