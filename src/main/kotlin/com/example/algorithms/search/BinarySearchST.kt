package com.example.algorithms.search

class BinarySearchST() {

    private var values: IntArray = IntArray(1)
    private var keys: IntArray = IntArray(1)
    private var n: Int = 0

    fun size(): Int {
        return n
    }

    fun put(key: Int, value: Int) {
        val i = rank(key)
        if (i < n && key.equals(keys[i])) {
            values[i] = value
            return
        }
        if (n == keys.size) {
            resize(2 * keys.size)
        }
        var j = n
        while (j > i) {
            keys[j] = keys[j - 1]
            values[j] = values[j - 1]
            j--
        }
        keys[i] = key
        values[i] = value
        ++n
    }

    fun get(key: Int): Int? {
        val i = rank(key)
        if (i < n) {
            return values[i]
        }
        return null
    }

    fun delete(key: Int) {
        val i = rank(key)
        if (i >= n || key.compareTo(keys[i]) != 0) {
            return
        }
        var j = i
        while (j < n - 1) {
            keys[j] = keys[j + 1]
            values[j] = values[j + 1]
            j++
        }
        --n
        if (n > 0 && n == keys.size / 4 ) {
            resize(keys.size / 2)
        }
    }

    private fun rank(key: Int): Int {
        var lo = 0
        var hi = this.n - 1

        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            val cmp = key.compareTo(this.keys[mid])
            if (cmp < 0) {
                hi = mid - 1
            } else if (cmp > 0) {
                lo = mid + 1
            } else {
                return mid
            }
        }

        return lo
    }

    private fun resize(max: Int) {
        val tmpKeys: IntArray = IntArray(max)
        val tmpValues: IntArray = IntArray(max)

        for (i in 0..n - 1) {
            tmpKeys[i] = keys[i]
            tmpValues[i] = values[i]
        }
        keys = tmpKeys
        values = tmpValues
    }

}