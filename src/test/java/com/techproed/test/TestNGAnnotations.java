package com.techproed.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class TestNGAnnotations {
    @BeforeMethod
    public void setup() {


        System.out.println("This is BeforeMethod"); }




    @Test(priority = 10)
    public void test1(){
        System.out.println("Test1");

    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2");
    }@Test(priority = 6)
    public void test3(){
        System.out.println("Test3");
    }@Test(priority = -8)
    public void test4(){
        System.out.println("Test4");
    }@AfterMethod
    public void tearDown(){
    System.out.println("This is AfterMethod");
    }

    public static class DropDownHomeWork {

        WebDriver driver;
        @BeforeMethod

        public void setup(){





            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.get("https://www.amazon.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong("10"), TimeUnit.SECONDS);
        }@Test
        public void test01(){
            WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            dropdown.click();
        }@Test
        public void test02(){
            WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select sel= new Select(dropdown);
            sel.getFirstSelectedOption();
            Assert.assertEquals(sel.getFirstSelectedOption().getText(),"All Departments");



        }@Test
        public void test03(){
            WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select sel= new Select(dropdown);
            sel.selectByIndex(3);
            String selected= sel.getFirstSelectedOption().getText();
            Assert.assertEquals(selected,"Amazon Devices");
            List<WebElement> options= sel.getOptions();
            for (WebElement s:options){
                System.out.println(s.getText());

            }

        }@Test
        public void test04(){
            WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select sel= new Select(dropdown);
            List<WebElement> options= sel.getOptions();
            System.out.println(options.size());




        }@Test
        public void test05(){
            WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select sel= new Select(dropdown);
            List<WebElement> options= sel.getOptions();
            System.out.println(options.contains("Appliances"));




        }@Test
        public void test06() {
            WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            Select sel = new Select(dropdown);
            List<WebElement> options = sel.getOptions();
            TreeSet<WebElement> treeSet = new TreeSet<WebElement>();
            for(WebElement s:options){
                treeSet.add(s);}
            System.out.println(treeSet.contains(options)&& treeSet.size()== options.size());


            }@AfterMethod
        public void tearDown(){
            driver.close();
        }




            }
}
