package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNationality {
    public static void main(String[] args)  {
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

        // Navigate to Admin section
        WebElement adminButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']")));
        adminButton.click();

        // Wait for Admin page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[5]/a")));

        // Navigate to Nationalities
        WebElement nationalityButton = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[5]/a"));
        nationalityButton.click();

        // Wait for Nationalities page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary")));

        // Click on the Add button
        WebElement addButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary"));
        addButton.click();

        // Wait for Add Nationality form to appear
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
        nameField.sendKeys("Nimal");

        // Save the new nationality
        WebElement saveButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        saveButton.click();

        // Wait for the action to complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Successfully Saved')]")));




        // Close the browser
        driver.quit();
    }
}
