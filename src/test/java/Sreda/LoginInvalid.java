/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sreda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class LoginInvalid {

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
        List<String> invalidEmails = new ArrayList<>();

        try {
            Scanner in = new Scanner(new FileReader("invalid.txt"));
            while (in.hasNext()) {
                invalidEmails.add(in.next());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String invalidEmail : invalidEmails) {
            username.sendKeys(invalidEmail);
            password.sendKeys("123456789");
            signInBtn.click();
            WebElement notification = driver.findElement(By.cssSelector("#notifications-error > ul > li"));
            Assert.assertEquals("Invalid email or password.", notification.getText());
        }

    }
}
