package com.example.gena.chessjokenpocom.ui.fragments.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.example.gena.chessjokenpocom.R

class ProgressBarFragment : MvpAppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreate(savedInstanceState)
        val alertDialog = AlertDialog.Builder(activity!!).create()
        alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.show()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setContentView(R.layout.app_progress_bar)
        return alertDialog
    }
}