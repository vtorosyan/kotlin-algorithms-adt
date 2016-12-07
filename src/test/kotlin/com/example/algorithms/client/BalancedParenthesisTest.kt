package com.example.algorithms.client

import org.junit.Test
import kotlin.test.assertEquals

class BalancedParenthesisTest {

    @Test
    fun `Print infix expression for given expression`() {
        val balancedParenthesis = BalancedParenthesis("1+2)*3-4)*5-6)))")

        assertEquals("((1+2)*((3-4)*(5-6)))", balancedParenthesis.print())
    }

}