package com.example.algorithms.random

import org.junit.Test
import kotlin.test.assertEquals

class TwoSumTest {
    val input: Array<Int> = arrayOf(2, 9, -2, 3, 4, -3, 0, 5)

    @Test
    fun `Two sum counts the number of integer pairs which sum to zero and returns total`() {
        val twoSum = TwoSum(input)

        val count = twoSum.count()

        assertEquals(2, count)
    }

    @Test
    fun `Two sum counts the number of integer pairs which sum to zero by sorting an array and returns total`() {
        val twoSum = TwoSum(input)

        val count = twoSum.countFasterUsingSorting()

        assertEquals(2, count)
    }

    @Test
    fun `Two sum counts the number of integer pairs which sum to zero in linear way and returns total`() {
        val twoSum = TwoSum(input)

        val count = twoSum.countFasterUsingHashMap()

        assertEquals(2, count)
    }

    @Test
    fun `Two sum counts the number of integer pairs which sum to zero using binary search and returns total`() {
        val twoSum = TwoSum(input)

        val count = twoSum.countFasterUsingBinarySearch()

        assertEquals(2, count)
    }


}