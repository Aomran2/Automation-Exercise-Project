package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private final static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // we do three steps with threadLocal List -> Set - get - remove

    public static void setupDriver (String browser){
        if (browser.equalsIgnoreCase("chrome"))
            driverThreadLocal.set(new ChromeDriver());
        else if (browser.equalsIgnoreCase("firefox"))
            driverThreadLocal.set(new FirefoxDriver());
         else
            driverThreadLocal.set(new EdgeDriver());
    }

    public static WebDriver getDriver (){
        return driverThreadLocal.get();
    }

    public static void closeDriver(){
        getDriver().quit();
        driverThreadLocal.remove();
    }
}

