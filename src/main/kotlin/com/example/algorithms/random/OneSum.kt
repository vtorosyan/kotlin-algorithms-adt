package com.example.algorithms.random

/**
 * Assumes the given input is valid array of integers.
 */
class OneSum(val input: Array<Int>) {

    fun count(): Int {
        var count = 0
        for (i in input) {
            if (i == 0) count++
        }
        return count
    }

}