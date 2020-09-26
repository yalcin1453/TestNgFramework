import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase01 extends TestBase {
/*1.Go to ”https://www.mediawiki.org/wiki/Download”
            2.Click Download MediaWiki 1.34.2
            3.Verify the file is downloaded*/
    @Test


    public void test() throws InterruptedException {

driver.get("https://www.mediawiki.org/wiki/Download");
        WebElement download= driver.findElement(By.xpath("//a[@title='download:mediawiki/1.34/mediawiki-1.34.2.tar.gz']"));
        download.click();

       String userPath=System.getProperty("user.home");
       String path="userPath+\\Downloads\\mediawiki-1.34.2 (3).tar.gz";
       Thread.sleep(40);

        boolean isDownloaded = Files.exists(Paths.get(path));
        Assert.assertTrue(isDownloaded);
      




    }



}
