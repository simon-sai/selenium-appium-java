package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "steps",
        "hooks/webdriverio" }, monochrome = true, plugin = {
                "pretty" }, tags = "@wip", snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TestWipRunner extends AbstractRunner {
    //
}
