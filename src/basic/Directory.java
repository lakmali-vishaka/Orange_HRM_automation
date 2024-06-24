package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Directory {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(40000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        //login to application
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
        loginButton.click();

        // Wait for login to complete
        wait.until(ExpectedConditions.urlContains("/dashboard"));

        // Navigate to My Info section
        WebElement DirectoryButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.oxd-main-menu-item[href='/web/index.php/directory/viewDirectory']")));
        DirectoryButton.click();

        //search name
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")));
        name.sendKeys("Peter Mac Anderson ");

       //select job title button
        WebElement job= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-select-text-input")));
        job.click();


        //select job title from drop down
        WebElement dropdown= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")));
        dropdown.click();




        //select location button
        WebElement location= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")));
        location.click();


        //choose location from drop down
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).click();


        driver.findElement(By.xpath(" /html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();


        driver.quit();



    }


}
