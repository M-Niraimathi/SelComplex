package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePwd;
import com.training.pom.Feature;
import com.training.pom.LoginPOM;
import com.training.pom.PropertyTab1;
import com.training.pom.Region;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_45 {

	private WebDriver driver;
	private String baseUrl;
	private PropertyTab1 prop;
	private Feature feature;
	private Region reg;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		prop = new PropertyTab1(driver); 
		feature = new Feature(driver);
		reg=new Region(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		prop.sendUserName("admin");
		prop.sendPassword("adminuser@12345");
		screenShot.captureScreenShot("Property");
		prop.clickLoginBtn(); 
		Thread.sleep(2000);
		reg.clickRegion();
		screenShot.captureScreenShot("region");
		reg.sendRegName("Electronic city");
		reg.sendRegSlug("Electronic city");
		reg.clickParentChk();
		screenShot.captureScreenShot("parentchkbox");
		reg.sendRegDesc("New Launches of villas, apartments, flats");
		screenShot.captureScreenShot("regscr");
		reg.clickAddNewRegion();
		feature.clickAddNew();
		prop.sendText("prestige");
		prop.sendTextArea("home town");
		feature.clickChkbox();
		screenShot.captureScreenShot("addnewscr");
		Thread.sleep(2000);
		prop.clickPublish();
		screenShot.captureScreenShot("publish");
		prop.clickViewPost();
		screenShot.captureScreenShot("viewpost");
		
	}
	
	
	}
	
