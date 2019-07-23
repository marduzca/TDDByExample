package main

interface Expression {
    fun reduce(bank: Bank, to: String): Money
    fun plus(addend: Expression): Expression
}
