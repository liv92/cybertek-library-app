package com.libraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//select[@aria-controls='tbl_users']")
    public WebElement recordsDropdown;

    @FindBy(xpath = "//select[@aria-controls='tbl_users']/option")
    public List<WebElement> recordOptions;

    @FindBy(xpath = "//table/thead//th")
    public List<WebElement> tableHeaders;

}
