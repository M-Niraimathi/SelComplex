package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Featreg {
	private WebDriver driver; 
	
	public Featreg(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="in-region-57")
	private WebElement chkregbox; 
	
	public void clickRegChkbox() {
		this.chkregbox.click(); 
	}
	
		}
	
	
