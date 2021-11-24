package com.example.gena.chessjokenpocom.app.common

import android.content.Context
import android.content.SharedPreferences
import com.example.gena.chessjokenpocom.app.App

object PrefUtils {
    private const val PREF_NAME = "Chess-bet"

    fun getPrefs(): SharedPreferences {
        return App.app
            .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun getEditor(): SharedPreferences.Editor? {
        return getPrefs().edit()
    }
}