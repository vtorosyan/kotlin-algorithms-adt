package com.example.algorithms.sorting

import com.example.algorithms.random.Shuffle

class ThreeWayQuickSort {

    fun sort(input: Array<Int>) {
        Shuffle().shuffle(input)
        sort(input, 0, input.size - 1)
    }

    private fun sort(input: Array<Int>, lo: Int, hi: Int) {
        if (hi <= lo) return

        var lt = lo
        var gt = hi
        val v = input[lo]
        var i = lo

        while (i <= gt) {
            if (input[i] < v) exchange(input, lt++, i++)
            else if (input[i] > v) exchange(input, i, gt--)
            else i++
        }

        sort(input, lo, lt - 1)
        sort(input, gt + 1, hi)
    }

    private fun exchange(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }
}