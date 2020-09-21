package com.techproed.Smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    @Test
    public void login(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement login= driver.findElement(By.linkText("Log in"));
        login.click();


    }

    @Test
    public void invalidPassword(){

        login();
        WebElement username= driver.findElement(By.id("UserName"));
        WebElement password= driver.findElement(By.id("Password"));
        username.sendKeys("manager2");
        password.sendKeys("abjfhds");
        WebElement loginPress= driver.findElement(By.id("btnSubmit"));
        loginPress.click();
        WebElement message= driver.findElement(By.id("divMessageResult"));
        String messageText= message.getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Wrong password"));




    }

    @Test
    public void invalidID() {
        login();
        WebElement username= driver.findElement(By.id("UserName"));
        username.sendKeys("hjdfhjdfhd");
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!");
        WebElement loginPress= driver.findElement(By.id("btnSubmit"));
        loginPress.click();
        WebElement message= driver.findElement(By.id("divMessageResult"));
        String messageText= message.getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Try again please"));





    }

    @Test
    public void invalidPasswordAndID() {
        login();
        WebElement username= driver.findElement(By.id("UserName"));
        username.sendKeys("hjjkjkljkl");
        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("Man1ager2!123");
        WebElement loginPress= driver.findElement(By.id("btnSubmit"));
        loginPress.click();
        WebElement message= driver.findElement(By.id("divMessageResult"));
        String messageText= message.getText();
        System.out.println(messageText);
        Assert.assertTrue(messageText.contains("Try again please"));



    }
}