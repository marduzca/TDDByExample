package main

data class Franc(val amount: Int) {
    fun times(multiplier: Int): Franc {
        return Franc(amount * multiplier)
    }

    fun equals(dollar: Franc): Boolean {
        return this.amount == dollar.amount
    }
}
