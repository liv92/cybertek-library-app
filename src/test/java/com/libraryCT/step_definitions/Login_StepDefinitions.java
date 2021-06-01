package com.libraryCT.step_definitions;

import com.libraryCT.pages.HomePage;
import com.libraryCT.pages.LoginPage;
import com.libraryCT.pages.UsersPage;
import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Login_StepDefinitions {

     LoginPage loginPage = new LoginPage();
     HomePage homePage = new HomePage();
     UsersPage usersPage = new UsersPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.goToLogin();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Login - Library";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        String username = ConfigurationReader.getProperties("libUser");
        String password = ConfigurationReader.getProperties("libPass");
        loginPage.logIn(username,password);
        Assert.assertTrue(BrowserUtils.waitForTitle("Library",10));

    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        String username = ConfigurationReader.getProperties("studUser");
        String password = ConfigurationReader.getProperties("studPass");
        loginPage.logIn(username,password);
        Assert.assertTrue(BrowserUtils.waitForTitle("Library",10));

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        Assert.assertTrue(homePage.dashboard.isDisplayed());
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.userNameInput.sendKeys(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Then("there should be {string} users")
    public void there_should_be_users(String users) {
       Assert.assertEquals(users,homePage.usersCount.getText());
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        loginPage.logIn(username,password);
    }

    @Then("there should be {int} users")
    public void there_should_be(Integer expectedUsers) {
       Integer actual = Integer.parseInt(homePage.usersCount.getText());
       Assert.assertEquals(expectedUsers,actual);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String Users) {
        Driver.getDriver().findElement(By.linkText(Users)).click();
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        Select select = new Select(usersPage.recordsDropdown);
        Integer actual = Integer.parseInt( select.getFirstSelectedOption().getText());
        Assert.assertEquals(expected,actual);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> expected) {
        List<String> actual = BrowserUtils.getElementsText(usersPage.recordOptions);
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i),actual.get(i));
        }
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> actual) {
        List<String> expected = BrowserUtils.getElementsText(usersPage.tableHeaders);
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i),actual.get(i));
        }
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {
        Assert.assertEquals(expectedName,BrowserUtils.waitForVisibility(homePage.nameOfUser,10).getText());
    }

}
