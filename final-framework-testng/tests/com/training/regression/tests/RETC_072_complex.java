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
import com.training.pom.LoginPOM;
import com.training.pom.NewLaunch;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_072_complex {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private NewLaunch newlaunch;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		newlaunch = new NewLaunch(driver); 
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
		newlaunch.ClickNewLaunch1(); 
		newlaunch.sendkeywordsearch(keywordsearch);
		newlaunch.ClickSearch();
		newlaunch.clickSearchProperties();
		newlaunch.sendSearchPropertie(properties.getProperty("Apartmentsearchbox")); 
		newlaunch.clickSearchResult();
		String parentWindow = driver.getWindowHandle();
		List<String> windowHandles= new ArrayList(driver.getWindowHandles());
		System.out.println(windowHandles.size());
		String lastwindow=null;
		for(int i=0; i<windowHandles.size(); i++)
		{
			lastwindow=windowHandles.get(i).toString();
			
			System.out.println(lastwindow);
		}
		driver.switchTo().window(lastwindow);
		Thread.sleep(5000);
		newlaunch.sendyourname(yourname);
		newlaunch.sendyouremail(youremail);
		newlaunch.sendyoursubject(yoursubject);
		newlaunch.sendyourmessage(yourmessage);
		newlaunch.clickSendbutton();
		screenShot.captureScreenShot("First");
		

	}

}