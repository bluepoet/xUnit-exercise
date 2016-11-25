package net.bluepoet.xunit

/**
 * Created by bluepoet on 2016. 11. 25..
 */
class TestCase {
    String name

    TestCase(String name) {
        this.name = name
    }

    def setUp() {
    }

    def run(result) {
        result.testStarted()
        setUp()
        this.metaClass.methods.each { method ->
            if(method.name == this.name) {
                try {
                    method.invoke(this, null)
                }catch(Exception e) {
                    result.testFailed()
                }
            }
        }
        tearDown()
    }

    def tearDown() {
    }
}
