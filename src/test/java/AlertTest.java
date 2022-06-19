import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{
    @Test
    public void checkAlert(){
        app.getUserHelper().goToAlertfFrameAndActivate();
        Assert.assertTrue(app.getUserHelper().isAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().doYouClickOnTheAlertButton());
    }
}
