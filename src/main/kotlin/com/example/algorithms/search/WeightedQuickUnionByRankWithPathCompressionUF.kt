package com.example.algorithms.search

class WeightedQuickUnionByRankWithPathCompressionUF(val n: Int) {

    private var count = n
    private var root = IntArray(n)
    private var rank = IntArray(n)

    init {
        for (i in 0..n - 1) {
            root[i] = i
        }
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)

        if (rootP == rootQ) return

        if (rootP < rootQ) {
            root[rootP] = rootQ
        } else if (rootP > rootQ) {
            root[rootQ] = rootP
        } else {
            rank[rootP] += 1
            root[rootP] = rootQ
        }
        count--
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun count(): Int {
        return count
    }

    fun find(i: Int): Int {
        var p = i
        while (p != root[p]) {
            root[p] = root[root[p]]
            p = root[p]
        }
        return p
    }
}