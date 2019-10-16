package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.base.Base;
import com.qa.pages.LoginPage;
	
public class LoginPageTest extends Base {
	
	Base base = new Base();
	LoginPage loginpage=new LoginPage();
	
	
	
	public LoginPageTest(){
		
		super();
	}											
	
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		setProperties();
		invokeBrowser("chrome");
	}
	
	@Test
	public void testTitle(){
		String title=loginpage.validateTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test
	public void loginTest(){
		
		loginpage.LoginIn(properties.getProperty("username"), properties.getProperty("password"));
	}

}
