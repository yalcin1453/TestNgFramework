package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class WindowHandleExample extends TestBase {

   /*
    Then user verifies the new window title is “New Window”
    Then user verifies the text:  “New Window”
    When user goes back to the previous window and then verifies the title : “The Internet”*/

    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.getText().contains("Opening a new window"));
        String title=driver.getTitle();
        Assert.assertEquals(title,"The Internet","Title is not correct");
        String defaultWindow= driver.getWindowHandle();
        System.out.println(defaultWindow);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allWindows= driver.getWindowHandles();


        //driver.switchTo().window(defaultWindow);
        for (String w:allWindows
             ) {
            System.out.println(w);
            if(!w.equals(defaultWindow)){
                driver.switchTo().window(w);
            }

        }
        String actualNewTitle= driver.getTitle();
        System.out.println(actualNewTitle);
        Assert.assertEquals(actualNewTitle,"New Window");
        driver.switchTo().window(defaultWindow);
        Assert.assertEquals(driver.getTitle(),"The Internet");








    }


}
