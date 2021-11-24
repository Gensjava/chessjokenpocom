package com.example.chessjokenpocom.models.Other

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import com.example.chessjokenpocom.adapters.GridViewAdapter
import com.example.chessjokenpocom.models.pieces.AbstractPiece
import com.example.chessjokenpocom.models.pieces.King
import java.util.*


class Match(
    private val context: Context?,
    private val gridView: GridView,
    private val textView: TextView
) {
    private var adapter: GridViewAdapter
    private var board: Array<AbstractPiece?> = arrayOf<AbstractPiece?>()
    var onItemClickTile: OnItemClickTile? = null
    private var colorsTurn = Color.WHITE

    fun move(idFrom: Int, idTo: Int) {
        val pieceOnTile: AbstractPiece? = board[idFrom]
        board[idTo] = pieceOnTile
        board[idFrom] = null
        if (board[idTo] != null && board[idTo]!!.javaClass.kotlin === King::class.java) {
            if (board[idTo]!!.color === Color.WHITE && textView.text === "") {
                textView.text = "BLACK WINS"
            } else if (board[idTo]!!.color === Color.BLACK && textView.text === "") {
                textView.text = "WHITE WINS"
            }
        }
        if (colorsTurn == Color.WHITE) {
            colorsTurn = Color.BLACK
        } else {
            colorsTurn = Color.WHITE
        }
        adapter.notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickTile) {
        onItemClickTile = onItemClickListener
    }

    interface OnItemClickTile {
        fun onMove(idFromPosition: Int, idToPosition: Int, namePiece: String)

        fun moveSumAnotherGamer(colorsTurn: Int)
    }

    fun start() {
        gridView.onItemClickListener = object : AdapterView.OnItemClickListener {
            private var isFirstClick = true
            private var clickedTile = 99
            private var pieceOnTile: AbstractPiece? = null
            var aloudMoves: ArrayList<Int>? = ArrayList()

            override fun onItemClick(
                adapterView: AdapterView<*>,
                view: View,
                i: Int,
                l: Long
            ) { //Highlighting the tile on first click

                if (isFirstClick) {
                    view.setBackgroundColor(Color.CYAN)
                    clickedTile = i
                    pieceOnTile = board[i]
                    isFirstClick = !isFirstClick
                    //TODO: Show available moves
                    try {
                        aloudMoves = board[i]!!.getAloudMoves(i, board)
                        for (b in aloudMoves!!.indices) {
                            if (aloudMoves!![b] != 100) {
                                adapterView.getChildAt(aloudMoves!![b])
                                    .setBackgroundColor(Color.YELLOW)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }             // Move is registered
                else if (pieceOnTile != null && colorsTurn == pieceOnTile!!.color && aloudMoves!!.contains(
                        i
                    )
                ) {

                    adapterView.getChildAt(clickedTile)
                        .setBackgroundColor(Constants.newBoardColors[clickedTile])

                    if (board[i] != null && board[i]!!.javaClass.kotlin === King::class.java) {
                        if (board[i]!!.color === Color.WHITE && textView.text === "") {
                            textView.text = "BLACK WINS"
                        } else if (board[i]!!.color === Color.BLACK && textView.text === "") {
                            textView.text = "WHITE WINS"
                        }
                    }

                    onItemClickTile!!.onMove(clickedTile, i, pieceOnTile!!.javaClass.simpleName)
                    board[i] = pieceOnTile
                    board[clickedTile] = null
                    isFirstClick = true
                    clickedTile = 99
                    pieceOnTile = null

                    colorsTurn = if (colorsTurn == Color.WHITE) {
                        Color.BLACK
                    } else {
                        Color.WHITE
                    }

                    aloudMoves = null
                    adapter.notifyDataSetChanged()
                    gridView.adapter = adapter

                } else {
                    adapter.notifyDataSetChanged()
                    gridView.adapter = adapter
                    isFirstClick = true
                    clickedTile = 99
                    pieceOnTile = null
                }
            }
        }
    }

    fun switchColor(color: Int) {
        if (color == Color.WHITE) {
            board = Constants.newBoardWhite
        } else {
            board = Constants.newBoardBlack
        }
        adapter = context?.let { GridViewAdapter(it, board) }!!
        gridView.adapter = adapter
    }

    init {
        board = Constants.newBoardEmpty
        adapter = context?.let { GridViewAdapter(it, board) }!!
        gridView.adapter = adapter
    }
}
/*try {
           for (a in 0 until board.size / 2) {
               System.out.println(a)
               val temp = board[a]
               board[a] = board[board.size - a - 1]
               board[board.size - a - 1] = temp
           }
       } catch (e: ClassCastException) {
           System.out.println(e)
       }*/