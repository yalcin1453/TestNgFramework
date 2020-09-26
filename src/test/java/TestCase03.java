import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends TestBase {

    @Test
    public void test(){

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait=new WebDriverWait(driver,5);
        WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enableAfter")));
        Assert.assertTrue(button.isDisplayed());


    }


}
