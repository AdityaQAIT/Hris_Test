package com.qainfotech.automation.MavenExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	private WebElement getUsertext() {
		return this.driver.findElement(By.id("txtUserName"));
	}
	
	private WebElement getUserPassword() {
		return this.driver.findElement(By.id("txtPassword"));
	}
	
	
	private void EnterDetails(String username, String password) {
		getUsertext().clear();
		getUsertext().sendKeys(username);
		getUserPassword().clear();
		getUserPassword().sendKeys(password);
		getUsertext().submit();
		
	}
	
	public String Invalid_Password(String username, String password) {
		EnterDetails(username, password);
		return driver.findElement(By.className("loginTxt")).getText();
	}
	
	public String Blank_Password_Field(String username,String password) {
		EnterDetails(username, password);
		
		return driver.findElement(By.id("txtPassword")).getAttribute("class");
		
	}
	
	public Timesheet Valid_Crendentials(String username, String password) {
		EnterDetails(username, password);
		return new Timesheet(driver);
	}
	
	
	

}
