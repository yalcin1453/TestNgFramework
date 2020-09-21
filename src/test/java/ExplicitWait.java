import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWait extends TestBase {

    /*Create a class:ExplicitWaitTest. Create a method: explicitWait
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click on remove button
    And verify the message is equal to “It's gone!”
    Then click on Add button
    And verify the message is equal to “It's back!”*/


    @Test
    public void explicit(){
        WebDriverWait wait= new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remove= driver.findElement(By.xpath("//button"));
        remove.click();

        WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals(message.getText(),"It's gone!");

        WebElement add= driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        add.click();
        WebElement addMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals(addMessage.getText(),"It's back!");




    }
}
