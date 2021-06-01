package com.libraryCT.step_definitions;

import com.libraryCT.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {



    @After
    public void tearDown(){
        Driver.closeDriver();
}

}
