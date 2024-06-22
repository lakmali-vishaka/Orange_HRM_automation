package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login to the application
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
        loginButton.click();

        // Wait for login to complete
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        // Navigate to My Info section
        WebElement infoButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']")));
        infoButton.click();

        // Wait for the My Info page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstName']")));


        // Editing first name
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstName']"));
        firstName.clear();
        firstName.sendKeys("nipunka");

        // Editing middle name
        WebElement middleName = driver.findElement(By.cssSelector("input[name='middleName']"));
        middleName.clear();
        middleName.sendKeys("udyangasaman");

        // Editing last name
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastName.clear();
        lastName.sendKeys("vijesekaranamal");

        Thread.sleep(20000);


        // Married status
        WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-select-text--active")));
        status.click();
        WebElement single = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and text()='Single']")));
        single.click();

        // Gender
        WebElement gender = driver.findElement(By.cssSelector("input[value='1']"));
        gender.click();

        // Save the changes
        WebElement saveButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        saveButton.click();

        // Verification can be added here if needed

        // Close the browser
        driver.quit();
    }
}
