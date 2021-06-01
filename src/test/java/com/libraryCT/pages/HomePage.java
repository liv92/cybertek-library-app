package com.libraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//ul[@id='menu_item']/li/a)[1]")
    public WebElement dashboard;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    public WebElement navBarDropDown;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public WebElement logOutButton;

    @FindBy(id = "user_count")
    public WebElement usersCount;

    @FindBy(linkText = "Users")
    public WebElement usersButton;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement nameOfUser;

    public void logOut(){
        navBarDropDown.click();
        logOutButton.click();
    }


}
