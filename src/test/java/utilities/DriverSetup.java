package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static WebDriver setDriver(String browserType) {
		if(browserType.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		if(browserType.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		return driver;
		
	}
}
