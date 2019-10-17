package com.wallethub.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generics extends Driver {
	public Actions act = new Actions(driver);
	public WebDriverWait wait = new WebDriverWait(driver, 20);

	public void click(WebElement ele) {
		waitForElement(ele);
		ele.click();
	}

	public void moveToElement(WebElement ele) {
		waitForElement(ele);
		act.moveToElement(ele).perform();
	}

	public void clearText(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
	}

	public void enterText(WebElement ele, String textToEnter) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		clearText(ele);
		ele.sendKeys(textToEnter);
	}

	public void waitForElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void hardWait(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
		}
	}
}
