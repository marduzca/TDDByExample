package test

import main.Bank
import main.Expression
import main.Money
import main.Sum
import org.junit.Assert.assertEquals
import org.junit.Test

class BankTest {

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
    fun testReduceMoneyWithDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result: Money = bank.reduce(Money.franc(2), "USD")

        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun testIdentityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

}