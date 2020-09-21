package com.techproed.Smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {
    @Test
    public void login(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement login= driver.findElement(By.linkText("Log in"));
        login.click();


    }
    @Test
    public void positiveLoginTest(){
        login();
      driver.findElement(By.id("UserName")).sendKeys("manager2");
      driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
      driver.findElement(By.id("btnSubmit")).click();
      WebElement addUser= driver.findElement(By.xpath("//span[@class='hidden-480']"));
      Assert.assertTrue(addUser.isDisplayed());
      // sign out is homework













    }







}
