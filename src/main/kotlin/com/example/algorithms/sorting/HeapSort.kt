package com.example.algorithms.sorting

class HeapSort {

    fun sort(input: Array<Int>) {
        var n = input.size
        var k = n / 2

        while (k >= 1) {
            sink(input, k, n)
            k--
        }

        while (n > 1) {
            exchange(input, 1, n--)
            sink(input, 1, n)
        }
    }

    private fun swim(input: Array<Int>, i: Int) {
        var k = i
        while (k > 1 && less(input, k / 2, k)) {
            exchange(input, k / 2, k)
            k /= 2
        }
    }

    private fun sink(input: Array<Int>, i: Int, n: Int) {
        var k = i
        while (2 * k <= n) {
            var j = 2 * k
            if (j < n && less(input, j, j + 1)) j++
            if (!less(input, k, j)) break
            exchange(input, k, j)
            k = j
        }
    }

    private fun less(input: Array<Int>, i: Int, j: Int): Boolean {
        return input[i - 1].compareTo(input[j - 1]) < 0
    }

    private fun exchange(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i - 1]
        arr[i - 1] = arr[j - 1]
        arr[j - 1] = tmp
    }

}