package com.example.algorithms.sorting

import com.example.algorithms.deepEqualsArray
import org.junit.Test
import kotlin.test.assertTrue

class MergeSortTest {
    val unsortedArray = arrayOf(1, 9, 2, 3, 4, 6, 5, 8, 7)
    val sortedArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    var mergeSort = MergeSort()

    @Test
    fun topDownSort() {
        mergeSort.topDownSort(unsortedArray)
        assertTrue(sortedArray.deepEqualsArray(unsortedArray))
    }

    @Test
    fun bottomUpSort() {
        mergeSort.bottomUpSort(unsortedArray)
        assertTrue(sortedArray.deepEqualsArray(unsortedArray))
    }
}