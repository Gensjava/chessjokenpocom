package com.example.gena.chessjokenpocom.helpers

import android.app.Activity
import android.view.View

object MessagesHelper {

    fun showSnackBar(view: View, text: Int) {
//        val snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
//            .setActionTextColor(App.getInstance().getResources().getColor(R.color.colorAccent))
//        snackbar.show()
//        setThemeSnackbar(snackbar)
    }

    fun requestPermissionsPhone(
        activity: Activity,
        view: View,
        text: Int,
        permission: Array<String>,
        request: Int
    ) {
//        val snackbar = Snackbar.make(
//            view,
//            text, Snackbar.LENGTH_INDEFINITE
//        )
//            .setActionTextColor(App.app.getResources().getColor(R.color.colorAccent))
//            .setAction(R.string.action_ok, { onClickListener ->
//                ActivityCompat.requestPermissions(
//                    activity,
//                    permission,
//                    request
//                )
//            })
//        snackbar.show()
//        setThemeSnackbar(snackbar)
    }

    // private fun setThemeSnackbar(snackbar: Snackbar) {//TODO
//        val snackbarView = snackbar.getView()
//        snackbarView.setBackgroundColor(Color.WHITE)
//        val snackTextView = snackbarView.findViewById(android.support.design.R.id.snackbar_text)
//        snackTextView.setTextColor(Color.BLACK)
    // }
}