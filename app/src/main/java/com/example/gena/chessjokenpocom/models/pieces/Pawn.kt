package com.example.chessjokenpocom.models.pieces

import android.graphics.Color
import com.example.chessjokenpocom.models.Other.ArrayDimensionConverter
import com.example.gena.chessjokenpocom.R
import kotlin.collections.ArrayList

class Pawn(color: Int) : AbstractPiece(color) {
    var isFirstMove = true
    var shadowIsActive = false

    override fun getAloudMoves(position: Int?, board: Array<AbstractPiece?>?): ArrayList<Int> {
        val aloudMoves = ArrayList<Int>()
        val temp = ArrayDimensionConverter.pieceToTwoDimension(position!!)
        // If starting position
        if (position == 48 || position == 49 || position == 50 || position == 51 || position == 52 || position == 53 || position == 54 || position == 55) {
            if (board?.get(position - 8) == null) {
                aloudMoves.add(position - 8)
            }
            if (board?.get(position - 16) == null) {
                aloudMoves.add(position - 16)
            }
        } else {
            if (board?.get(position - 8) == null) {
                aloudMoves.add(position - 8)
            }
        }
        // Attack Left
        if (board?.get(position - 9) != null && board[position - 9]!!.color !== board[position]!!.color) {
            aloudMoves.add(position - 9)
        }
        // Attack Right
        if (board?.get(position - 7) != null && board[position - 7]!!.color !== board[position]!!.color) {
            aloudMoves.add(position - 7)
        }
        // TODO: Include shadow attack rule
        return aloudMoves
    }

    override fun toString(): String {
        return if (color === Color.BLACK) {
            "Black Pawn"
        } else {
            "White Pawn"
        }
    }

    init {
        if (color == Color.WHITE) {
            imageID = R.drawable.w_pawn
        } else {
            imageID = R.drawable.b_pawn
        }
    }
}