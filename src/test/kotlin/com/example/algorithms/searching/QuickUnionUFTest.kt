package com.example.algorithms.searching

import com.example.algorithms.search.QuickUnionUF
import com.example.algorithms.search.WeightedQuickUnionBySizeWithPathCompressionUF
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class QuickUnionUFTest {

    private val n = 7
    private val input = mapOf(Pair(1, 2), Pair(3, 4), Pair(5, 6))

    @Test
    fun `Union operation connects two pairs if they are not connected`() {
        val uf = WeightedQuickUnionBySizeWithPathCompressionUF(9)

        uf.union(2, 3)
        uf.union(3, 4)

        assertTrue(uf.connected(2, 4))
    }

    @Test
    fun `Quick union find returns correct number of components for a given pairs`() {
        val uf = QuickUnionUF(n)

        for ((key, value) in input) {
            if (uf.connected(key, value)) continue
            uf.union(key, value)
        }

        assertEquals(4, uf.count())
    }

}