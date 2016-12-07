package com.example.algorithms

interface Item {
    class StringHolder(val value: String) : Item {
        fun get(): String {
            return value
        }
    }
}