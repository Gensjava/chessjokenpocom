package com.example.gena.chessjokenpocom.mvp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse<T> : BaseError() {

    @SerializedName("success")
    @Expose
    var success: Boolean = false

    @SerializedName("body")
    @Expose
    var body: T? = null

}