package com.example.algorithms.adt

import com.example.algorithms.Item.StringHolder
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class LinkedStackTest {

    val sampleData: List<StringHolder> = build(listOf(
            "it", "was", "-", "the", "best", "-", "of",
            "times", "-", "-", "-", "it", "was", "-", "the",
            "-", "-"
    ))

    @Test
    fun `Peek return last added item without poping`() {
        val stack = LinkedStack<StringHolder>()
        stack.push(StringHolder("first"))
        stack.push(StringHolder("second"))

        assertEquals("second", stack.peek()?.get())
    }

    @Test
    fun `Pop and return the last added item`() {
        val stack = LinkedStack<StringHolder>()
        stack.push(StringHolder("test"))

        val item: StringHolder? = stack.pop()

        assertEquals("test", item?.get())
    }

    @Test
    fun `Pop and return NULL when stack is empty`() {
        val stack = LinkedStack<StringHolder>()

        val item: StringHolder? = stack.pop()

        assertNull(item)
    }

    @Test
    fun `Push to the stack and check if item is added`() {
        val stack = LinkedStack<StringHolder>()
        stack.push(StringHolder("test"))

        assertFalse(stack.isEmpty())
    }

    @Test
    fun `Pop when the given input is "-" and push when not`() {
        val stack = LinkedStack<StringHolder>()
        var result: String = ""

        sampleData.forEach { v ->
            run {
                if (v.get().equals("-")) {
                    result += stack.pop()?.get()
                } else {
                    stack.push(v)
                }
            }
        }

        assertEquals("wasbesttimesofthewastheit", result)
    }

    @Test
    fun `Get the iterator and iterate through the items in reverse order`() {
        val stack = LinkedStack<StringHolder>()
        stack.push(StringHolder("test1"))
        stack.push(StringHolder("test2"))
        stack.push(StringHolder("test3"))
        val iterator = stack.iterator()

        assertTrue(iterator.hasNext())
        assertEquals("test3", iterator.next().get())
        assertEquals("test2", iterator.next().get())
        assertEquals("test1", iterator.next().get())
    }

    private fun build(items: List<String>): List<StringHolder> {
        return items.map { i -> StringHolder(i) }
    }

}