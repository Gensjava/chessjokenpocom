package com.example.gena.chessjokenpocom.mvp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseError {
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("error")
    @Expose
    var error: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("path")
    @Expose
    var path: String? = null
}