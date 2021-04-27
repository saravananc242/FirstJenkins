package stepdefs;

import java.io.IOException;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import testBase.BaseClass;
import utils.CommonUtilities;

public class TestHooks extends BaseClass{
@Before
public void setUpBefore() {
	initialize();
	Reporter.assignAuthor("Saravanan");
}
@After
public void tearDown(Scenario scenario) throws IOException {
	Reporter.addScenarioLog("Report");
	if (scenario.isFailed()) {
		Reporter.addScreenCaptureFromPath(CommonUtilities.takeScreenshot(scenario));
	}
	driver.close();
}
}
