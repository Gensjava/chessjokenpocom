package com.example.gena.chessjokenpocom.models.games

import com.example.gena.chessjokenpocom.mvp.models.BaseBody
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StepsGame() : BaseBody() {

    @SerializedName("id")
    @Expose
    private var id: Int = 0

    @SerializedName("idMatch")
    @Expose
    private var idMatch: Long = 0

    @SerializedName("whoMoveNext")
    @Expose
    private var whoMoveNext: String? = null

    @SerializedName("nameMovePiece")
    @Expose
    private var nameMovePiece: String? = null

    @SerializedName("idFromPosition")
    @Expose
    var idFromPosition = 0

    @SerializedName("idToPosition")
    @Expose
    var idToPosition = 0


    constructor(idFromPosition: Int, idToPosition: Int, namePiece: String) : this() {
        this.idFromPosition = idFromPosition
        this.idToPosition = idToPosition
        this.nameMovePiece = namePiece
    }

    val info: String
        get() = "idFromPosition: $idFromPosition  idToPosition: $idToPosition"


}