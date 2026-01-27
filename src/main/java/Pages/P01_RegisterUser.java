package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static Utilities.Utility.*;

public class P01_RegisterUser {

    private final WebDriver driver;

    public P01_RegisterUser(WebDriver driver){
        this.driver = driver;
    }

    private final By signUpLoginBtn = By.xpath("//a[@href=\"/login\"]");
    private final By nameInput = By.xpath("//input[@type='text']");
    private final By emailInput = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By newUserSignupLocator = By.xpath("//h2/preceding::div[@class='signup-form']");
    private final By signupBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By enterAccountInfoTextLocator = By.xpath("(//b/preceding::h2[contains(@class, 'text-center')])[1]");
    private final By title = By.id("id_gender1");
    private final By password = By.id("password");
    private final By dayLocator = By.id("days");
    private final By monthLocator = By.id("months");
    private final By yearLocator = By.id("years");
    private final By specialOffers = By.id("optin");
    private final By newsLetter = By.id("newsletter");


    public P01_RegisterUser clickOnSignupLogin(){
        clickOnElement(driver, signUpLoginBtn);
        return this;
    }


    public P01_RegisterUser enterName (){
        sendKeysToElement(driver, nameInput, new Faker().name().firstName());
        return this;
    }

    public P01_RegisterUser enterEmail (){
        sendKeysToElement(driver, emailInput, new Faker().internet().emailAddress());
        return this;
    }

    public P01_RegisterUser clickSignup(){
        clickOnElement(driver, signupBtn);
        return this;
    }

    public P01_RegisterUser selectTitle(){
        clickOnElement(driver, title);
        return this;
    }

    public P01_RegisterUser fillPassword(){
        sendKeysToElement(driver, password, new Faker().internet().password());
        return this;
    }

    public P01_RegisterUser selectDay(){
        selectFromDropdown(driver, dayLocator, String.valueOf(new Faker().number().numberBetween(1,32)));
        return this;
    }

    public P01_RegisterUser selectMonth(){

        Month month = Month.of(new Random().nextInt(12) + 1);
        String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        selectFromDropdown(driver, monthLocator, monthName);
        return this;
    }

    public P01_RegisterUser selectYear(){
        int year = ThreadLocalRandom.current().nextInt(1900, 2026);
        selectFromDropdown(driver, yearLocator, String.valueOf(year));
        return this;
    }

    public P01_RegisterUser checkReceiveSpecialOffers(){
        clickOnElement(driver, specialOffers);
        return this;
    }

    public P01_RegisterUser checkSignUpForOurNewsletter() {
        clickOnElement(driver, newsLetter);
        return this;
    }

    public boolean verifyNewUserSignupText(){
        return verifyVisibilityOfText(driver, newUserSignupLocator);
    }

    public boolean verifyEnterAccountInfoText(){
        return verifyVisibilityOfText(driver,enterAccountInfoTextLocator );
    }


}
