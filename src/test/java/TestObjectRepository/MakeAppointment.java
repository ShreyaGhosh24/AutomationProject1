package TestObjectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeAppointment {
	public static Select facility(WebDriver driver) {
		//Select selectFacility = null; 
		
		WebElement facility=driver.findElement(By.name("facility"));
		Select selectFacility =new Select(facility);
		
		
		
		return selectFacility;
		
		
		
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
	public static WebElement checkBox(WebDriver driver) {
		WebElement checkBox=driver.findElement(By.id("chk_hospotal_readmission"));
		return checkBox;
		
	}
	public static WebElement medicareRadio(WebDriver driver) {
		WebElement medicareRadio=driver.findElement(By.id("radio_program_medicare"));
		return medicareRadio;
		
	}
	public static WebElement medicaidRadio(WebDriver driver) {
		WebElement medicaidRadio=driver.findElement(By.id("radio_program_medicaid"));
		return medicaidRadio;
		
	}
	public static WebElement NoneRadio(WebDriver driver) {
		WebElement noneRadio=driver.findElement(By.id("radio_program_none"));
		return noneRadio;
		
	}
	public static WebElement calendar(WebDriver driver,String day) {
		WebElement calendar=driver.findElement(By.id("txt_visit_date"));
		calendar.click();
		new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='day' and text()="+day+"]")));
		
		WebElement dayToClick= driver.findElement(By.xpath("//td[@class='day' and text()="+day+"]"));
		//td[@class='day' and text()='12']
		return dayToClick;
		
		
	}
	public static WebElement comment(WebDriver driver) {
		WebElement comment=driver.findElement(By.id("txt_comment"));
		return comment;
		
	}
	public static WebElement bookAppointmentBtn(WebDriver driver) {
		WebElement bookAppointmentBtn=driver.findElement(By.id("btn-book-appointment"));
		return bookAppointmentBtn;
		
	}

}
