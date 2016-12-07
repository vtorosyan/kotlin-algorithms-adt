package com.example.algorithms.searching

import com.example.algorithms.search.BinarySearch
import org.junit.Test
import kotlin.test.assertEquals

class BinarySearchTest {

    private val input: Array<Int> = arrayOf(15, 25, 31, 44, 55, 68, 778, 887, 9000, 10014)

    @Test
    fun `Binary search gives back found index for a given key`() {
        val binarySearch = BinarySearch(input)

        val rank: Int = binarySearch.rank(9000)

        assertEquals(8, rank)
    }

    @Test
    fun `Binary search returns -1 if the key is not found`() {
        val binarySearch = BinarySearch(input)

        val rank: Int = binarySearch.rank(29)

        assertEquals(-1, rank)
    }

    @Test
    fun `Recursive binary search gives back found index for a given key`() {
        val binarySearch = BinarySearch(input)

        val rank: Int = binarySearch.rankRecursive(9000)

        assertEquals(8, rank)
    }

    @Test
    fun `Recursive binary search returns -1 if the key is not found`() {
        val binarySearch = BinarySearch(input)

        val rank: Int = binarySearch.rankRecursive(29)

        assertEquals(-1, rank)
    }

}