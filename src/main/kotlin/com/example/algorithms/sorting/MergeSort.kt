package com.example.algorithms.sorting

class MergeSort {

    var aux: IntArray? = null

    fun bottomUpSort(input: Array<Int>) {
        aux = IntArray(input.size)
        var len = 1
        val n = input.size
        while (len < n) {
            var lo = 0
            while (lo < n - len) {
                val mid = lo + len - 1
                val hi = Math.min(lo + len + len - 1, n - 1)
                merge(input, lo, mid, hi)
                lo += len + len
            }
            len *= 2
        }
    }

    fun topDownSort(input: Array<Int>) {
        aux = IntArray(input.size)
        sort(input, 0, input.size - 1)
    }

    private fun sort(input: Array<Int>, lo: Int, hi: Int) {
        if (hi <= lo) return

        val mid = lo + (hi - lo) / 2

        sort(input, lo, mid)
        sort(input, mid + 1, hi)
        merge(input, lo, mid, hi)
    }

    private fun merge(input: Array<Int>, lo: Int, mid: Int, hi: Int) {
        for (i in lo..hi) {
            aux?.set(i, input[i])
        }

        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            if (i > mid) {
                input[k] = aux?.get(j++)!!
            } else if (j > hi) {
                input[k] = aux?.get(i++)!!
            } else if (aux?.get(j)!! < aux?.get(i)!!) {
                input[k] = aux?.get(j++)!!
            } else {
                input[k] = aux?.get(i++)!!
            }
        }
    }

}