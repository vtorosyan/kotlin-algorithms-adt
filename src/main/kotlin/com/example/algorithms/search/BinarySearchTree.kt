package com.example.algorithms.search

class BinarySearchTree {

    private var root: Node? = null

    class Node {
        var key: Int? = null
        var value: Int? = null
        var left: Node? = null
        var right: Node? = null
        var size: Int = 0

        constructor(key: Int?, value: Int?, size: Int) {
            this.key = key
            this.value = value
            this.size = size
        }
    }

    fun put(key: Int, value: Int) {
        root = put(root, key, value)
    }

    fun put(node: Node?, key: Int, value: Int): Node? {
        val x: Node? = node ?: return Node(key, value, 1)
        val cmp: Int = key.compareTo(x?.key!!)
        if (cmp < 0) {
            x?.left = put(node.left, key, value)
        } else if (cmp > 0) {
            x?.right = put(node.right, key, value)
        } else {
            x?.value = value
        }
        x?.size = size(x?.left) + size(x?.right) + 1
        return x
    }

    fun get(key: Int): Int? {
        return get(root, key)
    }

    fun get(node: Node?, key: Int): Int? {
        if (node == null) return null
        val cmp: Int = key.compareTo(node.key!!)
        if (cmp < 0) {
            return get(node.left, key)
        } else if (cmp > 0) {
            return get(node.right, key)
        }
        return node.value
    }

    fun size(): Int {
        return size(root)
    }

    private fun size(node: Node?): Int {
        if (node == null) return 0
        return node.size
    }

    fun delete(key: Int) {
        root = delete(root, key)
    }

    fun delete(node: Node?, key: Int): Node? {
        var x: Node? = node ?: return null
        val cmp: Int = key.compareTo(x?.key!!)
        if (cmp < 0) x?.left = delete(x?.left, key)
        else if (cmp > 0) x?.right = delete(x?.right, key)
        else {
            if (x?.left == null) return x?.right
            else if (x?.right == null) return x?.left
            val t: Node? = x
            x = min(t?.right)
            x?.right = deleteMin(t?.right)
            x?.left = t?.left
        }
        x?.size = size(x?.left) + size(x?.right) + 1
        return x
    }

    fun deleteMin() {
        if (root != null) {
            root = deleteMin(root)
        }
    }

    private fun deleteMin(node: Node?): Node? {
        val x: Node? = node
        if (x?.left == null) return x?.right
        x?.left = deleteMin(x?.left)
        x?.size = size(x?.left) + size(x?.right) + 1
        return x
    }

    fun deleteMax() {
        if (root != null) {
            root = deleteMax(root)
        }
    }

    private fun deleteMax(node: Node?): Node? {
        val x: Node? = node
        if (x?.right == null) return x?.left
        x?.right = deleteMax(x?.right)
        x?.size = size(x?.left) + size(x?.right) + 1
        return x
    }

    private fun min(node: Node?): Node? {
        val x: Node? = node
        if (x?.left == null) return x
        else return min(x?.left)
    }

    fun floor(key: Int):Int? {
        val f: Node = floor(root, key) ?: return null
        return f.key
    }

    private fun floor(n :Node?, key: Int):Node? {
        if (n == null) return null
        val cmp: Int = key.compareTo(n.key!!)
        if (cmp == 0) return n
        if (cmp < 0) {
            return floor(n.left, key)
        } else {
            val t:Node? = floor(n.right, key)
            if (t != null) return t
            else return n
        }
    }

    fun ceiling(key: Int): Int? {
        val c: Node = ceiling(root, key) ?: return null
        return c.key
    }

    private fun ceiling(n: Node?, key: Int): Node? {
        if (n == null) return null
        val cmp: Int = key.compareTo(n.key!!)
        if (cmp == 0) return n
        else if (cmp > 0) return ceiling(n.right, key)
        else {
            val c:Node? = ceiling(n.left, key)
            if (c != null) return c
            else return n
        }
    }

    fun select(k: Int): Int? {
        return select(root, k)
    }

    private fun select(n: Node?, k: Int): Int? {
        if (n == null) return null
        val s:Int = size(n.left)
        if (k == s) return n.key
        if (k < s) return select(n.left, k)
        else return select(n.right, k - s - 1)
    }

    fun rank(key: Int): Int {
        return rank(root, key)
    }

    private fun rank(n: Node?, key: Int): Int {
        if (n == null) return 0
        val cmp: Int = key.compareTo(n.key!!)
        if (cmp == 0) return size(n.left)
        else if (cmp < 0) return rank(n.left, key)
        else return 1 + size(n.left) + rank(n.right, key)
    }
}