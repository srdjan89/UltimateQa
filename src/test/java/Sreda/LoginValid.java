/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sreda;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Срђан
 */
public class LoginValid {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver.get("https://courses.ultimateqa.com/users/sign_in");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void VerifyElementsPresent() {
        WebElement username = driver.findElement(By.id("user_email"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement signInBtn = driver.findElement(By.id("btn-signin"));

        username.sendKeys("testitekako6@gmail.com");
        password.sendKeys("kiki0637644972");
        signInBtn.click();
        Assert.assertEquals("https://courses.ultimateqa.com/collections", driver.getCurrentUrl());

        //       WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert notification = driver.switchTo().alert();
//        String notificationLogin = notification.getText();
//        Assert.assertEquals("Signed in successfully.", notificationLogin);
        //WebElement notification = driver.findElement(By.cssSelector("#notifications > div > div > div > p"));
        //Assert.assertEquals("Signed in successfully.", notification.getText());
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.authenticateUsing(new UserAndPassword("USERNAME", "PASSWORD"));
//        Actions action = new Actions(driver);
    }
}
