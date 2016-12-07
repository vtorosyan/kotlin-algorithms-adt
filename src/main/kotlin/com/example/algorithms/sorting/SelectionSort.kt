package com.example.algorithms.sorting

class SelectionSort() {

    fun sort(input: Array<Int>) {
        val n = input.size

        for (i in 0..n - 1) {
            var min = i
            for (j in i + 1..n - 1) {
                if (input[j] < input[min]) min = j
            }
            exchange(input, i, min)
        }
    }

    private fun exchange(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

}