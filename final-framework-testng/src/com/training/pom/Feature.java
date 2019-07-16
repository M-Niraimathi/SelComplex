package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Feature {
	private WebDriver driver; 
	
	public Feature(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// mouse over on properties link
	@FindBy(xpath="//*[@id='menu-posts-property']/a/div[2]")
	private WebElement propertytab;
	
	@FindBy(xpath="//*[@id='menu-posts-property']/ul/li")
	private List<WebElement> propdropdown;
	
	
	
	//mouse over on feature
	@FindBy(linkText="Features")
	private WebElement featurelink;
	
	public void clickFeature() {
		Actions action = new Actions(driver);
		action.moveToElement(this.propertytab).build().perform();
		for (WebElement propdrop : propdropdown) {
			System.out.println(propdrop.getText());
		}
		//System.out.println(propertytab.getText());
		action.moveToElement(this.featurelink).click().build().perform();
		//action.click();
	}
	
	@FindBy(id="tag-name")
	private WebElement featurename;
	
	public void sendFeatName(String featurename) {
		this.featurename.clear();
		this.featurename.sendKeys(featurename);
	}
	
	@FindBy(id="tag-slug")
	private WebElement featureslug;
	
	public void sendFeatSlug(String featureslug) {
		this.featureslug.clear();
		this.featureslug.sendKeys(featureslug);
	}
	
	@FindBy(id="tag-description")
	private WebElement featuredesc;
	
	public void sendFeatDesc(String featuredesc) {
		this.featuredesc.clear();
		this.featuredesc.sendKeys(featuredesc);
	}
	
	@FindBy(id="submit")
	private WebElement addnewfeat;
	
	public void clickAddNewFeature() {
		this.addnewfeat.click(); 
	}
	
	//mouse over on addnew
		@FindBy(linkText="Add New")
		private WebElement addnew;
		
		public void clickAddNew() {
			Actions action = new Actions(driver);
			action.moveToElement(this.propertytab).build().perform();
			action.moveToElement(this.addnew).click().build().perform();
			
		}

		//pass values in add new 
			
		
		
		@FindBy(id="in-property_feature-431")
		private WebElement chkbox; 
		
		public void clickChkbox() {
			this.chkbox.click(); 
		}
		
		
		}
	
	
