package com.libraryCT.pages.gopuff.snacks;

import com.libraryCT.pages.BasePage;
import com.libraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChipsPage extends BasePage {

    public static void gotoChips(){
        Driver.getDriver().get("https://gopuff.com/#snacks/chips");
    }

    @FindBy(xpath = "//a[@data-testid='gp-product-tile-13622']")
    public WebElement DoritosNachoCheese9_25oz;

    @FindBy(xpath = "//div[@data-testid='gp-add']")
    public WebElement addButton;




}
