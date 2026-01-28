package Listeners;


import Utilities.LogUtils;
import Utilities.Utility;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.Utility.takeScreenshot;

public class ITestListenerClass implements ITestListener {

    public void onTestFailure(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE)
                takeScreenshot(getDriver(), result.getName());
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
        }

        LogUtils.info("Test Case -> " + "(" + result.getName() + ")" + " failed");
    }



    public void onTestSkipped(ITestResult result) {

        if (result.getStatus() == ITestResult.SKIP)
            LogUtils.info("Test Case -> " + "(" + result.getName() + ")" + " skipped");
    }


    public void onTestSuccess(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            LogUtils.info("Test Case -> " + "(" + result.getName() + ")" + " passed");
        }
    }

    public void onTestStart(ITestResult result) {

        LogUtils.info("Test Case -> " + "(" + result.getName() + ")" + " started");
    }

}

