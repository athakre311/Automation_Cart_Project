package com.abby.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart >>>>");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" onTestStart >>>>");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+" onTestSuccess >>>>");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+" onTestFailure >>>>");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName()+" onTestSkipped >>>>");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName()+" onFinish >>>>");
    }
}
