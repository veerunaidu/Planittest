package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//RUN
@CucumberOptions(
		features={"src/test/resources/features"},
		glue={"stepsdef"},
		monochrome=true,
		plugin={"pretty","html:target\\Result_160320211728.html"}
		)

public class runner01 extends AbstractTestNGCucumberTests
{

}
