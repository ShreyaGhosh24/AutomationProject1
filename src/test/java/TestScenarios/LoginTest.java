package TestScenarios;
import utilities.DriverSetup;
import utilities.DataReadExcel;

import TestObjectRepository.LoginPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest {
	WebDriver driver;
	
  @Test(dataProvider="invalid login")
  public void testOfInvalidLogin(String username, String password) throws IOException {
	  LoginPage.userNameField(driver).sendKeys(username);
	  LoginPage.passwordField(driver).sendKeys(password);
	  //DataReadExcel.readDataExcel("/CuraHealth/Dataset/LoginCredentialsData.xlsx", "invalid", 1, 1);
	  LoginPage.loginButton(driver).click();
	  String actualText=LoginPage.errorMsg(driver).getText();
	  String expectedText="Login failed! Please ensure the username and password are valid.";
	  Assert.assertEquals(actualText,expectedText);
	  
	  
	  
  }
  @Test(dataProvider="valid login")
  public void testOfValidLogin(String username, String password) throws IOException {
	  String expectedUrl="https://katalon-demo-cura.herokuapp.com/#appointment";
	  LoginPage.userNameField(driver).sendKeys(username);
	  LoginPage.passwordField(driver).sendKeys(password);
	  LoginPage.loginButton(driver).click();
	  //DataReadExcel.readDataExcel("/CuraHealth/Dataset/LoginCredentialsData.xlsx", "invalid", 1, 1);
	  String actualUrl= driver.getCurrentUrl();
	  Assert.assertEquals(expectedUrl,actualUrl);
	  
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver= DriverSetup.setDriver("chrome");
	  driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
  }
  @DataProvider(name="invalid login")
  public Object[][] returnInvalidData() throws IOException{
	  return DataReadExcel.readDataExcel("C:\\Users\\SHREYA GHOSH\\eclipse-workspace\\CuraHealth\\Dataset\\LoginCredentialsData.xlsx", "invalid", 1, 1);
	  
  }
  @DataProvider(name="valid login")
  public Object[][] returnvalidData() throws IOException{
	  return DataReadExcel.readDataExcel("C:\\Users\\SHREYA GHOSH\\eclipse-workspace\\CuraHealth\\Dataset\\LoginCredentialsData.xlsx", "valid", 0, 1);
	  
  }
  

  @AfterTest
  public void afterTest() {
	  System.out.println("done");
	  driver.close();
  }

}
