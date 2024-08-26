package hooks.webdriverio;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepStarted;

public class StepHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
    }

    private void handleTestStepStarted(TestStepStarted event) {
        // String currentStepName = event.getTestStep().getCodeLocation();
        // Log.info("handleTestStepStarted: " + currentStepName);
        // Report.log(currentStepName);
    }
}