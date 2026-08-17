package com.rideshare.genericPages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonMethods extends MasterPage {

	protected CommonMethods() throws Exception {
		super();

	}

	// click on Elements
	public void clickOn(String elementKey) {
		WebElement ClickonElement = driver.findElement(By.xpath(readLocators.getProperty(elementKey)));
		ClickonElement.click();
	}

	// enterData in Element
	public void enterData(String elementKey, String testData) {
		WebElement enterInput = driver.findElement(By.xpath(readLocators.getProperty(elementKey)));
		enterInput.sendKeys(readTestData.getProperty(testData));
	}

	// getText of Elements
	public void getText(String elementKey) {

		String TextofElement = driver.findElement(By.xpath(readLocators.getProperty(elementKey))).getText();
		System.out.println(TextofElement);
	}

	// move to element
	public void movetoElement(String elementKey) {

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(readLocators.getProperty(elementKey)))).build().perform();

	}

	// getText and verify text
	public void getTextAndVerify(String elementKey, String testData) {
		String ActualTextofElement = driver.findElement(By.xpath(readLocators.getProperty(elementKey))).getText();
		String ExpectedTextofElement = readTestData.getProperty(testData);
		Assert.assertEquals(ActualTextofElement, ExpectedTextofElement);
		System.out.println("ActualText:- " + ActualTextofElement + " || " + "ExpectedText:- " + ExpectedTextofElement);
	}

	// Click on list of web Element
	public void listofWebElements(String elementKey, String testData) {

		List<WebElement> listofElements = driver.findElements(By.xpath(readLocators.getProperty(elementKey)));
		for (WebElement listofElement : listofElements) {

			if (listofElement.getText().equalsIgnoreCase(readTestData.getProperty(testData))) {
				listofElement.click();
			}
		}

	}

	// clear webelement
	public void clearelementData(String elementKey) {
		WebElement clearData = driver.findElement(By.xpath(readLocators.getProperty(elementKey)));
		clearData.clear();
	}

	// select dropdown
	public void selectDropdown(String elementKey, String testData) {
		WebElement dropdownElement = driver.findElement(By.xpath(readLocators.getProperty(elementKey)));
		Select selectValue = new Select(dropdownElement);
		selectValue.selectByVisibleText(readTestData.getProperty(testData));

	}

	// handle explicity wait
	public void explicitlyWait(String elementKey) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(15));
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(readLocators.getProperty(elementKey)))).click();

	}

	public void handleLogger(String logClassName, String loggerText) {

		Logger log = (Logger) LogManager.getLogger(logClassName);

		log.info(loggerText);

	}

}
