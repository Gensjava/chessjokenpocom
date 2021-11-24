package com.example.gena.chessjokenpocom.mvp.views.gamers

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.gena.chessjokenpocom.mvp.models.users.UsersPersonalInformation
import com.example.gena.chessjokenpocom.mvp.views.BaseView


@StateStrategyType(OneExecutionStateStrategy::class)
interface ListOfGamersView : BaseView {
    fun getListOfGamers()

    fun getListOfGamersSuccessfully(listOfGamers: List<UsersPersonalInformation>?)
}