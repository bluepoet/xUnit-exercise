package net.bluepoet.xunit

/**
 * Created by bluepoet on 2016. 11. 25..
 */
class TestResult {
    def runCount
    def failCount

    TestResult() {
        this.runCount = 0
        this.failCount = 0
    }

    def testStarted() {
        this.runCount += 1
    }

    def testFailed() {
        this.failCount += 1
    }

    def summary() {
        return this.runCount + ' run, ' + this.failCount+' failed'
    }
}
