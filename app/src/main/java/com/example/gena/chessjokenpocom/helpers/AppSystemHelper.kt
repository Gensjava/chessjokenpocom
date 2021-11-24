package com.example.gena.chessjokenpocom.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.telephony.TelephonyManager
import android.widget.Toast
import com.example.gena.chessjokenpocom.app.App

object AppSystemHelper {
    private const val NO_INTERNET_CONNECTION = "No internet connection"

    @SuppressLint("MissingPermission")
    fun getImei(): String? {
        try {
            val tm = App.app
                .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                tm.imei
            } else {
                tm.deviceId
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun isOnline(context: Context): Boolean {
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        if (netInfo != null && netInfo.isConnectedOrConnecting) {
            return true
        }
        Toast.makeText(App.app, NO_INTERNET_CONNECTION, Toast.LENGTH_LONG).show()
        return false
    }
}