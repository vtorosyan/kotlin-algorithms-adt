package com.example.algorithms.adt

import com.example.algorithms.Item

class LinkedStack<T : Item> : Iterable<T> {

    var n: Int = 0
    var first: Node<T>? = null

    fun push(item: T) {
        val previous: Node<T>? = first
        first = Node()
        first?.item = item
        first?.node = previous
        n++
    }

    fun peek(): T? {
        return first?.item;
    }

    fun pop(): T? {
        val item: T? = first?.item
        first = first?.node
        n--
        return item
    }

    fun isEmpty(): Boolean {
        return n == 0 // or linkedList?.node != null
    }

    fun size(): Int {
        return n
    }

    override fun iterator(): Iterator<T> {
        return ReverseOrderIterator()
    }

    inner class ReverseOrderIterator : Iterator<T> {

        var current: Node<T>? = first

        override fun next(): T {
            val nextVal: T? = current?.item
            current = current?.node
            return nextVal as T
        }

        override fun hasNext(): Boolean {
            return current != null
        }
    }

}