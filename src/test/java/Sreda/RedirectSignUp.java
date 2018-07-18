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
public class RedirectSignUp {

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
        WebElement newAccLnk = driver.findElement(By.linkText("Create a new account"));

        newAccLnk.click();

        Assert.assertEquals("https://courses.ultimateqa.com/users/sign_up", driver.getCurrentUrl());
    }
}
