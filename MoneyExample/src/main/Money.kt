package main

open class Money(val amount: Int, private val currency: String) : Expression {

    override fun times(multiplier: Int): Expression {
        return Money(amount * multiplier, currency)
    }

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(this.currency, to)
        return Money(amount / rate!!, to)
    }

    fun currency(): String {
        return currency
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return this.amount == money.amount && this.currency().equals(money.currency())
    }
}