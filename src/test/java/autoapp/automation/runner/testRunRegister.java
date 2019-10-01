package autoapp.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                    features = {"src/test/java/autoapp/automation/features/SummerDressCart.feature"},
                    glue = {"autoapp/automation/stepDef", "autoapp/automation/utility"},
                    plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"}
                )
public class testRunRegister {
}