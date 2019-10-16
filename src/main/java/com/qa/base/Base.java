package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;
	public static Properties properties;

	public static void setProperties() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void invokeBrowser(String browserName) throws InterruptedException {

		browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Drivers\\chromedriver_77\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
		Thread.sleep(40);

	}
	

}
