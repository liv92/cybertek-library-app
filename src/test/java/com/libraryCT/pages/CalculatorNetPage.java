package com.libraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorNetPage extends BasePage {

    @FindBy(id = "uscodreading")
    public WebElement currentOdomReading;

    @FindBy(id = "uspodreading")
    public WebElement previousOdomReading;

    @FindBy(id = "usgasputin")
    public WebElement gasTank;

    @FindBy(xpath = "(//input[@value='Calculate'])[1]")
    public WebElement calculateButton;

    @FindBy(xpath = "(//b)[1]")
    public WebElement gasMileage;

}
