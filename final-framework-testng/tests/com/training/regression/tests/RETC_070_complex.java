package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Feature;
import com.training.pom.LoginPOM;
import com.training.pom.NewLaunch;
import com.training.pom.PropertyTab1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_070_complex {
	private WebDriver driver;
	private String baseUrl;
	private PropertyTab1 prop;
	private Feature feature;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		prop = new PropertyTab1(driver); 
		feature = new Feature(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
*/
	@AfterClass
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String keywordsearch, String yourname,String youremail,String yoursubject,String yourmessage) throws InterruptedException {
		prop.sendUserName("admin");
		prop.sendPassword("adminuser@12345");
		screenShot.captureScreenShot("featadmin");
		prop.clickLoginBtn(); 
		Thread.sleep(2000);
		feature.clickFeature();
		screenShot.captureScreenShot("Propertydropdown");
		feature.sendFeatName("New launches");
		feature.sendFeatSlug("launch");
		feature.sendFeatDesc("New Launches of villas, apartments, flats");
		screenShot.captureScreenShot("feat1");
		feature.clickAddNewFeature();
		feature.clickAddNew();
		prop.sendText("prestige");
		prop.sendTextArea("home town");
		feature.clickChkbox();
		screenShot.captureScreenShot("feat2");
		prop.clickPublish();
		prop.clickViewPost();
		screenShot.captureScreenShot("featviewpost");

	}

}