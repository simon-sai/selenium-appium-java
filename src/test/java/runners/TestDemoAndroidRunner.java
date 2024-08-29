package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = { "steps",
        "hooks/webdriverio" }, monochrome = true, plugin = {
                "pretty" }, tags = "@demoAndroid and not @skip", snippets = CucumberOptions.SnippetType.CAMELCASE)

public class TestDemoAndroidRunner extends AbstractRunner {
    //
}
