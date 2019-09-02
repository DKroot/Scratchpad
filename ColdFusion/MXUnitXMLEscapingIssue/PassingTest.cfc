component extends="mxunit.framework.TestCase" {
    /**
    * Runs once after initialization and before setUp()
    */
    void function beforeTests() {
        include "Application.cfm"; //Initialize datasources for integrated DB testing
        //Include has to be here (vs at the top of component)
    }

    /**
    * Runs once after all tests have been run
    */
    void function afterTests() {
    }

    /**
    * Runs before every single test in this test case
    */
    void function setUp() {
    }

    /**
    * Runs before every single test in this test case
    */
    void function tearDown() {
    }

    void function itShouldPass() {
        assertTrue(true);
    }
}