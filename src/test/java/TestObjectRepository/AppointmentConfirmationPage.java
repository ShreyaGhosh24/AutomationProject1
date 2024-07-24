package TestObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentConfirmationPage {
	public static WebElement result_facility(WebDriver driver) {
		
		WebElement facility=driver.findElement(By.id("facility"));
		return facility;	
		
	}
public static WebElement HealthcareProgram(WebDriver driver) {
		
		WebElement facility=driver.findElement(By.id("program"));
		return facility;	
		
	}

}
