package com.example.algorithms

class Stopwatch {

    val start = System.currentTimeMillis()

    fun elapsedTime(): Double {
        val now = System.currentTimeMillis()
        return (now - start) / 1000.0
    }

}