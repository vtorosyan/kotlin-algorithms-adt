package com.example.algorithms.client

import com.example.algorithms.Item.StringHolder
import com.example.algorithms.adt.LinkedStack

/**
 * Assumes given expression is valid.
 */
class EvaluatePostfix(expression: String) {

    val operands = LinkedStack<StringHolder>()
    val expressionArray = expression.toCharArray()

    fun result(): Int {
        for (v in expressionArray) {
            if (v.isOperand()) {
                operands.push(StringHolder(v.toString()))
            } else {
                val second: Int? = operands.pop()?.get()?.toInt()
                val first: Int? = operands.pop()?.get()?.toInt()
                var result = 0
                when (v) {
                    '*' -> result = first.evaluate(second, Int::times)
                    '+' -> result = first.evaluate(second, Int::plus)
                    '-' -> result = first.evaluate(second, Int::minus)
                    '/' -> result = first.evaluate(second, Int::div)
                }
                operands.push(StringHolder(result.toString()))
            }
        }
        return operands.pop()?.get()?.toInt() ?: 0
    }

    fun Int?.evaluate(second: Int?, op: Int.(Int) -> Int): Int = (this ?: 0).op(second ?: 0)

}