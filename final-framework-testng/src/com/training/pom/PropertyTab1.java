package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyTab1 {
	private WebDriver driver; 
	
	public PropertyTab1(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	// click on properties tab
	@FindBy(xpath="//*[@id='menu-posts-property']/a/div[2]")
	private WebElement propertytab;
	
	
	public void clickPropertyTab() {
		this.propertytab.click(); 
	}
	
	
	//click Add New
	@FindBy(xpath="(//a[contains(text(),'Add New')])[13]")
	private WebElement addnew;
	
	
	public void clickAddNew() {
		this.addnew.click(); 
	}
	
	//pass values in add new 
	@FindBy(xpath="//*[@id='title']")
	private WebElement text; 
	
	public void sendText(String text) {
		this.text.clear(); 
		this.text.sendKeys(text); 
	}
	
	
	
	@FindBy(id="content")
	private WebElement textarea; 
	
	public void sendTextArea(String textarea) {
		this.textarea.clear();
		this.textarea.sendKeys(textarea);
	}
	
	
	@FindBy(xpath="//*[@id='publish']")
	private WebElement clkpublish; 
	
	public void clickPublish() {
		this.clkpublish.click(); 
	}
	
	@FindBy(xpath="//a[contains(text(),'View post')]")
	private WebElement viewpost;
	
	
	public void clickViewPost() throws InterruptedException {
		Thread.sleep(2000);
		this.viewpost.click(); 
	}
	
	}
