package test

import main.Dollar
import org.junit.Test
import kotlin.test.assertEquals

class MoneyMainKtTest {

    @Test
    fun testMultiplication() {
        var five = Dollar(5)
        five.times(2)
        assertEquals(10, five.amount)
    }

}
