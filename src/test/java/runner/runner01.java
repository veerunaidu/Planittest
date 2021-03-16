package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//RUN
@CucumberOptions(
		features={"src/test/resources/features"},
		glue={"stepsdef"},
		monochrome=true,
		plugin={"pretty","html:target\\Result_16032021.html"}
		)

public class runner01 extends AbstractTestNGCucumberTests
{

}
