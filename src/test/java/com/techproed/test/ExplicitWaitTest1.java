package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {





    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement enable= driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enable.click();
        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals(message.getText(),"It's enabled!");

        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());
        WebElement disable= driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        disable.click();
        WebElement message1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals(message1.getText(),"It's disabled!");
        WebElement enableText= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!enableText.isEnabled());





    }

}
