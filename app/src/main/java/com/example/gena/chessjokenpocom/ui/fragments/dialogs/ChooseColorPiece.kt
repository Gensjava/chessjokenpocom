package com.example.gena.chessjokenpocom.ui.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.example.gena.chessjokenpocom.R

class ChooseColorPiece : BaseDialogFragment() {
    private var numbersColor: Array<String>? = null
    internal var onClickListener: OnClickListener? = null
    private var color: Int = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.numbersColor = arrayOf(getString(R.string.white), getString(R.string.black))
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.choose_a_color))
                .setSingleChoiceItems(
                    numbersColor, 0
                ) { dialog, item ->
                    if (item == 0) {
                        color = Color.WHITE
                    } else {
                        color = Color.BLACK
                    }
                }
                .setPositiveButton(
                    getString(R.string.ok)
                ) { dialog, id ->
                    onClickListener!!.onClickChoose(color)
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface OnClickListener {
        fun onClickChoose(color: Int?)
    }

    override fun onDetach() {
        super.onDetach()
        this.onClickListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            this.onClickListener = context as OnClickListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }
    }
}