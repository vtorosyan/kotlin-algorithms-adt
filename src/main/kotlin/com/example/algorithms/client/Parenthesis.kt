package com.example.algorithms.client

import com.example.algorithms.Item
import com.example.algorithms.adt.LinkedStack

/**
 * Class uses stack to determine if a given string contains balanced parenthesis.
 * For example it prints true for [()]{}{[()()]()} and false for [)]
 * Assumes given expression is valid.
 */
class Parenthesis(parenthesis: String) {

    private val parenthesis = LinkedStack<ParenthesisHolder>()
    private val parenthesisArray = parenthesis.toCharArray()

    fun isBalanced(): Boolean {
        for (p in parenthesisArray) {
            if (p.equalsOneOf('(', '{', '[')) {
                parenthesis.push(ParenthesisHolder(p))
            } else if (parenthesis.pop()?.matchesWithClosing(p)?.not() ?: false) {
                return false
            }
        }

        return true
    }

    inner class ParenthesisHolder(val parenthesis: Char) : Item {

        fun matchesWithClosing(closingParenthesis: Char): Boolean {
            if (closingParenthesis == ')') {
                return get() == '('
            } else if (closingParenthesis == '}') {
                return get() == '{'
            }
            return get() == '['
        }

        fun get(): Char {
            return parenthesis
        }

    }

}