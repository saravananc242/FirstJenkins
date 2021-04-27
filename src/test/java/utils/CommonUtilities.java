package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.Scenario;
import testBase.BaseClass;

public class CommonUtilities extends BaseClass{

	public static String takeScreenshot(Scenario scenario) {
		String ScreenPath="";
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			ScreenPath=System.getProperty("user.dir") + "//Report//"
					+ scenario.getName().replace(" ", "_") +System.currentTimeMillis()+ ".png";
			File dest= new File(ScreenPath);
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ScreenPath;
	}
	
	public static String captureAlert() {
		String Result="";
		if (expWait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert=driver.switchTo().alert();
			Result=alert.getText();
			alert.accept();
		} else {
			Result="Alert is not present";
		}
		return Result;
	}
}
