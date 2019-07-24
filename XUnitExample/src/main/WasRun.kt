package main

class WasRun(private val methodIndex: Int, var wasSetUp: Boolean = false) : TestCase() {

    init {
        assignSetUp { setUp() }
        when (methodIndex) {
            0 -> assignMethod { testMethod() }
            else -> "Do nothing"
        }
    }

    var wasRun: Boolean = false

    fun testMethod() {
        this.wasRun = true
    }

    fun setUp() {
        this.wasRun = false
        this.wasSetUp = true
    }
}