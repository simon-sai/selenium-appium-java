package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = { "steps",
        "hooks/webdriverio" }, monochrome = true, plugin = {
                "pretty" }, tags = "@google", snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TestRunner extends AbstractRunner {
    //
}
