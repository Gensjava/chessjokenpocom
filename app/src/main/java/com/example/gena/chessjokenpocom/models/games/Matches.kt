package com.example.gena.chessjokenpocom.models.games

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Matches(
    @SerializedName("id") @Expose private val id: Int = 0,

    @SerializedName("idCreator")
    @Expose
    private val idCreator: Int = 0,

    @SerializedName("idInvitee")
    @Expose
    private val idInvitee: Int = 0,

    @SerializedName("colorCreator")
    @Expose
    private val colorCreator: Int = 0,

    @SerializedName("colorInvitee")
    @Expose
    private val colorInvitee: Int = 0,

    @SerializedName("startDate")
    @Expose
    private val startDate: Long = 0,

    @SerializedName("finishDate")
    @Expose
    private val finishDate: Long = 0

)


