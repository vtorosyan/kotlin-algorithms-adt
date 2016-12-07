package com.example.algorithms.random

import org.junit.Test
import kotlin.test.assertEquals

class OneSumTest {
    val input = arrayOf(2, 0, 2, 3, 0, 4, 0, 5)

    @Test
    fun `One sum counts the number of integers which sum to zero and returns total`() {
        val oneSum = OneSum(input)

        val count = oneSum.count()

        assertEquals(3, count)
    }
}