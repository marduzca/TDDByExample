package main

open class Money(val amount: Int, private val currency: String) {

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun plus(addend: Money): Money {
        return Money(this.amount + addend.amount, this.currency)
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

    override fun toString(): String {
        return "Money(amount=$amount, currency='$currency')"
    }

}