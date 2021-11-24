package com.example.gena.chessjokenpocom.app.common

object SettingsUtils {
    private const val LOGIN = "LOGIN"
    private const val ID_LOGIN = "ID_LOGIN"

    fun getLogin(): String? {
        return PrefUtils.getPrefs().getString(LOGIN, null)
    }

    fun getIdLogin(): Int {
        return PrefUtils.getPrefs().getInt(ID_LOGIN, 0)
    }

    fun setLogin(login: String?) {
        PrefUtils.getEditor()!!.putString(LOGIN, login).commit()
    }

    fun setIdLogin(login: Int) {
        PrefUtils.getEditor()!!.putInt(ID_LOGIN, login).commit()
    }


}