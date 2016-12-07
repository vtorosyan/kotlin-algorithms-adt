package com.example.algorithms.client

import com.example.algorithms.Item
import com.example.algorithms.adt.LinkedStack

/**
 * Class uses two stacks to balance given expression assuming that opening parenthesis is missing.
 * For example given "1+2)" expression it balances to "(1+2)"
 * Assumes given expression is valid.
 */
class BalancedParenthesis(expression: String) {

    private val operands = LinkedStack<Item.StringHolder>()
    private val operators = LinkedStack<Item.StringHolder>()
    private val expressionArray = expression.toCharArray()

    init {
        balance()
    }

    fun print(): String? {
        return operands.pop()?.get()
    }

    private fun balance() {
        for (v in expressionArray) {
            if (v.isOperator()) {
                operators.push(Item.StringHolder(v.toString()))
            } else if (v.isOperand()) {
                operands.push(Item.StringHolder(v.toString()))
            } else {
                val secondOperand = operands.pop()?.get()
                val firstOperand = operands.pop()?.get()
                val operator = operators.pop()?.get()

                operands.push(Item.StringHolder("($firstOperand$operator$secondOperand)"))
            }
        }
    }

}