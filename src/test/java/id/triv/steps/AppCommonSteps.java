package id.triv.steps;

import id.triv.config.DriverFactory;
import io.cucumber.java.en.Given;

public class AppCommonSteps {
    @Given("the TRIV app is launched")
    public void theTrivAppIsLaunched() {
        if (DriverFactory.getDriver() == null) throw new IllegalStateException("Appium driver was not initialized.");
        // Driver session is created in Hooks. Configure the real app package/activity first.
    }
}
