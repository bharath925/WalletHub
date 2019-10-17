package com.wallethub.pages.FB;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.utility.Generics;
import com.wallethub.utility.ReadConfigFile;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	public Generics utility;
	public ReadConfigFile readProperty;

	
	 @FindBy(id = "email")
	 private WebElement username_txtbox;
	 
	 @FindBy(id = "pass")
	 private WebElement password_txtbox;
	 
	 @FindBy(id="loginbutton")
	 private WebElement login_btn;
	 
	 @FindBy(xpath="//a[text()='Home']")   
	 private WebElement Home;
	 
	 @FindBy(xpath="//textarea[contains(@title,'Write something')]") 
	 private WebElement createPost_EB;
	 
	 @FindBy(xpath="//span[text()='Post']")   
	 private WebElement post_BT;
	 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
		actions = new Actions(driver);
		utility=new Generics();
		readProperty=new ReadConfigFile("fbConfig.properties");
	}

	public void loginToFaceBook() {
		driver.get(readProperty.getProperty("url"));
		wait.until(ExpectedConditions.elementToBeClickable(login_btn));
		username_txtbox.sendKeys(readProperty.getProperty("username"));
		password_txtbox.sendKeys(readProperty.getProperty("password"));
		login_btn.click();
		wait.until(ExpectedConditions.visibilityOf(Home));
	}
	
	public void postNewStatus(String statusMessage) {
		utility.moveToElement(createPost_EB);
		utility.enterText(createPost_EB, statusMessage);
		utility.click(post_BT);
	}
}
