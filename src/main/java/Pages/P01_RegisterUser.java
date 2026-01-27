package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By day = By.id("days");
    private final By month = By.id("months");
    private final By year = By.id("years");


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

    

    public boolean verifyNewUserSignupText(){
        return verifyVisibilityOfText(driver, newUserSignupLocator);
    }

    public boolean verifyEnterAccountInfoText(){
        return verifyVisibilityOfText(driver,enterAccountInfoTextLocator );
    }

}
