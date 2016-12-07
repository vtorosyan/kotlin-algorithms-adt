package com.example.algorithms.sorting

class InsertionSort {

    fun sort(input: Array<Int>) {
        for (i in 1..input.size - 1) {
            val valueToInsert = input[i]
            var j = i

            while (j > 0 && input[j - 1] > valueToInsert) {
                input[j] = input[j - 1]
                j--
            }
            input[j] = valueToInsert
        }
    }

    fun sortWithSwap(input: Array<Int>) {
        for (i in 1..input.size - 1) {
            var j = i

            while (j > 0 && input[j - 1] > input[j]) {
                val temp: Int = input[j]
                input[j] = input[j - 1]
                input[j - 1] = temp
                j--
            }
        }
    }

}