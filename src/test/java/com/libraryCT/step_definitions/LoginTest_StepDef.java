package com.libraryCT.step_definitions;

import com.libraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginTest_StepDef {

    @Given("I am on the apple home page {string}")
    public void i_am_on_the_apple_home_page(String url) {
        Driver.getDriver().get(url);
    }
    @Then("I should see {string} as my title")
    public void i_should_see_as_my_title(String title) {
        Assert.assertEquals(title,Driver.getDriver().getTitle());

    }


}
