package com.github.pguzdziol.automation.tutorial.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest {


///This is just test commit
    private WebDriver driver;

    @BeforeClass
    private  void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sinawo Jackson\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    private void tearDown()
    {
       // driver.quit();
    }

    @BeforeMethod
    public void openHomePage()
    {
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void testAddingItemToCard()
    {
        //TODO
        new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@type='submit']")).click();


        WebElement firstItemTitleElement = driver.findElement(By.className("s-access-title"));
        String firstItemTittle = firstItemTitleElement.getText();
        firstItemTitleElement.click();


        assert (driver.findElement(By.id("productTitle")).getText().equals(firstItemTittle));
        driver.findElement(By.id("add-to-cart-button"));
        //assert (driver.findElement(By.id("hlb-ptc-btn-native")).getText().contains("hlb-ptc-btn-native"));


    }
}
