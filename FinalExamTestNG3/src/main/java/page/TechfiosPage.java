/*Test 1: Validate a user is able to add a category and
 *  once the category is added it should display.
 *  Test 2: Validate a user is not able to add a duplicated
 *   category. If it does then the following message will 
 *   display: "The category you want to add already 
 *   exists: <duplicated category name>."
 *   Test 3: Validate the month drop down has all the months 
 *   (jan, feb, mar ...) in the Due Date dropdown section.
 */



package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TechfiosPage extends BasePage {
	
     WebDriver driver;
	
	public TechfiosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element library
	@FindBy(how = How.NAME, using = "data")WebElement CategoryInputBox;
	@FindBy(how = How.XPATH, using = "//input[@value='Add']")WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//body[contains(text(),'Sorry that TODO item already exists. ')]")WebElement WarningMessage;
	//@FindBys(@FindBy(how = How.XPATH,using = "//input[@type='checkbox']"))List<WebElement> ToggleList;
	@FindBy(how = How.NAME, using = "due_month")WebElement MonthDropDown;
	@FindBy(how = How.LINK_TEXT, using ="Back")WebElement BackLink;
	@FindBys(@FindBy(how = How.XPATH, using ="//select[@name='due_month']/descendant::option"))List<WebElement> MonthList;
	
	
	//Methods
	//Method to add category
	public void addCategory(String category) {
		CategoryInputBox.click();
		CategoryInputBox.sendKeys(category);
		AddButton.click();
		
	}
	
	//Method to check if the message is displayed
	public boolean isWarningMessageDisplayed() {
		return WarningMessage.isDisplayed();
	}
	
	//Test 3
	//Method to select month drop down box
	public void selectMonthDropDown() {
		MonthDropDown.click();
	}
	
	//Method to click on Back link
	public void clickBackLink() {
		BackLink.click();
	}
	
	public boolean isMonthDropDownHasMonthsDispalyed() {
		
		Select selectMonthDropDown = new Select(MonthDropDown);
		List<WebElement> allOptions = selectMonthDropDown.getOptions();
		
		String months = "None;Jan;Feb;Mar;Apr;May;Jun;Jul;Aug;Sep;Oct;Nov;Dec";
		String[] arrMonths = months.split(";");
		
		int count =0;
		for(String str:arrMonths) {
			boolean found = false;
			for(WebElement ele:allOptions) {
				if(str.equals(ele.getText())) {
					found=true;
					count++;
					System.out.println(str+ " Month exists.");
					break;
				}
			}
		if(!found) {
			
			System.out.println(str +"Month does not exist");
			
		}
			
		}
		
		System.out.println("Count : "+ count);
		if(count<13) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	
	

}
