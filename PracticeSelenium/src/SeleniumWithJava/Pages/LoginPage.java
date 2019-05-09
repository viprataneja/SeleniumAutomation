package SeleniumWithJava.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver browser;
	
	@FindBy(id="txtUsername")
	public WebElement txtUserName ;
	
	@FindBy(id="txtPassword")
	public WebElement txtPassword ;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin ;
	
	public LoginPage(WebDriver driver) {
		browser = driver;
		
	}


	// Functions
	public WebDriver Login(String userName, String password)
	{
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnLogin.click();
		return browser;
	}

}
