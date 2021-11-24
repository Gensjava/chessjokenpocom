package com.example.gena.chessjokenpocom.ui.fragments.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import com.example.gena.chessjokenpocom.R

class SorryDialogOkFragment : BaseDialogFragment() {
    private var massage: String? = null
    private var title: Int? = null
    private var bundle: Bundle? = null

    internal var onSorryDialogOkFragmentListener: OnSorryDialogOkFragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = R.string.error_label_sorry
        bundle = arguments

        if (arguments != null) {
            massage = arguments!!.getString(MASSAGE)
            if (arguments!!.getInt(TITLE) != 0) {
                title = arguments!!.getInt(TITLE)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
        super.builder!!.setPositiveButton(getString(R.string.action_ok), this)
        super.builder!!.setTitle(title!!)
        super.builder!!.setMessage(massage)
        super.builder!!.setCancelable(false)
        return super.builder!!.create()
    }

    override fun onClick(dialogInterface: DialogInterface, i: Int) {
        super.onClick(dialogInterface, i)
        when (i) {
            Dialog.BUTTON_POSITIVE -> onSorryDialogOkFragmentListener!!.onClickSorryPositive(bundle)
            else -> {
            }
        }
    }

    interface OnSorryDialogOkFragmentListener {
        fun onClickSorryPositive(bundle: Bundle?)
    }

    override fun onDetach() {
        super.onDetach()
        this.onSorryDialogOkFragmentListener = null
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            this.onSorryDialogOkFragmentListener = context as OnSorryDialogOkFragmentListener?
        } catch (e: ClassCastException) {
            throw ClassCastException(context!!.toString())
        }
    }

    companion object {
        val MASSAGE = "MASSAGE"
        val TITLE = "TITLE"
        val CODE_MISTAKE = "CODE_MISTAKE"
    }
}