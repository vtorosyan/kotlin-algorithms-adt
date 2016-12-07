package com.example.algorithms.search

class QuickFindUF(val n: Int) {

    private var count = n
    private var arr = IntArray(n)

    init {
        for (i in 0..n - 1) {
            arr[i] = i
        }
    }

    fun find(i: Int): Int? {
        return arr[i]
    }

    fun union(p: Int, q: Int) {
        val pVal = find(p)
        val qVal = find(q)

        if (pVal == qVal) return

        for (i in 0..n - 1) {
            if (arr[i] == pVal) {
                arr[p] = q
            }
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