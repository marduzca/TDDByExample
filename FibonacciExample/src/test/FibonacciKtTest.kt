package test

import main.Fibonacci
import org.junit.Assert.assertEquals
import org.junit.Test

internal class FibonacciKtTest {

    private var fibonacciSolver = Fibonacci()

    @Test
    fun testFibonacci() {
        val cases = arrayOf(arrayOf(0, 0), arrayOf(1, 1), arrayOf(2, 1), arrayOf(3, 2))

        for(pair in cases) {
            assertEquals(pair[1], fibonacciSolver.calculate(pair[0]))
        }
    }
}