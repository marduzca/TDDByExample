package main

class Dollar(var amount: Int) {
    fun times(multiplier: Int) {
        amount = amount * multiplier
    }
}
