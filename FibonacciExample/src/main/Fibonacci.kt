package main

class Fibonacci {
    fun calculate(n: Int): Int {
        if(n == 0) return 0
        if(n == 1) return 1

        return calculate(n-1) + calculate(n-2)
    }
}