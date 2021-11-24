package com.example.chessjokenpocom.models.Other

import java.util.*

object ArrayDimensionConverter {
    fun toOneDimension(array: Array<Array<Any>>): ArrayList<Any> {
        val temp = ArrayList<Any>()
        for (c in array.indices) {
            for (r in array.indices) {
                temp.add(array[c][r])
            }
        }
        return temp
    }

    fun toTwoDimension(array: Array<Any?>): Array<Array<Any?>> {
        var b = 0
        val temp =
            Array(8) { arrayOfNulls<Any>(8) }
        for (c in 0..7) {
            for (r in 0..7) {
                temp[c][r] = array[b]
                b++
            }
        }
        return temp
    }

    fun pieceToOneDimension(c: Int, r: Int): Int {
        var temp = 0
        for (i in 0..7) {
            for (b in 0..7) {
                if (i == c && r == b) {
                    return temp
                }
                temp++
            }
        }
        return 100
    }

    fun pieceToTwoDimension(i: Int): Position {
        var temp = 0
        for (r in 0..7) {
            for (c in 0..7) {
                if (temp == i) {
                    return Position(c, r)
                }
                temp++
            }
        }
        return Position()
    }
}