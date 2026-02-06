package Tests;

import Pages.P01_RegisterUser;
import Pages.P02_AccountCreated;
import Utilities.Utility;
import Listeners.ITestListenerClass;
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
        //below code is to get the browser name from system property if it is set, otherwise it will get it from the properties file
        // this allows us to run the test with different browsers without changing the code, we can set the browser name in the command line when running the test with maven, for example: mvn test -Dbrowser=chrome
        //condition ? true : false
        String browser = System.getProperty("browser") != null? System.getProperty("browser") : getPropertyData("Environment","browser");
        setupDriver(browser);
//        setupDriver(getPropertyData("Environment","browser"));
        getDriver().manage().window().maximize();
        getDriver().get(getPropertyData("Environment","homeUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void registerNewUser() throws IOException {

        soft.assertTrue(Utility.verifyUrl(getDriver(), getPropertyData("Environment","homeUrl")));

        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin();

        soft.assertTrue(new P01_RegisterUser(getDriver()).verifyNewUserSignupText());

        new P01_RegisterUser(getDriver())
                .clickOnSignupLogin().enterName().enterEmail()
                .clickSignup();

        soft.assertTrue(new P01_RegisterUser(getDriver()).verifyEnterAccountInfoText());

        new P01_RegisterUser(getDriver())
                .selectTitle().fillPassword()
                .selectDay().selectMonth()
                .selectYear().checkSignUpForOurNewsletter()
                .checkReceiveSpecialOffers().fillFirstName()
                .fillLastName().fillCompany().fillAddressOne()
                .fillAddressTwo().selectCountry().fillState()
                .fillCity().fillZipCode().fillMobileNumber()
                .clickCreateAccount()
                .clickContinueBtn();
        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyAccountCreatedText());

        getDriver().navigate().refresh();

        new P02_AccountCreated(getDriver())
                .clickContinueBtn();

        soft.assertTrue(new P02_AccountCreated(getDriver()).verifyUserLoggedIn());

        new P02_AccountCreated(getDriver())
                .clickDeleteAccountBtn();
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
