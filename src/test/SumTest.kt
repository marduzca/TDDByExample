package test

import main.Bank
import main.Expression
import main.Money
import main.Sum
import org.junit.Test
import kotlin.test.assertEquals

class SumTest {

    @Test
    fun testSumPlusMoney() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
        val result: Money = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(15), result)
    }

    @Test
    fun testSumTimes() {
        val fiveBucks: Expression = Money.dollar(5)
        val tenFrancs: Expression = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).times(2)
        val result: Money = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(20), result)
    }

}