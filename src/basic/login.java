package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class login {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(40000);



        //login to application
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
        loginButton.click();


        driver.quit();



    }

}
