package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base {
	
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	
	public LoginPage(){
		//super();
		Base base = new Base();
		//base=new LoginPage();
		//driver=new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle(){
		
		return driver.getTitle();
		
	}
	
	public void LoginIn(String un, String pass){
		email.sendKeys(un);
		password.sendKeys(pass);
		
		login.click();
	}
}


