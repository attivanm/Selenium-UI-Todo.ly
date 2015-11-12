package ui;

//import framework.CredentialsManager;
import framework.DriverManager;
//import framework.selenium.DriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
//import ui.admin.pages.LoginTSAdminPage;
//import ui.monitor.ApplicationsPage;
import ui.pages.LoginPage;
//import ui.web.pages.LoginTSWebPage;

//import static framework.selenium.UIMethods.isElementDisplayed;

/**
 * Created by silvia valencia on 4/14/2015.
 */
public class PageTransporter {
    private WebDriver driver = DriverManager.getInstance().getWebDriver();
    private String baseLoginURL = "http://todo.ly";
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public LoginPage navigateToLoginPage() {
        goToURL(baseLoginURL);
        return new LoginPage();
    }
}
