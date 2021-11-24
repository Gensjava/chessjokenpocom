package com.example.gena.chessjokenpocom.app.common

import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.accounts.NetworkErrorException
import android.content.Context
import android.os.Bundle

class ProfileAccountAuthenticator(context: Context?) : AbstractAccountAuthenticator(context) {
    var mContext: Context? = null

    fun ProfileAccountAuthenticator(context: Context?) {
        mContext = context
    }

    override fun editProperties(
        response: AccountAuthenticatorResponse?,
        accountType: String?
    ): Bundle? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun addAccount(
        response: AccountAuthenticatorResponse?,
        accountType: String?, authTokenType: String?,
        requiredFeatures: Array<String?>?, options: Bundle?
    ): Bundle? {
        return Bundle()
    }

    @Throws(NetworkErrorException::class)
    override fun confirmCredentials(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        options: Bundle?
    ): Bundle? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun getAuthToken(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        authTokenType: String?,
        options: Bundle?
    ): Bundle? {
        return null
    }

    override fun getAuthTokenLabel(authTokenType: String?): String? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun updateCredentials(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        authTokenType: String?,
        options: Bundle?
    ): Bundle? {
        return null
    }

    @Throws(NetworkErrorException::class)
    override fun hasFeatures(
        response: AccountAuthenticatorResponse?,
        account: Account?,
        features: Array<String?>?
    ): Bundle? {
        return null
    }
}