package com.example.gena.chessjokenpocom.mvp.models.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersCryptoInformation {
    @SerializedName("id")
    @Expose
    private val id: Int = 0

    @SerializedName("idUser")
    @Expose
    private val idUser: Int = 0

    @SerializedName("imei")
    @Expose
    private var imei: String? = null

    @SerializedName("tokenNotifications")
    @Expose
    private var tokenNotifications: String? = null

    constructor(imei: String?, token: String?) {
        this.imei = imei
        this.tokenNotifications = token
    }

}