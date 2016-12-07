package com.example.algorithms.adt

class ResizeableArrayQueue {
    private var array: Array<String?> = arrayOfNulls(1)
    private var n: Int = 0

    fun enqueue(item: String) {
        val arraySize: Int = array.size
        if (n == arraySize) {
            resize(arraySize * 2)
        }
        array[n++] = item
    }

    fun dequeue(): String? {
        val arraySize: Int = array.size
        val item: String? = array[arraySize - (n + 1)]
        array[arraySize - (n + 1)] = null
        if (n > 0 && n == arraySize / 4) resize(arraySize / 2)
        n--
        return item
    }

    fun size(): Int {
        return n
    }

    fun resize(maxSize: Int) {
        val copyArray: Array<String?> = arrayOfNulls(maxSize)
        for (i in 0..n - 1) {
            copyArray[i] = array[i]
        }
        array = copyArray
    }

}