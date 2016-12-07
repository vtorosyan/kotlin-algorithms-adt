package com.example.algorithms.client

import org.junit.Test
import kotlin.test.assertEquals

class InfixToPostfixTest {

    @Test
    fun `Convert infix arithmetic expression to postfix`() {
        val infixToPostfix = InfixToPostfix("3+5*7+2")

        assertEquals("357*+2+", infixToPostfix.convert())
    }

    @Test
    fun `Convert infix arithmetic expression with brackets to postfix`() {
        val infixToPostfix = InfixToPostfix("((3+4)-6/2+(4+2))")

        assertEquals("34+62/-42++", infixToPostfix.convert())
    }

}