package Tests;

import Pages.P01_RegisterUser;
import Pages.P02_AccountCreated;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Listeners.ITestListenerClass;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyData;

@Listeners(ITestListenerClass.class)
public class TC02_AccountCreated {
    private final SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void openBrowser() throws IOException {
        setupDriver(getPropertyData("Environment","browser"));
        getDriver().manage().window().maximize();
        getDriver().get(getPropertyData("Environment","homeUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void continueAndVerifyAccountCreated() throws IOException {
        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin()
                .enterName()
                .enterEmail()
                .clickSignup()
                .selectTitle()
                .fillPassword()
                .selectDay()
                .selectMonth()
                .selectYear()
                .checkSignUpForOurNewsletter()
                .checkReceiveSpecialOffers()
                .fillFirstName()
                .fillLastName()
                .fillCompany()
                .fillAddressOne()
                .fillAddressTwo()
                .selectCountry()
                .fillState()
                .fillCity()
                .fillZipCode()
                .fillMobileNumber()
                .clickCreateAccount()
                .clickContinueBtn();

        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyAccountCreatedText());
        soft.assertAll();

    }

    @Test
    public void verifyLoggedInUserName() throws IOException {

        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin()
                .enterName()
                .enterEmail()
                .clickSignup()
                .selectTitle()
                .fillPassword()
                .selectDay()
                .selectMonth()
                .selectYear()
                .checkSignUpForOurNewsletter()
                .checkReceiveSpecialOffers()
                .fillFirstName()
                .fillLastName()
                .fillCompany()
                .fillAddressOne()
                .fillAddressTwo()
                .selectCountry()
                .fillState()
                .fillCity()
                .fillZipCode()
                .fillMobileNumber()
                .clickCreateAccount()
                .clickContinueBtn();

        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyUserLoggedIn());
        soft.assertAll();
    }


    @Test
    public void deleteAccountAndVerify() throws IOException {

        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin()
                .enterName()
                .enterEmail()
                .clickSignup()
                .selectTitle()
                .fillPassword()
                .selectDay()
                .selectMonth()
                .selectYear()
                .checkSignUpForOurNewsletter()
                .checkReceiveSpecialOffers()
                .fillFirstName()
                .fillLastName()
                .fillCompany()
                .fillAddressOne()
                .fillAddressTwo()
                .selectCountry()
                .fillState()
                .fillCity()
                .fillZipCode()
                .fillMobileNumber()
                .clickCreateAccount()
                .clickContinueBtn()
                .clickDeleteAccountBtn();

        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyAccountDeletedText());
        soft.assertAll();
    }


    @Test
    public void continueAfterDeleteAccount() throws IOException {

        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin()
                .enterName()
                .enterEmail()
                .clickSignup()
                .selectTitle()
                .fillPassword()
                .selectDay()
                .selectMonth()
                .selectYear()
                .checkSignUpForOurNewsletter()
                .checkReceiveSpecialOffers()
                .fillFirstName()
                .fillLastName()
                .fillCompany()
                .fillAddressOne()
                .fillAddressTwo()
                .selectCountry()
                .fillState()
                .fillCity()
                .fillZipCode()
                .fillMobileNumber()
                .clickCreateAccount()
                .clickContinueBtn()
                .clickDeleteAccountBtn()
                .clickCloseCardBtn();

        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyAccountDeletedText());

        new P02_AccountCreated(getDriver())
                .clickContinueAfterDeleteBtn();


        soft.assertAll();
    }





    @AfterMethod
    public void tearDown(){
        closeDriver();
    }

}
