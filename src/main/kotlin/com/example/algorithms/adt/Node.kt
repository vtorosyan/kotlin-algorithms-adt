package com.example.algorithms.adt

import com.example.algorithms.Item

data class Node<T : Item>(var item: T?, var node: Node<T>?) {
    constructor() : this(null, null)
}