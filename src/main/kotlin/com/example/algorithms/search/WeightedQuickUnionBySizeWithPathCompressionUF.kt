package com.example.algorithms.search

class WeightedQuickUnionBySizeWithPathCompressionUF(val n: Int) {

    private var count = n
    private var root = IntArray(n)
    private var size = IntArray(n, { i -> 1 })

    init {
        for (i in 0..n - 1) {
            root[i] = i
        }
    }

    fun find(i: Int): Int {
        var p = i
        while (p != root[p]) {
            root[p] = root[root[p]]
            p = root[p]
        }
        return p
    }

    fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)

        if (rootP == rootQ) return

        if (size[rootP] < size[rootQ]) {
            size[rootQ] += size[rootP]
            root[rootP] = rootQ
        } else {
            size[rootP] += size[rootQ]
            root[rootQ] = rootP
        }
        count--
    }

    fun count(): Int {
        return count
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

}
