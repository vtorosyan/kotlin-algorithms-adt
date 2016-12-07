package com.example.algorithms.search

class SequentialSearchST {

    private var first: Node? = null
    private var n: Int = 0

    private class Node(var value: Int, var key: Int, var next: Node?)

    fun contains(key: Int):Boolean {
        return get(key) != null
    }

    fun put(key: Int, value: Int?) {
        var x: Node? = first
        if (value == null) {
            delete(key)
            return
        }
        while (x != null) {
            if (key == x.key) {
                x.value = value
                return
            }
            x = x.next
        }
        first = Node(value, key, first)
        n++
    }

    fun get(key: Int): Int? {
        var x: Node? = first
        while (x != null) {
            if (key.equals(x.key)) return x.value
            x = x.next
        }
        return null
    }

    fun delete(key: Int) {
        first = delete(first, key)
    }

    fun size(): Int {
        return n
    }

    private fun delete(x: Node?, key: Int): Node? {
        if (x == null) {
            return null
        } else if (key == x.key) {
            --n
            return x.next
        } else {
            x.next = delete(x.next, key)
            return x
        }
    }

}