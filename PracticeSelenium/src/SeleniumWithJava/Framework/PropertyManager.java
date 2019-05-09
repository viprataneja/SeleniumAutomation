package SeleniumWithJava.Framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	public static String getProperty(String propertyName) throws FileNotFoundException, IOException
	{
				Properties p = new Properties();
				p.load(new FileReader("resources/config.properties"));
				return p.getProperty(propertyName);
			
	}
}
