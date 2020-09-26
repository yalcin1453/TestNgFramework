package day05;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCase extends TestBase {
/*.Go to http://webdriveruniversity.com/
            2.Go down to Login Portal
3.Click the Login Portal
4.Go to second windows
5.Fill the username and password
6.Click the login button
7.Print the popup text
    Accept the popup*/
    @Test

    public void test() {
        driver.get("http://webdriveruniversity.com/");
         Actions action= new Actions(driver);
         action.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//a[@id='login-portal']")).click();
        Set<String> allWindows= driver.getWindowHandles();
        System.out.println(allWindows);
        String firstWindow= driver.getWindowHandle();

        for (String w:allWindows
             ) {if(!w.equals(firstWindow)){

                 driver.switchTo().window(w);


        }

        }



        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("fatih721");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("kemal");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
       String alert= driver.switchTo().alert().getText();
        System.out.println(alert);





    }




}
