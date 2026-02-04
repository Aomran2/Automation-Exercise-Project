package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.Utility.*;

public class P02_AccountCreated {

    WebDriver driver;

    private final By accountCreatedTextLocator = By.xpath("//b[contains(text(),'Account Created!')]");
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

    public P02_AccountCreated clickContinueBtn(){
        clickOnElement(driver, continueBtnLocator);
        return this;
    }

    public boolean verifyUserLoggedIn() {
        return verifyVisibilityOfText(driver, loggedInAsLocator);
    }

    public P02_AccountCreated clickDeleteAccountBtn(){
        clickOnElement(driver, deleteAccountBtnLocator);
        return this;
    }

    public boolean verifyAccountDeletedText(){
        return verifyVisibilityOfText(driver, accountDeletedTextLocator);
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
