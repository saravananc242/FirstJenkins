package runners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/features/", glue = { "stepdefs" }, monochrome = true, plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:Report/ExtentReport.html" }, dryRun = false)
public class TestNGRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

	}

	@Test(groups = "cucumber", description = "Runs cucumber features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider(name = "features")
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass
	public void teardown() {
		writeExtentReport();
		testNGCucumberRunner.finish();
	}

	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src//test//resources//extent-config.xml"));
		Reporter.setSystemInfo("user name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Application", "Hotel booking app");
	}
}
