package com.libraryCT.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

    plugin = {"html:target/default-html-reports.html",
                "json:target/cucumber-json.json",
                "rerun:target/rerun.txt" },
    features = "src/test/resources/features",
    glue = "com/libraryCT/step_definitions",
    dryRun = false,
    tags = "@regression"

)
public class CukesRunner {
}
