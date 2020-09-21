package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FirstTestBaseExample extends TestBase {


    @Test
    public void test1(){

        driver.get("https://www.google.com/");


    }



}
