package com.example.gena.chessjokenpocom.mvp.models.wallet

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WalletMovements(
    @SerializedName("walletId") @Expose private val walletId: Int = 0,
    @SerializedName("reasonOperation") @Expose private val reasonOperation: String? = null,
    @SerializedName("transactionDate") @Expose private val transactionDate: Long = 0,
    @SerializedName("amount") @Expose private val amount: Double = 0.0
)