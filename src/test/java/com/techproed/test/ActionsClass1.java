package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class ActionsClass1 extends TestBase {

    /*Create a class: ActionsClass1
    Create a test method : contextClickMethod() and test the following scenario:
    Given user is on the https://the-internet.herokuapp.com/context_menu
    When use Right clicks on the box
    Then verify the alert message is “You selected a context menu”
    Then accept the alert*/


    @Test
    public void test() throws InterruptedException {

       driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions action= new Actions(driver);
        WebElement box= driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
        String text= driver.switchTo().alert().getText();
        Assert.assertEquals(text,"You selected a context menu");
        Thread.sleep(8000);
        driver.switchTo().alert().accept();





        }





    }






