package com.example.algorithms.adt

import com.example.algorithms.Item

class LinkedBag<T : Item> : Iterable<T> {

    var n: Int = 0
    var first: Node<T>? = null

    fun isEmpty(): Boolean {
        return first == null
    }

    fun add(item: T) {
        val previous: Node<T>? = first
        first = Node()
        first?.item = item
        first?.node = previous
        n++
    }

    fun size(): Int {
        return n
    }

    override fun iterator(): Iterator<T> {
        return LinkedBagIterator()
    }

    inner class LinkedBagIterator : Iterator<T> {

        var current: Node<T>? = first

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            val item: T? = current?.item
            current = current?.node
            return item as T
        }
    }
}