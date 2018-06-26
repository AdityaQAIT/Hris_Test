package com.qainfotech.automation.MavenExample;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HrisTest {
	 WebDriver driver;
	Login login;
	 
	 @BeforeClass
	 public void launch() {
			System.setProperty("webdriver.chrome.driver","//home//qainfotech//Downloads//chromedriver");
			driver = new ChromeDriver();
			driver.get("https://hris.qainfotech.com/login.php");
			login = new Login(driver);
			
	 }
	 @Test
	 public void Incorrect_password_test() {

		 Assert.assertEquals("Invalid Login", login.Invalid_Password("Username", "Adi"));
	 }
	 
	
	 @Test
	 public void Blank_Password_Test() {
		 
		 Assert.assertNotEquals(null,login.Blank_Password_Field("Username",""));
	 }
	 
	 
    @Test(dependsOnMethods= {"Incorrect_password_test","Blank_Password_Test"})
	public void Correct_credientials_test() {
		Assert.assertFalse(login.Valid_Crendentials("Username","Password").isloginpage());
	}
	

}
