package com.example.gena.chessjokenpocom.mvp.presenters.other

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.gena.chessjokenpocom.mvp.views.other.PermissionsView

@InjectViewState
class PermissionsPresenter : MvpPresenter<PermissionsView>() {

    fun checkReadPhoneContacts(permissions: Array<String>, context: Context) {
        if (isAllAllowed(permissions, context)) {
            viewState.successPermissions()
        } else {
            viewState.onRequestPermissions()
        }
    }

    fun isAllAllowed(permissions: Array<String>, context: Context): Boolean {
        var allAllowed = true
        for (itemPermission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    itemPermission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                allAllowed = false
                break
            }
        }
        return allAllowed
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
        context: Context
    ) {
        if (requestCode == REQUEST_PERMISSIONS) {
            if (grantResults.size == 1) {
                if (isAllAllowed(permissions, context)) {
                    viewState.successPermissions()
                } else {
                    viewState.showPermissionsNotGranted()
                }
            }
        } else {
            viewState.onRequestPermissionsResultDefault(requestCode, permissions, grantResults)
        }
    }

    fun showPermissions() {
        viewState.showPermissions()
    }

    fun requestPermissions() {
        viewState.requestPermissions()
    }

    companion object {
        val REQUEST_PERMISSIONS = 1004
    }
}
