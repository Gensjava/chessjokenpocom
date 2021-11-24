package com.example.chessjokenpocom.models.pieces

import android.graphics.Color
import com.example.chessjokenpocom.models.Other.ArrayDimensionConverter
import com.example.chessjokenpocom.models.Other.Position
import com.example.gena.chessjokenpocom.R
import kotlin.collections.ArrayList

class Knight(color: Int) : AbstractPiece(color) {

    override fun getAloudMoves(position: Int?, board: Array<AbstractPiece?>?): ArrayList<Int> {
        val aloudMoves = ArrayList<Int>()
        val temp2D: Position = ArrayDimensionConverter.pieceToTwoDimension(position!!)
        val pos1: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 2, temp2D.r - 1)
        val pos2: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 2, temp2D.r + 1)
        val pos3: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 2, temp2D.r - 1)
        val pos4: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 2, temp2D.r + 1)
        val pos5: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 1, temp2D.r + 2)
        val pos6: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c - 1, temp2D.r - 2)
        val pos7: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 1, temp2D.r + 2)
        val pos8: Int = ArrayDimensionConverter.pieceToOneDimension(temp2D.c + 1, temp2D.r - 2)
        val temp = intArrayOf(pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8)
        for (i in temp.indices) {
            if (temp[i] != 100 && board?.get(temp[i]) == null) {
                aloudMoves.add(temp[i])
            } else {
                if (temp[i] != 100 && board?.get(temp[i])!!.color !== board?.get(position)!!.color) {
                    aloudMoves.add(temp[i])
                }
            }
        }
        return aloudMoves
    }

    override fun toString(): String {
        return if (color === Color.BLACK) {
            "Black Knight"
        } else {
            "White Knight"
        }
    }

    init {
        if (color == Color.WHITE) {
            imageID = R.drawable.w_knight
        } else {
            imageID = R.drawable.b_knight
        }
    }
}