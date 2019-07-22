package main

open class Money(val amount: Int) {
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

    open fun times(multiplier: Int): Money {
        return Money(0)
    }

    open fun currency(): String {
        return ""
    }
}