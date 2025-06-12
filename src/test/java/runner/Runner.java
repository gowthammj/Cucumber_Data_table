package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\luma.feature",
        glue = "steps",
        dryRun = false,
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}




)

public class Runner {
}
