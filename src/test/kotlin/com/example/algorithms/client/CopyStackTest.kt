package com.example.algorithms.client

import com.example.algorithms.Item
import com.example.algorithms.adt.LinkedStack
import org.junit.Test
import kotlin.test.assertEquals

class CopyStackTest {

    @Test
    fun `Copy the stack with the same order`() {
        val stackToCopy = LinkedStack<Item.StringHolder>()
        stackToCopy.push(Item.StringHolder("3"))
        stackToCopy.push(Item.StringHolder("1"))
        stackToCopy.push(Item.StringHolder("2"))

        val expectedCopy = CopyStack(stackToCopy).copy()

        assertEquals("2", (expectedCopy.pop() as Item.StringHolder).get())
        assertEquals("1", (expectedCopy.pop() as Item.StringHolder).get())
        assertEquals("3", (expectedCopy.pop() as Item.StringHolder).get())
    }

}