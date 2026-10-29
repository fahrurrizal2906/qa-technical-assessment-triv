package id.triv.hooks;

import id.triv.config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before public void setUp() { DriverFactory.startDriver(); }
    @After public void tearDown() { DriverFactory.stopDriver(); }
}
