package com.example.algorithms.random

import org.junit.Test
import kotlin.test.assertEquals

class ThreeSumTest {

    val input: Array<Int> = arrayOf(2, 5, -7, 6, 4, -6, 9, 12)

    @Test
    fun `Three sum counts the number of integer triples which sum to zero and returns total`() {
        val threeSum = ThreeSum(input)

        val count = threeSum.count()

        assertEquals(2, count)
    }

    @Test
    fun `Three sum counts the number of integer triples which sum to zero using binary search and returns total`() {
        val threeSum = ThreeSum(input)

        val count = threeSum.countUsingBinarySearch()

        assertEquals(2, count)
    }

    @Test
    fun `Three sum counts the number of integer triples which sum to zero using hash map and returns total`() {
        val threeSum = ThreeSum(input)

        val count = threeSum.countFasterUsingHashMap()

        assertEquals(2, count)
    }

    @Test
    fun `Three sum counts the number of integer triples which sum to zero using sorting and returns total`() {
        val threeSum = ThreeSum(input)

        val count = threeSum.countFasterUsingSorting()

        assertEquals(2, count)
    }


}