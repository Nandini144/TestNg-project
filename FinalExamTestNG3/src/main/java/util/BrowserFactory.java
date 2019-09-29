package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	// global, so all methods can use
	static WebDriver driver;
	
	public static WebDriver startBrowser() {
		// Set Chrome Driver Properties
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		// Create ChromeDriver object and launch chrome browser
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// return the driver to the test class
		return driver;
		
	}

}
