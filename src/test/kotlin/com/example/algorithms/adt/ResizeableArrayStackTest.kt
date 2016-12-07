package com.example.algorithms.adt

import org.junit.Test
import kotlin.test.assertEquals

class ResizeableArrayStackTest {

    @Test
    fun `Create a stack and push and pop items`() {
        val stack = ResizeableArrayStack()
        stack.push("A")
        stack.push("B")
        stack.push("C")

        assertEquals("C", stack.pop())
        assertEquals("B", stack.pop())
        assertEquals("A", stack.pop())
    }

}