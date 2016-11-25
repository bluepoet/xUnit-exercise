package net.bluepoet.xunit

/**
 * Created by bluepoet on 2016. 11. 25..
 */
class TestSuite {
    List<TestCase> tests

    TestSuite() {
        this.tests = new ArrayList<TestCase>()
    }

    def add(test) {
        tests.add(test)
    }

    def run(result) {
        tests.forEach { test ->
            test.run(result)
        }
    }
}
