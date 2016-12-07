package com.example.algorithms.client

import com.example.algorithms.Item
import com.example.algorithms.adt.LinkedStack

class CopyStack<T : Item>(val stackToCopy: LinkedStack<T>) : Iterable<Item> {

    var stack = LinkedStack<Item>()
    var backedArray: Array<Item?> = Array(stackToCopy.size(), { i -> null })

    fun copy(): LinkedStack<Item> {
        val iterator = stackToCopy.iterator()

        for ((i, v) in iterator.withIndex()) {
            backedArray[i] = v
        }
        val n: Int = backedArray.size
        for (i in 1..n) {
            stack.push(backedArray[n - i] as Item)
        }

        return stack
    }

    override fun iterator(): Iterator<Item> {
        return stack.iterator()
    }

}