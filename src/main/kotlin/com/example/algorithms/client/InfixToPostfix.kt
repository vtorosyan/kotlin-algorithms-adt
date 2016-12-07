package com.example.algorithms.client

import com.example.algorithms.Item.StringHolder
import com.example.algorithms.adt.LinkedStack

/**
 * Assumes gives expression is valid.
 */
class InfixToPostfix(expression: String) {
    val postfixStack = LinkedStack<StringHolder>()
    var postfixExpression = ""

    val expressionArray = expression.toCharArray()
    val operatorWeight = hashMapOf(Pair("*", 3),
            Pair("/", 3),
            Pair("+", 2),
            Pair("-", 2),
            Pair("(", 1))

    fun convert(): String? {
        for (v in expressionArray) {

            if (v.isOperand()) {
                postfixExpression += v
            } else if (v.equals('(')) {
                postfixStack.push(StringHolder(v.toString()))
            } else {
                if (v.equals(')')) {
                    var topOp: String? = postfixStack.pop()?.get()
                    while (topOp != null && !topOp.equals("(")) {
                        postfixExpression += topOp
                        topOp = postfixStack.pop()?.get()
                    }
                } else {
                    while (!postfixStack.isEmpty() && hasHigherOrEqualPrecedence(v.toString())) {
                        val operand: StringHolder? = postfixStack.pop()
                        postfixExpression += operand?.get()
                    }
                    postfixStack.push(StringHolder(v.toString()))
                }
            }

        }
        while (!postfixStack.isEmpty()) {
            postfixExpression += postfixStack.pop()?.get()
        }
        return postfixExpression
    }

    private fun hasHigherOrEqualPrecedence(v: String): Boolean {
        return operatorWeight[postfixStack.peek()?.get()] as Int >= operatorWeight[v.toString()] as Int
    }

}