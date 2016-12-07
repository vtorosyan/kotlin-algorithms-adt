package com.example.algorithms.sorting

class ShellSort {

    fun sort(input: Array<Int>) {
        val n = input.size
        var k = 1
        while (k <= n / 3) k = 3 * k + 1
        while (k >= 1) {
            for (i in k..n - 1) {
                var j = i
                while (j >= k && input[j] < input[j - k]) {
                    exchange(input, j, j - k)
                    j -= k
                }
            }
            k /= 3
        }
    }

    private fun exchange(arr: Array<Int>, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

}