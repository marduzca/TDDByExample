package test

import main.WasRun
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class TestFrameworkKtTest {

    private var wasRunObject: WasRun = WasRun(-1)

    @Before
    fun setUp() {
        wasRunObject = WasRun(0)
    }

    @Test
    fun testWasRun() {
        wasRunObject.run()
        assertTrue(wasRunObject.wasRun)
    }

    @Test
    fun testSetUp() {
        wasRunObject.run()
        assertTrue(wasRunObject.wasSetUp)
    }
}