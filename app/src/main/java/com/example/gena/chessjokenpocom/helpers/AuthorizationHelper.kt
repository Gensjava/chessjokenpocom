package com.example.gena.chessjokenpocom.helpers

import android.accounts.Account
import android.accounts.AccountManager
import android.annotation.SuppressLint
import android.content.Context
import com.example.gena.chessjokenpocom.BuildConfig
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.app.common.SettingsUtils
import com.example.gena.chessjokenpocom.app.constants.AppConstants

object AuthorizationHelper {
    fun setAuthorized(context: Context?) {
        SettingsUtils.setLogin(AppConstants.LOGIN)
        SettingsUtils.setIdLogin(AppConstants.ID_LOGIN)
        try {
            AuthorizationHelper.create(AppConstants.LOGIN, AppConstants.PASSWORD, context)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getAuthorized(context: Context?) {
        AppConstants.LOGIN = SettingsUtils.getLogin()
        AppConstants.ID_LOGIN = SettingsUtils.getIdLogin()
        AppConstants.PASSWORD = getPassword(context)
    }

    @Throws(Exception::class)
    fun create(
        login: String?,
        password: String?,
        context: Context?
    ) {
        val account = getAccount(context)
        if (account == null) {
            App.accountManager.addAccountExplicitly(
                Account(login, BuildConfig.APPLICATION_ID),
                password,
                null
            )
        } else {
            App.accountManager.setPassword(account, password)
        }
    }

    @SuppressLint("MissingPermission")
    fun getPassword(context: Context?): String? {
        val account = getAccount(context)
        return if (account != null) {
            App.accountManager.getPassword(account)
        } else {
            null
        }
    }

    @SuppressLint("MissingPermission")
    private fun getAccount(context: Context?): Account? {
        val accounts = AccountManager.get(context).accounts
        for (account in accounts) {
            if (account.type.equals(BuildConfig.APPLICATION_ID, ignoreCase = true)) {
                return account
            }
        }
        return null
    }
}