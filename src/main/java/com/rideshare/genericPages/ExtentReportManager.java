package com.rideshare.genericPages;

import java.time.LocalDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports extent;

	public static ExtentReports getReportObject() {

		String time = LocalDateTime.now().toString().replace(":", "-");

		String path = System.getProperty("user.dir") + "/extentReports/ExtentReport_" + time + ".html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("RideShare Automation Report");
		reporter.config().setDocumentTitle("RideShare Test Results");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Project", "RideShare");
		extent.setSystemInfo("QA Analyst", "Ankush");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Chrome Version", "150");
		return extent;
	}
}