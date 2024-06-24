package basic;

import org.openqa.selenium.InvalidElementStateException;
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
        firstName.sendKeys("rrq");

        // Editing middle name
        WebElement middleName = driver.findElement(By.cssSelector("input[name='middleName']"));
        middleName.clear();
        middleName.sendKeys("nwarrasa");

        // Editing last name
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastName']"));
        lastName.clear();
        lastName.sendKeys("viqmberrrga");

        Thread.sleep(20000);

        // Locate the status element
        WebElement statusElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i")));
        statusElement.click();

        // Click married
        WebElement married = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]")));
        married.click();

        // Gender
        WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label/span")));
        gender.click();

        // Attachments
        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/button")));
        add.click();


/*
        // Browse and upload the file

        WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-file-button")));
        fileInput.sendKeys("C:\\Users\\visha\\OneDrive\\Desktop\\Orange_HRM_Automation\\src\\basic\\file.png");

*/

        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]")));
        save.click();



        // Save the changes
        WebElement saveButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
        saveButton.click();

        // Close the browser
        driver.quit();
    }
}
