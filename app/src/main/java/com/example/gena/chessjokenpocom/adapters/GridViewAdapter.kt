package com.example.chessjokenpocom.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.chessjokenpocom.customs.SquareImageView
import com.example.chessjokenpocom.models.Other.Constants


import com.example.chessjokenpocom.models.pieces.AbstractPiece
import com.example.gena.chessjokenpocom.R


@Suppress("NAME_SHADOWING")
class GridViewAdapter(
    private val context: Context,
    private val board: Array<AbstractPiece?>
) :
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    override fun getCount(): Int {
        return board.size
    }

    override fun getItem(i: Int): Any {
        return 0
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {

        val view = layoutInflater.inflate(R.layout.tile_layout, null)
        val imageView: SquareImageView = view.findViewById(R.id.piece_image)
        // Set tile background colors
        view.setBackgroundColor(Constants.newBoardColors[i])
        if (board[i] != null) {
            imageView.setImageResource(board[i]!!.imageID)
        }
        return view
    }

    init {
        layoutInflater = LayoutInflater.from(context)
    }
}