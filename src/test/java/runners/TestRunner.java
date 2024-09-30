package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "steps",
        "hooks/webdriverio" }, monochrome = true, plugin = {
                "pretty" }, tags = "not @skip", snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TestRunner extends AbstractRunner {
    //
}
