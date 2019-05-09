package SeleniumWithJava.Framework;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

	public static void TakeScreenshot(WebDriver driver, String filepath)
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(f,"filepath.png");
	}
	
}
