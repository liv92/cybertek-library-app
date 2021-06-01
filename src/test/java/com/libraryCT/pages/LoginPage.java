package com.libraryCT.pages;

import com.libraryCT.utilities.ConfigurationReader;
import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    public WebElement userNameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;


    public void goToLogin(){
        String url = ConfigurationReader.getProperties("url");
        Driver.getDriver().get(url);
    }

    public void logIn(String userName, String password){
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        signInButton.click();
    }



}
