package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class IsExist extends TestBase {
    /*Switching Between Multiple Windows:
    Step 1: get the window 1 handle:
            driver.switchTo.window(getWindowHandle);
    We need this because we need to compare this window and the other window using if statement.
            Step 2: get all of window handles with
    Set<String>=driver.getWIndowHandles();
    This gives us all of the windows. So we can use for loop and if statement to compare the current window and the niew window using if satement.
    We say, if window handle is not equal to current window, then switch to the window.
==How do you handle multiple windows?=====
            -I get defauld window handle
-Then use getWindowHandles to get ALL OPEN WINDOWS.
            -Then using for each and if statement, I can switch tot eh other window.
            ==How to do you swith back to the default window?==
            driver.switchTo.window(defauld window handle);
==What is Set and where do you use it in your framework?
    Set hold unique list of element. I used set when I was working with multiple windows. getWindowHandles() return all of hte open windows as a Set.

*/

    @Test
    public void test(){
        String path="C:\\Users\\fatih\\Desktop\\FLOWER. IMG.jpg";
       boolean pathjava= Files.exists(Paths.get(path));
        Assert.assertTrue(pathjava);





    }








}
