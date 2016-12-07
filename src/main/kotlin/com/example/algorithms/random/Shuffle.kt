package com.example.algorithms.random

class Shuffle {

    fun shuffle(input: Array<Int>) {
        val n = input.size
        for (i in 0..n - 1) {
            val r = i + (Math.random() * (n - i)).toInt()
            val tmp = input[r]
            input[r] = input[i]
            input[i] = tmp
        }
    }

}