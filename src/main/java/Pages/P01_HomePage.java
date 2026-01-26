package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.Utility.*;

public class P01_HomePage {

    private final WebDriver driver;

    public P01_HomePage (WebDriver driver){
        this.driver = driver;
    }

    private final By signUpLoginBtn = By.xpath("//a[@href=\"/login\"]");
    private final By nameInput = By.xpath("//input[@type='text']");
    private final By emailInput = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By newUserSignupLocator = By.xpath("//h2/preceding::div[@class='signup-form']");
    private final By signupBtn = By.xpath("//button[@data-qa=\"signup-button\"]");
    private final By enterAccountInfoTextLocator = By.xpath("(//b/preceding::h2[contains(@class, 'text-center')])[1]");



    public P01_HomePage clickOnSignupLogin(){
        clickOnElement(driver, signUpLoginBtn);
        return this;
    }


    public P01_HomePage enterName (String name){
        sendKeysToElement(driver, nameInput, name);
        return this;
    }

    public P01_HomePage enterEmail (String email){
        sendKeysToElement(driver, emailInput, email);
        return this;
    }

    public P01_HomePage clickSignup(){
        clickOnElement(driver, signupBtn);
        return this;
    }

    public boolean verifyNewUserSignupText(){
        return verifyVisibilityOfText(driver, newUserSignupLocator);
    }

    public boolean verifyEnterAccountInfoText(){
        return verifyVisibilityOfText(driver,enterAccountInfoTextLocator );
    }

}
