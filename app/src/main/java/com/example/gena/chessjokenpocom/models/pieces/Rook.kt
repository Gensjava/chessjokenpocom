package com.example.chessjokenpocom.models.pieces

import android.graphics.Color
import com.example.chessjokenpocom.models.Other.ArrayDimensionConverter
import com.example.chessjokenpocom.models.Other.Position
import com.example.gena.chessjokenpocom.R
import kotlin.collections.ArrayList

class Rook(color: Int) : AbstractPiece(color) {

    override fun getAloudMoves(position: Int?, board: Array<AbstractPiece?>?): ArrayList<Int> {

        val aloudMoves = ArrayList<Int>()
        val temp: Position = ArrayDimensionConverter.pieceToTwoDimension(position!!)
        run {
            var i = 1
            while (i < 8) {
                val newPosition: Int =
                    ArrayDimensionConverter.pieceToOneDimension(temp.c, temp.r + i)
                if (newPosition != 100 && board?.get(newPosition) == null) {
                    aloudMoves.add(newPosition)
                } else {
                    if (newPosition < 64 && board?.get(newPosition)!!.color !== board?.get(position)!!.color) {
                        aloudMoves.add(newPosition)
                    }
                    i = 8
                }
                i++
            }
        }
        run {
            var i = 1
            while (i < 8) {
                val newPosition: Int =
                    ArrayDimensionConverter.pieceToOneDimension(temp.c, temp.r - i)
                if (newPosition != 100 && board?.get(newPosition) == null) {
                    aloudMoves.add(newPosition)
                } else {
                    if (newPosition < 64 && board?.get(newPosition)!!.color !== board?.get(position)!!.color) {
                        aloudMoves.add(newPosition)
                    }
                    i = 8
                }
                i++
            }
        }
        run {
            var i = 1
            while (i < 8) {
                val newPosition: Int =
                    ArrayDimensionConverter.pieceToOneDimension(temp.c + i, temp.r)
                if (newPosition != 100 && board?.get(newPosition) == null) {
                    aloudMoves.add(newPosition)
                } else {
                    if (newPosition < 64 && board?.get(newPosition)!!.color !== board?.get(position)!!.color) {
                        aloudMoves.add(newPosition)
                    }
                    i = 8
                }
                i++
            }
        }
        var i = 1
        while (i < 8) {
            val newPosition: Int = ArrayDimensionConverter.pieceToOneDimension(temp.c - i, temp.r)
            if (newPosition != 100 && board?.get(newPosition) == null) {
                aloudMoves.add(newPosition)
            } else {
                if (newPosition < 64 && board?.get(newPosition)!!.color !== board?.get(position)!!.color) {
                    aloudMoves.add(newPosition)
                }
                i = 8
            }
            i++
        }
        return aloudMoves
    }

    override fun toString(): String {
        return if (color === Color.BLACK) {
            "Black Rook"
        } else {
            "White Rook"
        }
    }

    init {
        if (color == Color.WHITE) {
            imageID = R.drawable.w_rook
        } else {
            imageID = R.drawable.b_rook
        }
    }
}