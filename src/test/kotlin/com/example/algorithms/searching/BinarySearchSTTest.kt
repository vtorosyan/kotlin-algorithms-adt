package com.example.algorithms.searching

import com.example.algorithms.search.BinarySearchST
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BinarySearchSTTest {
    @Test
    fun `Get returns null when key is not found`() {
        val st: BinarySearchST = BinarySearchST()

        assertNull(st.get(2))
    }

    @Test
    fun `Get returns value when key is found`() {
        val st: BinarySearchST = BinarySearchST()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        assertEquals(3, st.get(2))
    }

    @Test
    fun `Put overrides value when key already exists`() {
        val st: BinarySearchST = BinarySearchST()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        assertEquals(2, st.get(12))

        st.put(12, 32)

        assertEquals(32, st.get(12))
        assertEquals(3, st.size())
    }

    @Test
    fun `Put adds value to the symbol table`() {
        val st: BinarySearchST = BinarySearchST()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        assertEquals(2, st.get(12))
        assertEquals(3, st.size())
    }

    @Test
    fun `Delete removes key and value from the symbol table when key exists`() {
        val st: BinarySearchST = BinarySearchST()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.delete(12)

        assertNull(st.get(12))
        assertEquals(2, st.size())
    }

    @Test
    fun `Delete does nothing when key does not exist`() {
        val st: BinarySearchST = BinarySearchST()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.delete(18)
        assertEquals(3, st.size())
    }
}