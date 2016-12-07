package com.example.algorithms.adt

import com.example.algorithms.Item
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LinkedBagTest {

    @Test
    fun `Add adds items to the bag`() {
        val bag = LinkedBag<Item.StringHolder>()

        bag.add(Item.StringHolder("1"))
        bag.add(Item.StringHolder("2"))
        bag.add(Item.StringHolder("3"))

        assertEquals(3, bag.size())
    }

    @Test
    fun `It is possible to iterate through the bag using iterator`() {
        val bag = LinkedBag<Item.StringHolder>()

        bag.add(Item.StringHolder("1"))
        bag.add(Item.StringHolder("2"))
        bag.add(Item.StringHolder("3"))

        val iterator = bag.iterator()

        assertTrue(iterator.hasNext())
        assertEquals("3", iterator.next().get())
    }

}