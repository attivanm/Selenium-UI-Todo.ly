package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverManager  {

        private static DriverManager instance= null;
        private WebDriver driver;
        private WebDriverWait wait;

        public DriverManager(){
            initialize();
        }
        public void initialize(){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver,30,1000);
        }

        public static DriverManager getInstance(){
            if(instance== null || instance.driver == null){
                instance= new DriverManager();
            }
            return instance;
        }
    public WebDriver getWebDriver(){
        return driver;
    }
    public WebDriverWait getWait(){
            return wait;
    }

}