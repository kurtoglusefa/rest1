package it.polito.wa2.rest1

import org.junit.jupiter.api.Test

class SimpleTest {
    @Test
    fun `this method should check something relevant`(){
        // some code
        // ARRANGE
        val a = 1
        val b = 2
        // ACT
        val c = a + b
        // ASSERT
        assert(c == 3) { "Expected 3 but got $c" }
    }

}