package com.example.algorithms.adt

class ResizeableArrayStack {

    var n: Int = 0
    var array: Array<String?> = arrayOfNulls(1)

    fun pop(): String? {
        val value = array[--n]
        if (n == array.size / 4) resize(array.size / 2)
        array[n] = null
        return value
    }

    fun push(item: String) {
        if (n == array.size) resize(array.size * 2)
        array[n++] = item
    }

    fun isEmpty(): Boolean {
        return n == 0
    }

    private fun resize(maxSize: Int) {
        val tempArray: Array<String?> = arrayOfNulls(maxSize)
        for (i in 0..n - 1) {
            tempArray[i] = array[i]
        }
        array = tempArray
    }

}