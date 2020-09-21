package com.techproed.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice02 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}



@Test
public void test01() throws InterruptedException {
    WebElement signInButton = driver.findElement(By.className("icon-signin"));
    signInButton.click();
    WebElement userLogin = driver.findElement(By.id("user_login"));
    userLogin.sendKeys("username");
    WebElement password = driver.findElement(By.id("user_password"));
    password.sendKeys("password");
    Thread.sleep(2000);
    WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
    submit.click();
    WebElement activity= driver.findElement(By.id("account_activity_tab"));
    activity.click();
    WebElement account= driver.findElement(By.id("aa_accountId"));
    Select sel= new Select(account);
    sel.selectByVisibleText("Brokerage");
    String s= sel.getFirstSelectedOption().getText();
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(s,"Brokerage");
    List<WebElement> options =sel.getOptions();
    List<String> list= new ArrayList<String>();
    List<String> expected= Arrays.asList("Savings","Checking","Savings","Loan","Credit Card","Brokerage");



    for(WebElement e:options){
        list.add(e.getText());

    }
soft.assertEquals(list,expected);

    soft.assertAll();





}


}
