package com.example.algorithms.sorting

class BubbleSort {

    fun sort(input: Array<Int>) {
        var swapped: Boolean = true

        while (swapped) {
            swapped = false
            for (i in 1..input.size - 1) {

                if (input[i] < input[i - 1]) {
                    val tmp: Int = input[i]
                    input[i] = input[i - 1]
                    input[i - 1] = tmp
                    swapped = true
                }
            }
        }
    }

    fun sortV2(input: Array<Int>) {
        for (i in 0..input.size -1) {
            var numberOfSwaps = 0
            for (j in 1..input.size - i - 1) {
                if (input[j] < input[j-1]) {
                    val tmp: Int = input[j]
                    input[j] = input[j - 1]
                    input[j - 1] = tmp
                    numberOfSwaps++
                }
            }
            if (numberOfSwaps == 0) break
        }
    }

}