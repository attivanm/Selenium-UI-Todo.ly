package ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ui.BasePageObject;

/**
 *
 */
public class LoginPage extends BasePageObject {
    @FindBy(xpath ="//div[contains(@class,'HPHeaderLogin')]")
    WebElement selectLogin;

    @FindBy(name = "ctl00$MainContent$LoginControl1$TextBoxEmail")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(name = "ctl00$MainContent$LoginControl1$TextBoxPassword")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(name = "ctl00$MainContent$LoginControl1$ButtonLogin")
    WebElement loginBtn;



    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(selectLogin));
    }

    private LoginPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    private LoginPage setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    private MainPage clickLoginBtnSuccessful() {
        loginBtn.click();
        return new MainPage();
    }

    public LoginPage clickLoginBtnFailed() {
        loginBtn.click();
        return this;
    }

    private void login(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    public MainPage loginSuccessful(String userName, String password) {
        SelectLogin();
        login(userName, password);
        return clickLoginBtnSuccessful();
    }
    public void SelectLogin(){
        selectLogin.click();

    }

    public LoginPage loginFailed(String userName, String password) {

        login(userName, password);
        return clickLoginBtnFailed();
    }
//    public String getErrorMessage() {
//       return loginErrorMessage.getText();
//    }
}
