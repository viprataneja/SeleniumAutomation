package SeleniumWithJava.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMNewEmployeePage {
	WebDriver browser;
	
	@FindBy(id ="welcome")
	public WebElement txtWelcome;
	
	@FindBy(id ="menu_pim_addEmployee")
	public WebElement tabAddEmp;
	
	@FindBy(id ="firstName")
	public WebElement txtFirstName;
	
	@FindBy(id ="lastName")
	public WebElement txtLastName;
	
	@FindBy(id ="btnSave")
	public WebElement btnSave;
	
	
	public PIMNewEmployeePage(WebDriver driver) {
		browser = driver;
	}

	public void AddEmployee(String firstName, String lastName, String userName)
	{
		
		tabAddEmp.click();

		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
//		txtUserName.sendKeys(userName);
//		chkLogin.click();
		
		btnSave.click();
		
	}
}
