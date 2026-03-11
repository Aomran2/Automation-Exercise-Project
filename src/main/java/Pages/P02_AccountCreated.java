package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.LogUtils.info;
import static Utilities.Utility.*;

public class P02_AccountCreated {

    WebDriver driver;

    private final By accountCreatedTextLocator = By.xpath("//b[contains(text(), 'Account Created!')]");
    private final By continueBtnLocator = By.xpath("//a[@data-qa=\"continue-button\"]");
    private final By loggedInAsLocator = By.xpath("//a[contains(text(), 'Logged in as')]");
    private final By deleteAccountBtnLocator = By.xpath("//a[contains(text(), 'Delete Account')]");
    private final By accountDeletedTextLocator = By.xpath("//b[contains(text(),'Account Deleted!')]");
    private final By continueAfterDeleteBtnLocator = By.xpath("//a[@data-qa='continue-button']");

    public P02_AccountCreated(WebDriver driver){
        this.driver = driver;
    }

    public boolean verifyAccountCreatedText(){
        return verifyVisibilityOfText(driver, accountCreatedTextLocator);
    }

    public String accountCreatedText(){
        return getText(driver, accountCreatedTextLocator);
    }


    public P02_AccountCreated clickContinueBtn(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(continueBtnLocator));
            clickOnElement(driver, continueBtnLocator);
        } catch (TimeoutException e) {
            info("Continue button not found, taking screenshot for debugging");
            takeScreenshot(driver, "ContinueBtnNotFound");
            throw e;
        }
        return this;
    }

    public boolean verifyUserLoggedIn() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(loggedInAsLocator))
                    .isDisplayed();
        } catch (TimeoutException e) {
            info("User logged in element not found");
            takeScreenshot(driver, "UserLoggedInNotFound");
            return false;
        }
    }

    public P02_AccountCreated clickDeleteAccountBtn(){
        clickOnElement(driver, deleteAccountBtnLocator);
        return this;
    }

    public boolean verifyAccountDeletedText(){
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(accountDeletedTextLocator))
                    .isDisplayed();
        } catch (TimeoutException e) {
            info("Account deleted element not found");
            takeScreenshot(driver, "AccountDeletedNotFound");
            return false;
        }
    }

    public P02_AccountCreated clickContinueAfterDeleteBtn(){
        clickOnElement(driver, continueAfterDeleteBtnLocator);
        return this;
    }

//    public P02_AccountCreated clickCloseCardBtn(){
//        generalWait(driver)
//                .until(ExpectedConditions
//                .elementToBeClickable(closeCardBtnLocator)).click();
//
////        ((JavascriptExecutor) driver).executeScript(
////                "document.body.innerHTML.includes('Create Custom Apps Using AI') && " +
////                        "Array.from(document.querySelectorAll('div')).forEach(e => {" +
////                        "if(e.innerText.includes('Create Custom Apps Using AI')) e.remove();});"
////        );
//
//        return this;
//    }

}
