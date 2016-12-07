package com.example.algorithms.random

import org.junit.Test
import kotlin.test.assertEquals

class SampleStandardDeviationTest {

    val numbers = arrayOf(2.0, 5.0, 1.0, 4.0, 8.0, 3.0, 9.0, 10.0)

    @Test
    fun deviation() {
        val sampleStandardDeviation = SampleStandardDeviation(numbers)

        assertEquals(2.9895651857753496, sampleStandardDeviation.deviation())
    }

}