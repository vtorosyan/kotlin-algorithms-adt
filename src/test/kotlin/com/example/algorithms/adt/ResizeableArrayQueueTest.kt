package com.example.algorithms.adt

import org.junit.Test
import kotlin.test.assertEquals

class ResizeableArrayQueueTest {

    @Test
    fun `Create a queue and enqueue and dequeue items`() {
        val queue = ResizeableArrayQueue()
        queue.enqueue("A")
        queue.enqueue("B")
        queue.enqueue("C")

        assertEquals("A", queue.dequeue())
        assertEquals("B", queue.dequeue())
        assertEquals("C", queue.dequeue())
    }
}