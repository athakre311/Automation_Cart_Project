package com.abby.qa.listeners;

import com.abby.qa.utils.ExtentReporter;
import com.abby.qa.utils.Utilities;
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

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import static com.abby.qa.utils.Utilities.captureScreenshot;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReporter.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
                extentTest = extentReport.createTest(result.getName());
        extentTest.log(Status.INFO, result.getName() + "started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS, result.getName() + "got successflly executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        String destinationScreenshotPath = Utilities.captureScreenshot(driver, result.getName());

        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, result.getName() + " got failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, result.getName() + " got Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
       File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
