package TestScenarios;

import org.testng.annotations.Test;

import TestObjectRepository.AppointmentConfirmationPage;
import TestObjectRepository.LoginPage;
import TestObjectRepository.MakeAppointment;
import junit.framework.Assert;
import utilities.DriverSetup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.Select;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MakeAppointPageTest {
	WebDriver driver;
  /*@Test
  public void checkForCorrectOptionsInFacilityDropdown() {
	  //String[] validOptions= {"Tokyo CURA Healthcare Center","Hongkong CURA Healthcare Center","Seoul CURA Healthcare Center"};
	  Set<String> validOptions = new HashSet();
      Collections.addAll(validOptions, "Tokyo CURA Healthcare Center", "Hongkong CURA Healthcare Center", "Seoul CURA Healthcare Center");
	  Select facilityDropdown=MakeAppointment.facility(driver);
	  List<WebElement> options=facilityDropdown.getOptions();
	  Set<String> actualOptions = new HashSet();
	  for(WebElement i:options) {
		  actualOptions.add(i.getText());
		  
	  }
	  Assert.assertEquals(validOptions, actualOptions);
	  
}*/
  @Test
  public void bookAppointment() throws InterruptedException {
	  String day="12";
	  String facility="Hongkong CURA Healthcare Center";
	  String program="Medicaid";
	 
	  
	  Select dropdown=MakeAppointment.facility(driver);
	  
	  dropdown.selectByVisibleText(facility);
	  
	  MakeAppointment.checkBox(driver).click();
	  
	  MakeAppointment.medicaidRadio(driver).click();
	  
	  MakeAppointment.comment(driver).sendKeys("abcdefg");
	  
	  MakeAppointment.calendar(driver, day).click();
	  
	  MakeAppointment.bookAppointmentBtn(driver).click();
	  
	  String expectedURL="https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
	  
	  String actualURL=driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL, actualURL);
	  
	  WebElement resultant_facility=AppointmentConfirmationPage.result_facility(driver);
	  Assert.assertEquals(resultant_facility.getText(), facility);
	  
	  Assert.assertEquals(program,AppointmentConfirmationPage.HealthcareProgram(driver).getText());
	  
	  
	  
	 
	  
}
  @BeforeClass
  public void beforeClass() {
	  driver= DriverSetup.setDriver("chrome");
	  driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
	  LoginPage.userNameField(driver).sendKeys("John Doe");
	  LoginPage.passwordField(driver).sendKeys("ThisIsNotAPassword");
	  LoginPage.loginButton(driver).click();
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
