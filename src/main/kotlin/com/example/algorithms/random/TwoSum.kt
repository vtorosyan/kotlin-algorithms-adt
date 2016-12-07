package com.example.algorithms.random

import com.example.algorithms.search.BinarySearch
import com.example.algorithms.sorting.InsertionSort

/**
 * Assumes the given input is valid array of integers.
 */
class TwoSum(val input: Array<Int>) {

    fun count(): Int {
        var count = 0
        val n = input.size
        for (i in 0..n - 1) {
            for (j in i + 1..n - 1) {
                if (input[i] + input[j] == 0) count++
            }
        }
        return count
    }

    fun countFasterUsingHashMap(): Int {
        val map: MutableMap<Int, Int> = mutableMapOf()
        val n = input.size
        var count = 0

        for (i in 0..n - 1) {
            val v = input[i]
            if (map.containsKey(-v)) count++
            else map[v] = v
        }

        return count
    }

    fun countFasterUsingSorting(): Int {
        var count = 0
        InsertionSort().sort(input)
        val sortedInput = input.clone()

        var left = 0
        var right = sortedInput.size - 1

        while (left != right) {
            if (sortedInput[left] + sortedInput[right] > 0) {
                right--
            } else if (sortedInput[left] + sortedInput[right] < 0) {
                left++
            } else {
                count++
                right--
            }
        }
        return count
    }

    fun countFasterUsingBinarySearch(): Int {
        // The only available custom implementation of sorting algorithm at this moment :)
        InsertionSort().sort(input)
        val sortedInput = input.clone()
        val binarySearch = BinarySearch(sortedInput)
        val n = input.size
        var count = 0

        for (i in 0..n - 1) {
            val k: Int = binarySearch.rank(-sortedInput[i])
            if (k > i) count++
        }
        return count
    }

}