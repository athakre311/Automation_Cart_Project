package com.abby.qa.listeners;

import com.abby.qa.utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
    String testName;

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReporter.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO, testName + "started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.PASS, testName + "got successflly executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testName = result.getName();
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + testName + ".png";

        try {
            FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName + " got failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testName = result.getName();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName + " got Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReport.flush();
    }
}
