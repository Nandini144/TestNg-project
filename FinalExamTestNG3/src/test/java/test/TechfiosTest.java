package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.TechfiosPage;
import util.BrowserFactory;

public class TechfiosTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();
	
	}
	
	@Test
	public void validUserShouldBeAbleToAddACategory() {
		
		driver.get("http://techfios.com/test/101/");
		
		TechfiosPage techfiosPage = PageFactory.initElements(driver, TechfiosPage.class);
		//Add category
		techfiosPage.addCategory("Testing Techfios 1000");
		
		//Validating the warning Message
		Assert.assertTrue(techfiosPage.isWarningMessageDisplayed(), "Warning Message is not Displayed ");
		
		//Click on Back Link
		techfiosPage.clickBackLink();
		
		//Click on MonthDropDown
		techfiosPage.selectMonthDropDown();
		
		//Validating the list
		Assert.assertTrue(techfiosPage.isMonthDropDownHasMonthsDispalyed(), "Months in drop down box do not match");
		
		
	}
}
