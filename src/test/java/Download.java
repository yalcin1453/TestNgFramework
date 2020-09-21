import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Download extends TestBase {

 /*   Create a class:FileDownload
    Create two test method: isExist() and downloadTest()
    In the downloadTest() method, do the following test:
    Go to https://the-internet.herokuapp.com/download
    Download logo.png file
    Then verify if the file downloaded successfully*/
    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement flower= driver.findElement(By.linkText("FLOWER.JPG"));
        flower.click();

        String folder= System.getProperty("user.home");
        System.out.println(folder);
        String  path= folder+"\\Downloads";

        boolean file= Files.exists(Paths.get(path));
        Assert.assertTrue(file,"this is not exist");




    }





}
