package Tests;

import Pages.P01_RegisterUser;
import Utilities.Utility;
import Listeners.ITestListenerClass;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyData;

@Listeners(ITestListenerClass.class)
public class TC01_RegisterUser {

    private final SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(getPropertyData("Environment","browser"));
        getDriver().manage().window().maximize();
        getDriver().get(getPropertyData("Environment","homeUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void validateHomePageUrl() throws IOException {

        soft.assertTrue(Utility.verifyUrl(getDriver(), getPropertyData("Environment","homeUrl")));
        soft.assertAll();
    }

    @Test(priority = 2)
    public void verifyVisibilityOfNewUserSignup(){
        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin();

        soft.assertTrue(new P01_RegisterUser(getDriver()).verifyNewUserSignupText());
        soft.assertAll();
    }

    @Test(priority = 3)
    public void newUserSignup(){
        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin()
                .enterName()
                .enterEmail()
                .clickSignup();

        soft.assertTrue(new P01_RegisterUser(getDriver()).verifyEnterAccountInfoText());
        soft.assertAll();
    }

    @Test(priority = 4)
    public void fillSignUpDetails(){

    }



    @AfterMethod
    public void tearDown(){
        closeDriver();
    }
}
