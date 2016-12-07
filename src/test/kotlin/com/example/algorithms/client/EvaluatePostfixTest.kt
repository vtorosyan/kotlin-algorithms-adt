package com.example.algorithms.client

import org.junit.Test
import kotlin.test.assertEquals

class EvaluatePostfixTest {

    @Test
    fun `Evaluate given postfix expression and return result`() {
        val evaluatePostfix = EvaluatePostfix("34+62/-42++")

        assertEquals(10, evaluatePostfix.result())
    }

}