package com.example.algorithms.client

fun Char.equalsOneOf(vararg elements: Char): Boolean = elements.contains(this)
fun Char.isOperand(): Boolean = this.equalsOneOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
fun Char.isOperator(): Boolean = this.equalsOneOf('+', '-', '*', '/')