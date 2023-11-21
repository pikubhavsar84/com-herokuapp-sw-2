package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement userLogIn = driver.findElement(By.xpath("//button//i"));
        userLogIn.click();
        //verify the text secure area
        WebElement textMessage = driver.findElement(By.xpath("//h2"));
        String expectedMessage = "Secure Area";
        Assert.assertEquals("text not display", expectedMessage, textMessage.getText());
    }
    @Test
    public void verifyTheUsernameErrorMessage()  {
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement userLogIn = driver.findElement(By.xpath("//button//i"));
        userLogIn.click();
        //verify the error "your user name is invalid"
        //WebElement textMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
       // String expectedMessage = "Your username is Invalid!";
        //Assert.assertEquals("text not display", expectedMessage, textMessage.getText());
        Assert.assertEquals("Your username is invalid!", driver.findElement(By.linkText("//*[@id=\"flash\"]/text()")).getText());

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");
        WebElement userLogIn = driver.findElement(By.xpath("//button//i"));
        userLogIn.click();
        //verify the error "your password is invalid"
        WebElement textMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String expectedMessage = "Your password is Invalid!";
        Assert.assertEquals("text not display", expectedMessage, textMessage.getText());


    }
    @After
    public void tearDown() {
        driver.quit();
    }

      }

