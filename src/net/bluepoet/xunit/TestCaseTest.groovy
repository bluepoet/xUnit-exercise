package net.bluepoet.xunit

/**
 * Created by bluepoet on 2016. 11. 25..
 */
class TestCaseTest {
    static void main(String[] args) {
        testTemplateMethod(setUp())
        testResult(setUp())
        testFailedResult(setUp())
        testFailedResultFormatting(setUp())
        testSuite(setUp())
    }

    static def setUp() {
        return new TestResult()
    }

    static def testTemplateMethod(result) {
        def test = new WasRun("testMethod")
        test.run(result)
        assert test.log == 'setUp testMethod tearDown'
    }

    static def testResult(result) {
        def test = new WasRun("testMethod")
        test.run(result)
        assert result.summary() == '1 run, 0 failed'
    }

    static def testFailedResult(result) {
        def test = new WasRun("testBrokenMethod")
        test.run(result)
        assert result.summary() == '1 run, 1 failed'
    }

    static def testFailedResultFormatting(result) {
        result.testStarted()
        result.testFailed()
        assert result.summary() == '1 run, 1 failed'
    }

    static def testSuite(result) {
        def suite = new TestSuite()
        suite.add(new WasRun("testMethod"))
        suite.add(new WasRun("testBrokenMethod"))
        suite.run(result)
        assert result.summary() == '2 run, 1 failed'
    }
}
