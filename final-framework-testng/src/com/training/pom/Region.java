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
import org.openqa.selenium.support.ui.Select;

public class Region {
	private WebDriver driver; 
	
	public Region(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// mouse over on properties link
	@FindBy(xpath="//*[@id='menu-posts-property']/a/div[2]")
	private WebElement propertytab;
	
	@FindBy(xpath="//*[@id='menu-posts-property']/ul/li")
	private List<WebElement> propdropdown;
	
	
	//mouse over on Region
	@FindBy(linkText="Regions")
	private WebElement regionlink;
	
	public void clickRegion() {
		Actions action = new Actions(driver);
		action.moveToElement(this.propertytab).build().perform();
		for (WebElement propdrop : propdropdown) {
			System.out.println(propdrop.getText());
		}
		action.moveToElement(this.regionlink).click().build().perform();
		//action.click();
	}
	
	@FindBy(id="tag-name")
	private WebElement regionname;
	
	public void sendRegName(String regionname) {
		this.regionname.clear();
		this.regionname.sendKeys(regionname);
	}
	
	@FindBy(id="tag-slug")
	private WebElement regionslug;
	
	public void sendRegSlug(String regionslug) {
		this.regionslug.clear();
		this.regionslug.sendKeys(regionslug);
	}
	
	@FindBy(id="parent")
	private WebElement parentchkbox;
	
	public void clickParentChk() {
		this.parentchkbox.click(); 
		Select se= new Select(parentchkbox);
		se.selectByIndex(0);
	}
	
	
	@FindBy(id="tag-description")
	private WebElement regdesc;
	
	public void sendRegDesc(String regdesc) {
		this.regdesc.clear();
		this.regdesc.sendKeys(regdesc);
	}
	
	@FindBy(id="submit")
	private WebElement addnewreg;
	
	public void clickAddNewRegion() {
		this.addnewreg.click(); 
		
		}
}
	
	
	
	
