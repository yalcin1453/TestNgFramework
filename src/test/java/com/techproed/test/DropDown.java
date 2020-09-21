package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }@Test
    public void Test1() throws InterruptedException {
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        sel.selectByIndex(1);

    }@Test
    public void Test2(){

        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        sel.selectByVisibleText("Option 2");





}@Test
    public void Test3(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        sel.selectByValue("2");
    }@Test
    public void Test4() throws InterruptedException {
        Thread.sleep(5);
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        WebElement option= sel.getFirstSelectedOption();
        System.out.println(option.getText());





    }@Test
    public void Test5() {
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        List<WebElement> options = sel.getOptions();
        for (WebElement i : options) {
            System.out.println(i.getText());

        }

    }@Test
    public void Test6(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        List<WebElement> options = sel.getOptions();
        System.out.println(options.size());
        Assert.assertEquals(options.size(),4);
    }@Test
    public void Test7(){
        WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select sel= new Select(dropDown);
        sel.getFirstSelectedOption();
        System.out.println(sel.getFirstSelectedOption().getText());


    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
