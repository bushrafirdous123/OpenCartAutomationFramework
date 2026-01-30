package com.opencart.automation.utilities;

	import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentManager {

	    public static ExtentReports createInstance() {
	        ExtentSparkReporter reporter =
	                new ExtentSparkReporter("reports/ExtentReport.html");

	        reporter.config().setReportName("OpenCart Automation Report");
	        reporter.config().setDocumentTitle("Automation Test Results");

	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Bushra Firdous");
	        extent.setSystemInfo("Environment", "QA");

	        return extent;
	    }
	}

