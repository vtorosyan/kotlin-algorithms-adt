package com.example.algorithms.search

/**
 * Assumes the given input is valid sorted array of integers
 */
class BinarySearch(val input: Array<Int>) {

    fun rank(key: Int): Int {
        var low = 0
        var high = input.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            if (key > input[mid]) low = mid + 1
            else if (key < input[mid]) high = mid - 1
            else return mid
        }

        return -1
    }

    fun rankRecursive(key: Int): Int {
        return rankRecursive(key, 0, input.size - 1)
    }

    private fun rankRecursive(key: Int, lo: Int, hi: Int): Int {
        if (hi < lo) return -1
        val mi = lo + (hi - lo) / 2
        val cmp = key.compareTo(input[mi])
        if (cmp < 0) {
            return rankRecursive(key, lo, mi - 1)
        } else if (cmp > 0) {
            return rankRecursive(key, mi + 1, hi)
        } else {
            return mi
        }
    }

}