package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }



    @Test
    public void hardAsset(){
        WebElement gmail= driver.findElement(By.linkText("Gmail"));

        Assert.assertEquals(gmail.getText(),"Gmail");
        WebElement signin= driver.findElement(By.linkText("Sign in"));
        Assert.assertEquals(signin.getText(),"Sign in");
        WebElement image= driver.findElement(By.linkText("Images"));
        Assert.assertEquals(image.getText(),"Images");





    }@Test
    public void softAssert(){

        SoftAssert sfa= new SoftAssert();
        WebElement gmail= driver.findElement(By.linkText("Gmail"));
        sfa.assertEquals(gmail.getText(),"Gmail");

        WebElement signin= driver.findElement(By.linkText("Sign in"));
        sfa.assertEquals(signin.getText(),"sign in");
        WebElement image= driver.findElement(By.linkText("Images"));
        sfa.assertEquals(image.getText(),"Images");
        sfa.assertAll();



    }


    public static class Alert {
        WebDriver driver;
        @BeforeMethod
        public void setup(){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();



        }@Test
        public void acceptAlert(){
            WebElement alert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
            alert.click();
            String firstAlert= driver.switchTo().alert().getText();
            Assert.assertEquals(firstAlert,"I am a JS com.techproed.test.SoftAssertTest.Alert");
            driver.switchTo().alert().accept();
            WebElement result= driver.findElement(By.id("result"));
            Assert.assertEquals(result.getText(),"You successfuly clicked an alert");




        }@Test
        public void dismiss(){
        WebElement second= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        second.click();
        String messega= driver.switchTo().alert().getText();
        Assert.assertEquals(messega,"I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        WebElement result= driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You clicked: Cancel");



        }@Test
    public void sendKeys(){
            WebElement third= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
            third.click();
            driver.switchTo().alert().sendKeys("Hello World");
            driver.switchTo().alert().accept();
            WebElement result= driver.findElement(By.id("result"));
            Assert.assertEquals(result.getText(),"You entered: Hello World");


        }@AfterMethod
        public void tearDown(){
            driver.close();
        }







    }
}
