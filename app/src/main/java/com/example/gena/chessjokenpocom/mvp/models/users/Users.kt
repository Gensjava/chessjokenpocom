package com.example.gena.chessjokenpocom.mvp.models.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Users {
    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("username")
    @Expose
    var username: String?

    @SerializedName("password")
    @Expose
    var password: String?

    @SerializedName("enabled")
    @Expose
    var enabled: Boolean? = null

    @SerializedName("accountNonExpired")
    @Expose
    var accountNonExpired: Boolean? = null

    @SerializedName("accountNonLocked")
    @Expose
    var accountNonLocked: Boolean? = null

    @SerializedName("credentialsNonExpired")
    @Expose
    var credentialsNonExpired: Boolean? = null

    @SerializedName("authorities")
    @Expose
    var authorities: List<Any>? = null

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}