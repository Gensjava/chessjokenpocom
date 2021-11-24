package com.example.chessjokenpocom.models.pieces


abstract class AbstractPiece(var color: Int) {
    var imageID = 0

    // TODO: Make this return a Set Collection to prevent duplication
    abstract fun getAloudMoves(position: Int?, board: Array<AbstractPiece?>?): ArrayList<Int>
}
