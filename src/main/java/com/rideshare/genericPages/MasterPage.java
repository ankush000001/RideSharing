package com.rideshare.genericPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.Reporter;

import org.testng.annotations.AfterMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MasterPage {

	public Properties readConfig = new Properties();
	public Properties readLocators = new Properties();
	public Properties readTestData = new Properties();
	public WebDriver driver;
	protected Logger log = LogManager.getLogger(MasterPage.class);

	// construction implementation
	MasterPage() throws Exception {

		FileInputStream openConfig = new FileInputStream(
				"D:\\java\\RideShare\\src\\main\\java\\com\\rideshare\\Repository\\Config.properties");
		readConfig.load(openConfig);

		FileInputStream openLocators = new FileInputStream(
				"D:\\java\\RideShare\\src\\main\\java\\com\\rideshare\\Repository\\Locators.properties");
		readLocators.load(openLocators);

		FileInputStream openTestdata = new FileInputStream(
				"D:\\java\\RideShare\\src\\main\\java\\com\\rideshare\\Repository\\TestData.properties");
		readTestData.load(openTestdata);

		System.setProperty(readConfig.getProperty("Driver"), readConfig.getProperty("Driver_path"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().window().maximize();

		driver.get(readConfig.getProperty("URL"));

	}

	public void takeScreenshot(String fileName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			new File("./Screenshots").mkdirs();
			FileUtils.copyFile(src, new File(
					"./Screenshots/" + fileName + "_" + LocalDateTime.now().toString().replace(":", "_") + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenshot(result.getMethod().getMethodName());
		}
	}

}
