package main

abstract class Money(val amount: Int) {
    override fun equals(any: Any?): Boolean {
        val money = any as Money
        return this.amount == money.amount && this::class.equals(money::class)
    }

    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount)
        }

        fun franc(amount: Int): Money {
            return Franc(amount)
        }
    }

    abstract fun times(multiplier: Int): Money

    abstract fun currency(): String
}