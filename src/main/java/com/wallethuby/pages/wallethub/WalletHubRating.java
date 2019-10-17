package com.wallethuby.pages.wallethub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.utility.Generics;
import com.wallethub.utility.ReadConfigFile;

public class WalletHubRating {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	public Generics utility;
	public ReadConfigFile readProperty;

	public WalletHubRating(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
		actions = new Actions(driver);
		utility = new Generics();
		readProperty = new ReadConfigFile("wbConfig.properties");
	}

	@FindBy(xpath = "//h3/following-sibling::review-star//*[@class='rvs-star-svg'][4]")
	private WebElement fourStarRating;

	@FindBy(xpath = "//div[@class='dropdown second']")
	private WebElement selectInsurance_DD;

	@FindBy(xpath = "//li[text()='Health Insurance']")
	private WebElement healthInsurance_LK;

	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement submit_EB;

	@FindBy(xpath = "//textarea[@class='textarea wrev-user-input validate']")
	private WebElement writeReview_EB;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login_TAB;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddress_EB;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password_EB;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement login_BT;

	@FindBy(xpath = "//div[div[span[text()=' Your Review']]]/following-sibling::div[2]")
	private WebElement myReview_DT;

	public WebElement getMyreviewElement() {
		return myReview_DT;
	}

	public void writeReview(String review) {
		driver.get(readProperty.getProperty("url"));
		wait.until(ExpectedConditions.elementToBeClickable(fourStarRating));
		utility.moveToElement(fourStarRating);
		utility.hardWait(2); // hardcoded wait just to see the mousehover over 4 star
		utility.click(fourStarRating);
		;
		utility.click(selectInsurance_DD);
		utility.click(healthInsurance_LK);
		utility.enterText(writeReview_EB, review);
		utility.click(submit_EB);
		loginToApp();
	}

	public void loginToApp() {
		wait.until(ExpectedConditions.elementToBeClickable(login_TAB));
		utility.click(login_TAB);
		utility.enterText(emailAddress_EB, readProperty.getProperty("email"));
		utility.enterText(password_EB, readProperty.getProperty("password"));
		utility.click(login_BT);
		wait.until(ExpectedConditions.visibilityOf(myReview_DT));

	}

}
