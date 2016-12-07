package com.example.algorithms.search

class QuickUnionUF(val n: Int) {

    private var count = n
    private var arr = IntArray(n)

    init {
        for (i in 0..n - 1) {
            arr[i] = i
        }
    }

    fun find(i: Int): Int {
        var p = i
        while (p != arr[p]) {
            p = arr[p]
        }
        return p
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun count(): Int {
        return count
    }

    fun union(p: Int, q: Int) {
        val pVal = find(p)
        val qVal = find(q)

        if (pVal == qVal) return
        arr[pVal] = qVal
        count--
    }

}