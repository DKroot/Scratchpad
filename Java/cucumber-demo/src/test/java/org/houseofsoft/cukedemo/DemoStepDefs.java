package org.houseofsoft.cukedemo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoStepDefs {
    @When("I run {string}")
    public void runThis(String param) {
        System.out.println(String.format("Good things happen for %s", param));
    }

    @Then("I should see {string}")
    public void itShouldPass(String param) {
        System.out.println(String.format("And everything is green for %s!", param));
    }
}
