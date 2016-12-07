package com.example.algorithms.searching

import com.example.algorithms.search.BinarySearchTree
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class BinarySearchTreeTest {

    @Test
    fun `Get returns null when key is not found`() {
        val st: BinarySearchTree = BinarySearchTree()

        assertNull(st.get(2))
    }

    @Test
    fun `Get returns value when key is found`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        assertEquals(3, st.get(2))
    }

    @Test
    fun `Put overrides value when key already exists`() {
        val st: BinarySearchTree = BinarySearchTree()
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
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        assertEquals(2, st.get(12))
        assertEquals(3, st.size())
    }

    @Test
    fun `Delete removes key and value from the symbol table when key exists`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.delete(12)

        assertNull(st.get(12))
        assertEquals(2, st.size())
    }

    @Test
    fun `Delete does nothing when key does not exist`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.delete(18)
        assertEquals(3, st.size())
    }

    @Test
    fun `Delete min removes the minimum key for given tree`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.deleteMin()

        assertNull(st.get(2))
        assertEquals(2, st.size())
    }

    @Test
    fun `Delete max removes the maximum key for given tree`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        st.deleteMax()

        assertNull(st.get(12))
        assertEquals(2, st.size())
    }

    @Test
    fun `Select returns a key with given rank`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        val k:Int? = st.select(2)
        assertEquals(12, k)
    }

    @Test
    fun `Select returns null when key with given rank does not exist`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        val k:Int? = st.select(3)
        assertNull(k)
    }

    @Test
    fun `Rank returns number of keys less than given key`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        val k:Int? = st.rank(8)
        assertEquals(1, k)
    }

    @Test
    fun `Rank returns null when BST is empty`() {
        val st: BinarySearchTree = BinarySearchTree()

        val k:Int? = st.rank(90)
        assertEquals(0, k)
    }

    @Test
    fun `Floor returns a key smaller or equal to given key`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        val k:Int? = st.floor(14)
        assertEquals(12, k)
    }

    @Test
    fun `Ceiling returns a key greater or equal to given key`() {
        val st: BinarySearchTree = BinarySearchTree()
        st.put(8, 9)
        st.put(12, 2)
        st.put(2, 3)

        val k:Int? = st.ceiling(10)
        assertEquals(12, k)
    }
}