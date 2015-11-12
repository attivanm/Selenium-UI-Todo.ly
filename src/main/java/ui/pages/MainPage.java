package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: ivanmorales
 * Date: 11/11/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPage extends BasePageObject{

    @FindBy(id = "ctl00_HeaderTopControl1_LinkButtonLogout")
    @CacheLookup
    WebElement LinkButtonLogout;

    public MainPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(LinkButtonLogout));
    }
    public boolean isUserNameDisplayed(){
        return LinkButtonLogout.isDisplayed();
    }
    public LoginPage logout(){
        LinkButtonLogout.click();
        return new LoginPage();
    }
}
