package SeleniumWithJava.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BrowserManager {
	
	public static WebDriver getBrowser(String browserName)
	{
		WebDriver driver = null;
		switch(browserName.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "internet explorer":
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
		case "default":
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

}
