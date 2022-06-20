import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{
    @Test
    public void checkAlert(){
        app.getUserHelper().goToAlertfFrameAndActivate();
        Assert.assertTrue(app.getUserHelper().isAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().doYouClickOnTheAlertButton());
    }
    @AfterMethod
    public void homePageReturn(){
        app.getUserHelper().click(By.xpath("//a[@href='https://demoqa.com']"));
    }

}
