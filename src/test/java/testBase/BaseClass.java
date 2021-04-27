package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Constants;

public class BaseClass extends Constants{
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait expWait;
	public  BaseClass() {
		try {
			prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Configuration//Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	public static void initialize() {
		String browser= prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\SupportDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\SupportDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		expWait = new WebDriverWait(driver, SmallTimeout);
		driver.manage().timeouts().pageLoadTimeout(PageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ImplicitTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println(System.getProperty("user.dir")+prop.getProperty("URL"));
		driver.get("file:///"+System.getProperty("user.dir")+prop.getProperty("URL"));	

	}
}
