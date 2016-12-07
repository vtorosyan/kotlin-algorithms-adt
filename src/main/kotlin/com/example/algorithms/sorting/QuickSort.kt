package com.example.algorithms.sorting

import com.example.algorithms.random.Shuffle

class QuickSort {

    fun sort(input: Array<Int>) {
        Shuffle().shuffle(input)
        sort(input, 0, input.size - 1)
    }

    private fun sort(input: Array<Int>, lo: Int, hi: Int) {
        if (hi <= lo) return

        val p = partition(input, lo, hi)

        sort(input, lo, p - 1)
        sort(input, p + 1, hi)
    }

    private fun partition(input: Array<Int>, lo: Int, hi: Int): Int {

        var i = lo
        var j = hi + 1
        val v = input[lo]

        while (true) {
            while (input[++i] < v) if (i == hi) break
            while (input[--j] > v) if (j == lo) break

            if (i >= j) break
            exchange(input, i, j)
        }

        exchange(input, lo, j)
        return j
    }

    private fun exchange(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

}