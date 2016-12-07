package com.example.algorithms.adt

import com.example.algorithms.Item

class LinkedQueue<T : Item> : Iterable<T> {

    var n: Int = 0
    var first: Node<T>? = null
    var last: Node<T>? = null

    fun enqueue(item: T) {
        val oldLast: Node<T>? = last
        last = Node<T>()
        last?.item = item
        last?.node = null

        if (isEmpty()) first = last
        else oldLast?.node = last
        n++
    }

    fun dequeue(): T? {
        val oldFirst: Node<T>? = first
        first = first?.node
        if (isEmpty()) last = null
        return oldFirst?.item
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    fun size(): Int {
        return n
    }

    override fun iterator(): Iterator<T> {
        return QueueIterator()
    }

    inner class QueueIterator : Iterator<T> {

        var current: Node<T>? = first

        override fun next(): T {
            val item: T? = current?.item
            current = current?.node
            return item as T
        }

        override fun hasNext(): Boolean {
            return current != null
        }
    }

}