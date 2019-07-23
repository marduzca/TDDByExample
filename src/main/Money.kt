package main

abstract class Money(val amount: Int, private val currency: String) {
    override fun equals(any: Any?): Boolean {
        val money = any as Money
        return this.amount == money.amount && this::class.equals(money::class)
    }

    abstract fun times(multiplier: Int): Money

    fun currency(): String {
        return currency
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Franc(amount, "CHF")
        }
    }
}