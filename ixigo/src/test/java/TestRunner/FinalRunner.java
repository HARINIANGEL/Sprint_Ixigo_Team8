package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features= {"src/test/java/featurefile/ixigo.feature"},
glue="stepdefinition",
dryRun=false)
public class FinalRunner extends AbstractTestNGCucumberTests {

}
