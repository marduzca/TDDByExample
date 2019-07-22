package main

data class Dollar(val amount: Int) {
    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }

    fun equals(dollar: Dollar): Boolean {
        return this.amount == dollar.amount
    }
}
