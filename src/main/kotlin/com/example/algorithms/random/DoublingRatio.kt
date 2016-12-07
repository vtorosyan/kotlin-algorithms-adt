package com.example.algorithms.random

import com.example.algorithms.Stopwatch
import edu.princeton.cs.algs4.StdOut
import edu.princeton.cs.algs4.StdRandom

class DoublingRatio {

    val MAXIMUM_INTEGER = 10000

    fun timeTrial(n: Int): Double {
        val a = IntArray(n, {i -> 2})

        for (i in 0..n - 1) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER)
        }

        val timer = Stopwatch()
        ThreeSum(a.toTypedArray()).count()

        return timer.elapsedTime()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val doublingRatio = DoublingRatio()

            var prev = doublingRatio.timeTrial(125)
            var n = 250
            while (true) {
                val time = doublingRatio.timeTrial(n)
                StdOut.printf("%6d %7.1f %5.1f\n", n, time, time / prev)
                prev = time
                n += n
            }
        }
    }

}