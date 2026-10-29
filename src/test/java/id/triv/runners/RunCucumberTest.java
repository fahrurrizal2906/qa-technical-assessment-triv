package id.triv.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"id.triv.steps", "id.triv.hooks"}, plugin = {"pretty"}, monochrome = true)
public class RunCucumberTest {}
