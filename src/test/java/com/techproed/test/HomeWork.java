package com.techproed.test;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork extends TestBase {

    @Test
    public void login(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement login= driver.findElement(By.linkText("Log in"));
        login.click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();





    }@Test
    public  void management() {
login();
driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
driver.findElement(By.xpath("//a[@href='/admin/RoomReservationAdmin']")).click();
WebDriverWait wait= new WebDriverWait(driver,20);
WebElement addRoom=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-plus']")));
addRoom.click();
WebElement SelectUser= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='IDUser']")));
Select select=new Select(SelectUser);
select.selectByValue("4");
        WebElement iDHotelRoom = driver.findElement(By.id("IDHotelRoom"));
        iDHotelRoom.click();
        Select iDHotelRoomOpt = new Select(iDHotelRoom);
        iDHotelRoomOpt.selectByVisibleText("team06");

        driver.findElement(By.xpath("//input[@id='Price']")).sendKeys("400");
WebElement startDate= driver.findElement(By.xpath("//input[@id='DateStart']"));
startDate.click();
startDate.sendKeys("10/20/2020");
WebElement endDate= driver.findElement(By.xpath("//input[@id='DateEnd']"));
endDate.click();
endDate.sendKeys("10/25/2020");
driver.findElement(By.xpath("//input[@id='AdultAmount']")).sendKeys("2");
driver.findElement(By.xpath("//input[@id='ChildrenAmount']")).sendKeys("4");
driver.findElement(By.xpath("//input[@id='ContactNameSurname']")).sendKeys("Fatih Yalcin");
driver.findElement(By.xpath("//input[@id='ContactPhone']")).sendKeys("310-202-5555");
driver.findElement(By.xpath("//input[@id='ContactEmail']")).sendKeys("Fatih7221@gmail.com");
driver.findElement(By.xpath("//input[@id='Notes']")).sendKeys("I need newspaper and transportation");

driver.findElement(By.xpath("(//div[@class='form-group'])[13]")).click();
driver.findElement(By.id("uniform-IsPaid")).click();
driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
String alert=driver.switchTo().alert().getText();
Assert.assertEquals(alert,"RoomReservation was inserted successfully");
driver.switchTo().alert().accept();








    }





}
