package com.example.gena.chessjokenpocom.mvp.presenters.other

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.other.TextWatcherView

@InjectViewState
class TextWatcherPresenter : MvpPresenter<TextWatcherView>() {

    fun setTextWatcher(view: EditText) {
        val newValue = object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                viewState.afterTextChanged(view.id, editable)
            }
        }
        view.addTextChangedListener(newValue)
    }
}