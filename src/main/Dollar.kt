package main

class Dollar(var amount: Int) {
    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }

    fun equals(dollar: Dollar): Boolean {
        return this.amount == dollar.amount
    }
}
