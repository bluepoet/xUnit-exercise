package net.bluepoet.xunit

/**
 * Created by bluepoet on 2016. 11. 25..
 */
class WasRun extends TestCase {
    boolean wasRun
    def wasSetUp
    def log

    WasRun(String name) {
        super(name)
    }

    def setUp() {
        this.wasSetUp = 1
        this.log = 'setUp'
    }

    def testMethod() {
        this.wasRun = true
        this.log = this.log + ' testMethod'
    }

    def testBrokenMethod() {
        throw new Exception()
    }

    def tearDown() {
        this.log = this.log + ' tearDown'
    }
}
