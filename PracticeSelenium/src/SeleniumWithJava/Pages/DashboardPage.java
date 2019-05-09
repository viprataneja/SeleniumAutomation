package SeleniumWithJava.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	WebDriver browser;

	@FindBy(id = "welcome")
	public WebElement txtWelcome;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement tabPIM;

	public DashboardPage(WebDriver driver) {
		browser = driver;
	}

}
