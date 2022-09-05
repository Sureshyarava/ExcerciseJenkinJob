package in.amazon.testrunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ProductSearch.feature"},
        glue = {"in/amazon/steps"},
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
        tags = "@AmazonFeatureTest"
)
public class TestRunner {

}