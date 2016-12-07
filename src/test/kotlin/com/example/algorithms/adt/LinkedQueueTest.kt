package com.example.algorithms.adt

import com.example.algorithms.Item
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LinkedQueueTest {

    @Test
    fun `Enqueue adds items to the queue`() {
        val queue= LinkedQueue<Item.StringHolder>()

        queue.enqueue(Item.StringHolder("1"))
        queue.enqueue(Item.StringHolder("2"))
        queue.enqueue(Item.StringHolder("3"))

        assertEquals(3, queue.size())
    }

    @Test
    fun `Dequeue give back first added items`() {
        val queue = LinkedQueue<Item.StringHolder>()

        queue.enqueue(Item.StringHolder("1"))
        queue.enqueue(Item.StringHolder("2"))
        queue.enqueue(Item.StringHolder("3"))

        assertEquals("1", queue.dequeue()?.get())
    }

    @Test
    fun `It is possible to iterate through the queue using iterator`() {
        val queue = LinkedQueue<Item.StringHolder>()

        queue.enqueue(Item.StringHolder("1"))
        queue.enqueue(Item.StringHolder("2"))
        queue.enqueue(Item.StringHolder("3"))

        val iterator = queue.iterator()

        assertTrue(iterator.hasNext())
        assertEquals("1", iterator.next().get())
        assertEquals("2", iterator.next().get())
        assertEquals("3", iterator.next().get())
    }

}