package main

interface Expression {
    fun reduce(to: String): Money
}
