package com.example.algorithms.client

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ParenthesisTest {

    @Test
    fun `Return true when parenthesis are balanced in given expression`() {
        val parenthesis = Parenthesis("[()]{}{[()()]()}")

        assertTrue(parenthesis.isBalanced())
    }

    @Test
    fun `Return false when parenthesis are not balanced in given expression`() {
        val parenthesis = Parenthesis("[)]{}{[()()]()}")

        assertFalse(parenthesis.isBalanced())
    }

}
