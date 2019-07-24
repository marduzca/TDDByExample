package main

abstract class TestCase() {

    private var currentTestMethod: (() -> Unit)? = null
    private var setupMethod: (() -> Unit)? = null

    fun assignSetUp(setUp: () -> Unit) {
        setupMethod = setUp
    }

    fun assignMethod(testMethod: () -> Unit) {
        currentTestMethod = testMethod
    }

    fun run() {
        setupMethod?.let { it() }
        currentTestMethod?.let { it() }
    }
}