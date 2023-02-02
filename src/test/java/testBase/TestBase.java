package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://automationexercise.com");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown(){
        Driver.getDriver().close();
    }

}
