package test

import main.Bank
import main.Expression
import main.Money
import main.Sum
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyMainKtTest {

    @Test
    fun testMultiplication() {
        val five: Money = Money.dollar(5)

        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum: Expression = five.plus(five)
        val reduced: Money = Bank().reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testMixedAddition() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(fiveBucks.plus(tenFrancs), "USD")

        assertEquals(Money.dollar(10), result)
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val result: Expression = five.plus(five)
        val sum = result as Sum

        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum: Expression = Sum(Money.dollar(3), Money.dollar(4))
        val result: Money = Bank().reduce(sum, "USD")

        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        val result: Money = Bank().reduce(Money.dollar(1), "USD")

        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    @Test
    fun testReduceMoneyWithDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2), "USD")

        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)))
        assertFalse(Money.dollar(5).equals(Money.dollar(6)))
        assertFalse(Money.franc(5).equals(Money.dollar(5)))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }
}
