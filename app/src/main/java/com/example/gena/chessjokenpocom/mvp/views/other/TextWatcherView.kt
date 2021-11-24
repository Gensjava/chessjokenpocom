package com.example.gena.chessjokenpocom.mvp.views.other

import android.text.Editable
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface TextWatcherView : MvpView {

    fun afterTextChanged(id: Int, editable: Editable)
}