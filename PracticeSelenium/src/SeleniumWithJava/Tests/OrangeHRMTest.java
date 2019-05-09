package SeleniumWithJava.Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumWithJava.Framework.BrowserManager;
import SeleniumWithJava.Framework.PropertyManager;
import SeleniumWithJava.Pages.DashboardPage;
import SeleniumWithJava.Pages.LoginPage;
import SeleniumWithJava.Pages.PIMNewEmployeePage;

public class OrangeHRMTest {
	WebDriver browser;
	String URL;
	String username;
	String password;

	public OrangeHRMTest() throws FileNotFoundException, IOException {

		try {
			URL = PropertyManager.getProperty("url");
			username = PropertyManager.getProperty("username");
			password = PropertyManager.getProperty("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void Setup() {
		browser = BrowserManager.getBrowser("Chrome");
		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		browser.get(URL);
	}

	@AfterMethod
	public void Cleanup() {
		browser.quit();
	}

	@Test
	public void Login() {

		org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(OrangeHRMTest.class);

//		//Configurator.initialize(new DefaultConfiguration()); 
//
//		logger.trace("This is a trace");
//		logger.debug("This is a debug msg");
//		logger.info("This is a info msg");
//		logger.warn("This is a warning msg");
//		logger.error("This is an error msg");
//		logger.fatal("This is a fatal msg");

		assertNotNull(browser, "Browser is null");

		LoginPage loginPage = PageFactory.initElements(browser, LoginPage.class);
		//LoginPage loginPage = new LoginPage(browser);
		browser = loginPage.Login(username, password);

		DashboardPage dashBoard = PageFactory.initElements(browser, DashboardPage.class);

		assertEquals(dashBoard.txtWelcome.getText(), "Welcome " + username);
	}

	@Test(dependsOnMethods = "Login")
	public void PIM_AddEmployee() {

		assertNotNull(browser, "Browser is null");

		// Login
		LoginPage loginPage = PageFactory.initElements(browser, LoginPage.class);
		browser = loginPage.Login(username, password);

		// assertTrue(browser.getTitle().contains(s));
		DashboardPage dashBoard =PageFactory.initElements(browser, DashboardPage.class);

		assertEquals(dashBoard.txtWelcome.getText(), "Welcome " + username);
		dashBoard.tabPIM.click();

			
		// Data
		String firstName = "John";
		String lastName = "Smith";
		String userName = "JohnSmith";

		PIMNewEmployeePage newEmpPage = PageFactory.initElements(browser, PIMNewEmployeePage.class);
		newEmpPage.AddEmployee(firstName, lastName, userName);
		assertNotNull(browser.findElement(By.id("empPic")), "Employee not added");

	}
}
