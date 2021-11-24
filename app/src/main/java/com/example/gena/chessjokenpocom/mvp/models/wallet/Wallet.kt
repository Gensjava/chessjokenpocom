package com.example.gena.chessjokenpocom.mvp.models.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wallet {
    @SerializedName("id")
    @Expose
    private val id: Int = 0

    @SerializedName("userId")
    @Expose
    private val userId: Int = 0

    @SerializedName("balance")
    @Expose
    private val balance = 0.0

}