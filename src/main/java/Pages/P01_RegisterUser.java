package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Utilities.DataUtils.getPropertyData;
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
    private final By fName = By.id("first_name");
    private final By lName = By.id("last_name");
    private final By company = By.id("company");
    private final By addressOne = By.id("address1");
    private final By addressTwo = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipCode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountBtn = By.xpath("//button[@data-qa=\"create-account\"]");



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

    //TODO: to create method in utility class to generate random day of month
    public P01_RegisterUser selectDay(){
        selectFromDropdown(driver, dayLocator, generateDayOfMonth());
        return this;
    }

    //TODO: to create method in utility class to generate random month
    public P01_RegisterUser selectMonth(){
        selectFromDropdown(driver, monthLocator, generateMonth());
        return this;
    }

    //TODO: to create method in utility class to generate random year
    public P01_RegisterUser selectYear(){
        selectFromDropdown(driver, yearLocator, generateYear());
        return this;
    }

    public P01_RegisterUser checkReceiveSpecialOffers(){
        clickOnElement(driver, specialOffers);
        return this;
    }

    public P01_RegisterUser checkSignUpForOurNewsletter() {
        scrollToElement(driver, newsLetter);
        clickOnElement(driver, newsLetter);
        return this;
    }

    public P01_RegisterUser fillFirstName(){
        sendKeysToElement(driver, fName, new Faker().name().firstName());
        return this;
    }

    public P01_RegisterUser fillLastName(){
        sendKeysToElement(driver, lName, new Faker().name().lastName());
        return this;
    }

    public P01_RegisterUser fillCompany(){
        sendKeysToElement(driver, company, new Faker().company().name());
        return this;
    }

    public P01_RegisterUser fillAddressOne(){
        sendKeysToElement(driver, addressOne, new Faker().address().streetAddress());
        return this;
    }

    public P01_RegisterUser fillAddressTwo(){
        sendKeysToElement(driver, addressTwo, new Faker().address().fullAddress());
        return this;
    }

    public P01_RegisterUser selectCountry() throws IOException {

        sendKeysToElement(driver, country, getPropertyData("Environment","country"));
        return this;
    }

    public P01_RegisterUser fillState(){
        sendKeysToElement(driver, state, new Faker().address().state());
        return this;
    }

    public P01_RegisterUser fillCity(){
        sendKeysToElement(driver, city, new Faker().address().city());
        return this;
    }

    public P01_RegisterUser fillZipCode(){
        sendKeysToElement(driver, zipCode, new Faker().address().zipCode());
        return this;
    }

    public P01_RegisterUser fillMobileNumber(){
        sendKeysToElement(driver, mobileNumber, new Faker().phoneNumber().cellPhone());
        return this;
    }

    public P02_AccountCreated clickCreateAccount() {
        clickOnElement(driver, createAccountBtn);
        return new P02_AccountCreated(driver);
    }

    public boolean verifyNewUserSignupText(){
        return verifyVisibilityOfText(driver, newUserSignupLocator);
    }

    public boolean verifyEnterAccountInfoText(){
        return verifyVisibilityOfText(driver,enterAccountInfoTextLocator );
    }



}
