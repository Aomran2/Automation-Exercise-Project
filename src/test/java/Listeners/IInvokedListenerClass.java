package Listeners;

import Utilities.LogUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.Utility.takeScreenshot;

public class IInvokedListenerClass implements IInvokedMethodListener {

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

        try{
            if (testResult.getStatus() == ITestResult.FAILURE)
                takeScreenshot(getDriver(), testResult.getName());
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
        }
    }
}