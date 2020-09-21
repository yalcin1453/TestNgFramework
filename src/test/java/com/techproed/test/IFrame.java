package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrame extends TestBase {

 /*   Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”
    Verify the text Elemental Selenium text is displayed on the page*/


    @Test
    public void iTest01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String text= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(text.contains("Editor"));
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("mce_0_ifr");
        WebElement element= driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(element);
        Thread.sleep(3000);
        WebElement insideText= driver.findElement(By.xpath("//p"));
        insideText.clear();
        Thread.sleep(3000);
        insideText.sendKeys("this text box is inside the frame");
        driver.switchTo().defaultContent();
        String selenium= driver.findElement(By.linkText("Elemental Selenium")).getText();
        Assert.assertTrue(selenium.contains("Elemental Selenium"));








    }


}
