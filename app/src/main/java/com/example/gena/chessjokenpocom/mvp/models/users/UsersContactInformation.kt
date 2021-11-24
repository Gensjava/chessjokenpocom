package com.example.gena.chessjokenpocom.mvp.models.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersContactInformation {
    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("city")
    @Expose
    private val city: String? = null

    @SerializedName("country")
    @Expose
    private val country: String? = null

    constructor(email: String?) {
        this.email = email
    }
}