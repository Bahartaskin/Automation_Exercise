package tests;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;
import utilities.Driver;
import utilities.SleepMethod;

public class TestCase1 extends TestBase {

    @Test
    public void testCase_1(){


        // Verify that home page is visible successfully
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(title, "Automation Exercise");

        // Click on 'Signup / Login' button
        WebElement signupLoginButton = Driver.getDriver().findElement(By.xpath("//a[@href='/login']"));
        signupLoginButton.click();

        // Verify 'New User Signup!' is visible
        WebElement newUserSignupText = Driver.getDriver().findElement(By.xpath("//div[@class='signup-form']/h2"));
        Assert.assertTrue(newUserSignupText.isDisplayed());

        // Enter name and email address
        WebElement nameInput = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailInput = Driver.getDriver().findElement(By.xpath("//input[@data-qa='signup-email']"));

        Faker faker = new Faker();
        nameInput.sendKeys(faker.name().fullName());
        emailInput.sendKeys(faker.internet().emailAddress());

        // Click 'Signup' button
        WebElement signupButton = Driver.getDriver().findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformationText = Driver.getDriver().findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInformationText.isDisplayed());

        // Fill details: Title, Name, Email, Password, Date of birth
        WebElement mrOrMrs = Driver.getDriver().findElement(By.xpath("//input[@id='id_gender2']"));
        mrOrMrs.click();

       /* These are already filled
        WebElement fullName = Driver.getDriver().findElement(By.xpath(""));
        WebElement email = Driver.getDriver().findElement(By.xpath(""));*/

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(faker.internet().password());

        WebElement dateOfBirth_Day = Driver.getDriver().findElement(By.id("days"));
        Select select1 = new Select(dateOfBirth_Day);
        select1.selectByIndex(faker.number().numberBetween(1,31));

        WebElement dateOfBirth_Month = Driver.getDriver().findElement(By.id("months"));
        Select select2 = new Select(dateOfBirth_Month);
        select2.selectByIndex(faker.number().numberBetween(1,12));

        WebElement dateOfBirth_Year = Driver.getDriver().findElement(By.id("years"));
        Select select3 = new Select(dateOfBirth_Year);
        select3.selectByIndex(faker.number().numberBetween(10,30));


        // Select checkbox 'Sign up for our newsletter!

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement newsletterCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newsletter']")));
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", newsletterCheckbox);

        //WebElement newsletterCheckbox = Driver.getDriver().findElement(By.id("newsletter"));
       // newsletterCheckbox.click();


        //Select checkbox 'Receive special offers from our partners!'


        WebElement specialOffersCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='optin']")));
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", specialOffersCheckbox);


        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = Driver.getDriver().findElement(By.id("first_name"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.id("last_name"));
        lastName.sendKeys(faker.name().lastName());

        WebElement company = Driver.getDriver().findElement(By.id("company"));
        company.sendKeys("Cydeo");

        WebElement address = Driver.getDriver().findElement(By.id("address1"));
        address.sendKeys(faker.address().streetName());

        WebElement country = Driver.getDriver().findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(faker.number().numberBetween(0,6));

        WebElement state = Driver.getDriver().findElement(By.id("state"));
        state.sendKeys(faker.address().state());

        WebElement city = Driver.getDriver().findElement(By.id("city"));
        city.sendKeys(faker.address().city());

        WebElement zipCode = Driver.getDriver().findElement(By.id("zipcode"));
        zipCode.sendKeys(faker.address().zipCode());

        WebElement mobileNumber = Driver.getDriver().findElement(By.id("mobile_number"));
        mobileNumber.sendKeys(faker.numerify("###-###-####"));

        SleepMethod.sleep(3);

        // Click 'Create Account button

        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='create-account']")));
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", createAccountButton);


        // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = Driver.getDriver().findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedText.isDisplayed());

        // Click 'Continue' button
        WebElement continueButton1 = Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton1.click();

        SleepMethod.sleep(3);

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAs = Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']"));

        SleepMethod.sleep(2);
        Assert.assertTrue(loggedInAs.isDisplayed());

        SleepMethod.sleep(2);

        // Click 'Delete Account' button
        WebElement deleteAccountButton = Driver.getDriver().findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccountButton.click();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = Driver.getDriver().findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeletedText.isDisplayed());

        WebElement continueButton2 = Driver.getDriver().findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton2.click();















    }

}
