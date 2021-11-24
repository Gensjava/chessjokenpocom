package com.example.gena.chessjokenpocom.ui.fragments.gamers

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.gena.chessjokenpocom.R
import com.example.gena.chessjokenpocom.adapters.ListOfGamersAdapter
import com.example.gena.chessjokenpocom.databinding.FragmentListOfGamersBinding
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import com.example.gena.chessjokenpocom.mvp.presenters.gamers.ListOfGamersPresenter
import com.example.gena.chessjokenpocom.mvp.views.gamers.ListOfGamersView
import com.example.gena.chessjokenpocom.ui.fragments.BaseFragmentView

class ListOfGamersFragment : BaseFragmentView(), ListOfGamersView {

    private var fragmentListOfGamers: FragmentListOfGamersBinding? = null
    private var listOfGamersAdapter: ListOfGamersAdapter? = null
    private var onItemClickListener: ListOfGamersAdapter.OnItemClickListener? = null

    @InjectPresenter
    lateinit var listOfGamersPresenter: ListOfGamersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOfGamersAdapter = ListOfGamersAdapter(
            R.layout.item_gamer,
            BR.usersContactInformation,
            context
        )
        listOfGamersAdapter!!.setOnItemClickListener(onItemClickListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListOfGamers =
            DataBindingUtil.inflate<ViewDataBinding>(
                inflater,
                R.layout.fragment_list_of_gamers,
                container,
                false
            ) as FragmentListOfGamersBinding?
        fragmentListOfGamers!!.list.setHasFixedSize(true)
        fragmentListOfGamers!!.list.layoutManager = LinearLayoutManager(activity)
        fragmentListOfGamers!!.list.adapter = listOfGamersAdapter
        initViews()
        return fragmentListOfGamers!!.root
    }

    override fun initViews() {
        super.initViews()
        getListOfGamers()
    }

    override fun getListOfGamers() {
        listOfGamersPresenter.getListOfGamers()
    }

    override fun getListOfGamersSuccessfully(listOfGamers: List<UsersPersonalInformation>?) {
        listOfGamersAdapter!!.setItems(listOfGamers)
        listOfGamersAdapter!!.notifyDataSetChanged()
    }

    override fun onDetach() {
        super.onDetach()
        onItemClickListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            onItemClickListener = context as ListOfGamersAdapter.OnItemClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString())
        }
    }
}