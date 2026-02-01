package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_AccountCreated {

    WebDriver driver;

    private final By accountCreatedTextLocator = By.xpath("//b[contains(text(),'Account Created!')]");

    public P02_AccountCreated(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyAccountCreatedText(){
        return driver.findElement(accountCreatedTextLocator).isDisplayed();
    }

}
