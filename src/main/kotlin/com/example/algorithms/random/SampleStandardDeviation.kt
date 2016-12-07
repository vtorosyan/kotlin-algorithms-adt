package com.example.algorithms.random

class SampleStandardDeviation(val numbers: Array<Double>) {

    fun deviation(): Double {
        val n = numbers.size
        var sum = 0.0
        for (v in numbers) {
            sum += v
        }
        val average = sum / n

        sum = 0.0
        for (v in numbers) {
            val squareValueAverageDiff = (v - average) * (v - average)
            sum += squareValueAverageDiff
        }
        return Math.sqrt(sum / n - 1)
    }

}
