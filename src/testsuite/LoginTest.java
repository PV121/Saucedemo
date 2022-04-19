package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    @Before
    public void openBowserLoginTest(){
        openBrowser("https://www.saucedemo.com/");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        String expectedMessage = "PRODUCTS";
        WebElement actualMessageElement= driver.findElement(By.xpath("//span[contains(text(),'Products')]"));

        String actualMessage = actualMessageElement.getText();
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        WebElement userName= driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        int expectedResult= 6;

        List <WebElement> actualResultElement= driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualResult= actualResultElement.size();

        Assert.assertEquals(expectedResult,actualResult);
    }
    @After
    public void closeBrowserLogin(){
        closeBrowser();
    }

}
