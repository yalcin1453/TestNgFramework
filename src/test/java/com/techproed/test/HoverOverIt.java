package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOverIt extends TestBase {

/*
    Create a class: ActionClass2
    Create test method : hoverOver() and test the following scenario:
    Given user is on the https://www.amazon.com/
    When use click on “Your Account” link
    Then verify the page title contains “Your Account”
    Create another method: imageTest()
    Hover over the Try Prime
    And Verify the image displays.*/
    @Test
    public void test(){
     driver.get("https://www.amazon.com/");
        Actions action= new Actions(driver);
        WebElement sign= driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(sign).perform();
        WebElement account= driver.findElement(By.linkText("Your Account"));
        account.click();
        String title= driver.getTitle();
        Assert.assertEquals(title,"Your Account");




    }



}
