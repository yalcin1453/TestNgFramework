package com.techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Practice01 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}




        @Test
    public void test01(){

            WebElement click= driver.findElement(By.id("button1"));
            click.click();
            String text= driver.switchTo().alert().getText();
            Assert.assertEquals(text,"I am an alert box1");
            driver.switchTo().alert().accept();




        }@Test (dependsOnMethods = "test01")
    public void get02( ){

WebElement javaScript= driver.findElement(By.xpath("(//span[@class='btn btn-default btn-lg dropdown-toggle'])[4]"));
javaScript.click();
String text= driver.switchTo().alert().getText();
SoftAssert  soft= new SoftAssert();
soft.assertEquals(text,"Press a button");
driver.switchTo().alert().dismiss();
String text1=driver.switchTo().alert().getText();
soft.assertEquals(text1,"You pressed Cancel!");
soft.assertAll();





    }





    }











