package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass3 extends TestBase {


    @Test
    public void test(){

       driver.get("https://www.google.com/");
        WebElement search= driver.findElement(By.name("q"));

        Actions action= new Actions(driver);
        action.keyDown(search, Keys.SHIFT).// pressing shift
                sendKeys("i phone prices").// typing
                keyUp(search,Keys.SHIFT).perform();// unpress the sift button





    }








}
