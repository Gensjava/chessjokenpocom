package com.example.gena.chessjokenpocom.helpers

import android.os.Bundle

object BundleHelper {
    const val NAME = "NAME"
    const val ID = "ID"
    const val ID_MATCH = "ID_MATCH"

    fun getNameAndID(name: String?, id: String?): Bundle? {
        val bundle = Bundle()
        bundle.putString(ID, id)
        bundle.putString(NAME, name)
        return bundle
    }

    fun getIdMatch(id: Long?): Bundle? {
        val bundle = Bundle()
        bundle.putLong(ID_MATCH, id!!)
        return bundle
    }
}