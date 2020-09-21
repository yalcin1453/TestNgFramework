package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollUpDown extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com/");
        Actions action= new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_UP).perform();









    }










}
