package com.libraryCT.step_definitions;

import com.libraryCT.utilities.BrowserUtils;
import org.junit.Test;

public class FindBrokenLinks {

    @Test
    public void findBrokenLinks() {

        BrowserUtils.findBrokenLinks("https://www.apple.com/");

    }

}
