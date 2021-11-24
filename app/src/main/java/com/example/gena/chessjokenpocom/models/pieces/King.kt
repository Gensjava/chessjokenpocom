package com.example.chessjokenpocom.models.pieces

import android.graphics.Color
import com.example.chessjokenpocom.models.Other.ArrayDimensionConverter
import com.example.chessjokenpocom.models.Other.Position
import com.example.gena.chessjokenpocom.R
import kotlin.collections.ArrayList

class King(color: Int) : AbstractPiece(color) {

    override fun getAloudMoves(position: Int?, board: Array<AbstractPiece?>?): ArrayList<Int> {
        val aloudMoves = ArrayList<Int>()
        val temp2D: Position = ArrayDimensionConverter.pieceToTwoDimension(position!!)
        var newPosition: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 1, temp2D.r)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 1, temp2D.r + 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c, temp2D.r + 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 1, temp2D.r + 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 1, temp2D.r)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 1, temp2D.r - 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c, temp2D.r - 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        newPosition = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 1, temp2D.r - 1)
        if (newPosition != 100 && board?.get(newPosition) == null) {
            aloudMoves.add(newPosition)
        }
        return aloudMoves
    }

    override fun toString(): String {
        return if (color === Color.BLACK) {
            "Black King"
        } else {
            "White King"
        }
    }

    init {
        if (color == Color.WHITE) {
            imageID = R.drawable.w_king
        } else {
            imageID = R.drawable.b_king
        }
    }
}