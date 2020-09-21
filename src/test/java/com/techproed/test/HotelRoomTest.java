package com.techproed.test;

import com.techproed.Smoketest.PositiveTest;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTest extends TestBase {

    @Test
    public void login(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement login= driver.findElement(By.linkText("Log in"));
        login.click();


    }@Test
    public void positiveLoginTest() throws InterruptedException {
        login();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();

        WebElement hotelManagement=driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();

        WebElement hotelRooms=driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();

        WebElement addHotelRoomButton=driver.findElement(By.partialLinkText("ADD HOTELROOM"));
        addHotelRoomButton.click();
      driver.findElement(By.xpath("//span[@class='hidden-480']")).click();
      WebElement selectHotel= driver.findElement(By.xpath("//select[@id='IDHotel']"));
        Select select =new Select(selectHotel);
        select.selectByValue("4");
        driver.findElement(By.xpath("//input[@id='Code']")).sendKeys("133");
        driver.findElement(By.xpath("//input[@id='Name']")).sendKeys("KingRoom");
        driver.findElement(By.xpath("//input[@id='Location']")).sendKeys("Philedelphia");

        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Best Hotel Room");

        driver.findElement(By.xpath("//input[@id='Price']")).sendKeys("300");

        WebElement room= driver.findElement(By.id("IDGroupRoomType"));
        Select select1= new Select(room);
        select1.selectByValue("6");
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("4");
        WebElement approve=driver.findElement(By.id("uniform-IsAvailable"));
        approve.click();
        driver.findElement(By.id("btnSubmit")).click();
        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        Assert.assertEquals(successMessage.getText(),"HotelRoom was inserted successfully");

        WebElement ok= driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        ok.click();










    }
}


