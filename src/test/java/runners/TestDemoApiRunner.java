package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "steps",
        "hooks/api" }, monochrome = true, plugin = {
                "pretty" }, tags = "@demoApi", snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TestDemoApiRunner extends AbstractRunner {
    //
}
