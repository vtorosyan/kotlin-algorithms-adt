package com.example.algorithms.random

import com.example.algorithms.search.BinarySearch
import com.example.algorithms.sorting.InsertionSort

/**
 * Assumes the given input is valid array of integers.
 */
class ThreeSum(val input: Array<Int>) {

    fun count(): Int {
        val n = input.size
        var count = 0
        for (i in 0..n - 1) {
            for (j in i + 1..n - 1) {
                for (k in j + 1..n - 1) {
                    if (input[i] + input[j] + input[k] == 0) {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun countFasterUsingSorting(): Int {
        // The only available custom implementation of sorting algorithm at this moment :)
        InsertionSort().sort(input)
        val sortedArray = input.clone()
        val n = sortedArray.size
        var count = 0

        for (left in 0..n - 2) {
            var right = n - 1
            var i = left + 1
            while (i <= right) {
                val sum = sortedArray[left] + sortedArray[right]
                if (sum + sortedArray[i] == 0) {
                    count++
                    i++
                } else if (sum + sortedArray[i] < 0) {
                    i++
                } else {
                    right--
                }
            }
        }
        return count
    }

    fun countFasterUsingHashMap(): Int {
        val n = input.size
        val map: MutableMap<Int, Int> = mutableMapOf()
        var count = 0
        for (i in 0..n - 1) {
            map.clear()
            for (j in i + 1..n - 1) {
                if (map.containsKey(input[j])) count++
                else map[-(input[i] + input[j])] = input[i]
            }
        }

        return count
    }

    fun countUsingBinarySearch(): Int {
        // The only available custom implementation of sorting algorithm at this moment :)
        InsertionSort().sort(input)
        val sortedArray = input.clone()
        val binarySearch = BinarySearch(sortedArray)
        val n = sortedArray.size
        var count = 0

        for (i in 0..n - 1) {
            for (j in i + 1..n - 1) {
                val k: Int = binarySearch.rank(-(sortedArray[i] + sortedArray[j]))
                if (k > j) count++
            }
        }
        return count
    }

}