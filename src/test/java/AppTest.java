package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import po.LoginPage;

import static org.junit.Assert.assertTrue;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\Users\rosan\Downloads\chromedriver_win32");
        return new ChromeDriver();
    }

    @Test
    public void InvalidCredentials () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("standard_user", "secret");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Test");
    }

    @Test
    public void EmptyUserName()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "secret");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Empty");
    }

    @Test
    public void LoginSuccessFull()
    {
        System.setProperty("webdriver.chrome.driver", "C:Users\rosan\Downloads\chromedriver_win32");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dropbox.com/login");
        WebElement username=driver.findElement(By.id("login_email7512535700574188"));
        WebElement password=driver.findElement(By.id("login_password850312899950312"));
        WebElement login=driver.findElement(By.name("login-register-switch-link"));
        username.sendKeys("abc@gmail.com");
        password.sendKeys("your_password");
        login.click();
        String actualUrl="https://www.dropbox.com/home";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

}
