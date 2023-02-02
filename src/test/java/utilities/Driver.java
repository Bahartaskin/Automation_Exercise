package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private Driver(){}

    private static WebDriver driver;


    public static WebDriver getDriver(){

        if(driver==null){

            String browserType = Config_Reader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new NoSuchContextException("Invalid browser type : " + browserType);
            }

        }

        return driver;

    }


    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
