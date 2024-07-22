package TestObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public static WebElement userNameField(WebDriver driver) {
		WebElement userName=driver.findElement(By.id("txt-username"));
		return userName;
		
	}
	public static WebElement passwordField(WebDriver driver) {
		WebElement password=driver.findElement(By.id("txt-password"));
		return password;
		
	}
	public static WebElement errorMsg(WebDriver driver) {
		WebElement errormsg=driver.findElement(By.xpath("//p[contains(text(),'Login failed')]"));
		return errormsg;
		
	}
	public static WebElement loginButton(WebDriver driver) {
		WebElement loginButton=driver.findElement(By.id("btn-login"));
		return loginButton;
		
	}
	

}
