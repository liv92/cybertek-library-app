package com.libraryCT.step_definitions;

import com.libraryCT.pages.gopuff.snacks.ChipsPage;
import com.libraryCT.utilities.BrowserUtils;
import com.libraryCT.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class GoPuffPractice {

    ChipsPage chipsPage = new ChipsPage();

    @Test
    public void test_AddButton(){

        ChipsPage.gotoChips();
        BrowserUtils.waitFor(1);
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().findElement(By.xpath("//button[@id='1']")).click();
        BrowserUtils.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//button[@id='mapAddAddress']")).click();
        BrowserUtils.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/snacks']")).click();
        BrowserUtils.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//a[@href='/snacks/chips']")).click();
        BrowserUtils.waitFor(1);
        actions.moveToElement(chipsPage.DoritosNachoCheese9_25oz);
        BrowserUtils.waitFor(1);
        chipsPage.addButton.click();
        BrowserUtils.waitFor(2);

    }



}
