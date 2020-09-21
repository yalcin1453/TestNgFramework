package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpLoadFileTest extends TestBase {

    @Test
    public void test(){
      driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        String path="C:\\Users\\fatih\\Desktop\\FLOWER. IMG.jpg";
        chooseFile.sendKeys(path);
        WebElement submit= driver.findElement(By.id("file-submit"));
        submit.click();
        String text= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(text,"File Uploaded!");






    }



}
