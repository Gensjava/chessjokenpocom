package com.example.chessjokenpocom.models.Other

import android.graphics.Color
import com.example.chessjokenpocom.models.pieces.*

object Constants {
    val dark = Color.parseColor("#696969")
    val light = Color.parseColor("#b0b0b0")

    val boardReflection: HashMap<Int, Int> = HashMap()

    val newBoardColors = intArrayOf(
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        dark,
        light,
        dark,
        light,
        dark,
        light,
        dark,
        light
    )

    val newBoardWhite: Array<AbstractPiece?> = arrayOf<AbstractPiece?>(
        Rook(Color.BLACK), Knight(Color.BLACK), Bishop(Color.BLACK),
        Queen(Color.BLACK), King(Color.BLACK), Bishop(Color.BLACK),
        Knight(Color.BLACK), Rook(Color.BLACK), Pawn(Color.BLACK),
        Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK),
        Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK),
        Pawn(Color.BLACK),
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null,
        Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE),
        Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE),
        Rook(Color.WHITE), Knight(Color.WHITE), Bishop(Color.WHITE), Queen(Color.WHITE),
        King(Color.WHITE), Bishop(Color.WHITE), Knight(Color.WHITE), Rook(Color.WHITE)
    )

    val newBoardBlack: Array<AbstractPiece?> = arrayOf<AbstractPiece?>(
        Rook(Color.WHITE), Knight(Color.WHITE), Bishop(Color.WHITE),
        Queen(Color.WHITE), King(Color.WHITE), Bishop(Color.WHITE),
        Knight(Color.WHITE), Rook(Color.WHITE), Pawn(Color.WHITE),
        Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE),
        Pawn(Color.WHITE), Pawn(Color.WHITE), Pawn(Color.WHITE),
        Pawn(Color.WHITE),
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null,
        Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK),
        Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK), Pawn(Color.BLACK),
        Rook(Color.BLACK), Knight(Color.BLACK), Bishop(Color.BLACK), Queen(Color.BLACK),
        King(Color.BLACK), Bishop(Color.BLACK), Knight(Color.BLACK), Rook(Color.BLACK)
    )

    val newBoardEmpty: Array<AbstractPiece?> = arrayOf<AbstractPiece?>(
        null, null, null,
        null, null, null,
        null, null, null,
        null, null, null,
        null, null, null,
        null,
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        null, null,
        null, null, null, null,
        null, null, null, null,
        null, null, null, null,
        null, null, null, null
    )

    init {
        for (a in 0 until newBoardWhite.size / 2) {
            boardReflection.put(newBoardWhite.size - a - 1, a)
            boardReflection.put(a, newBoardWhite.size - a - 1)
        }
    }
}
