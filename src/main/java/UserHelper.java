import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openForm() {
        click(By.xpath("//div//h5[text()='Elements']"));
        pause(1500);
        click(By.xpath("//span[text()='Text Box']"));
    }

    public void fillInTheForm(User user) {
        type(By.xpath("//*[@placeholder='Full Name']"), user.getName());
        type(By.xpath("//*[@placeholder='name@example.com']"), user.getEmail());
        type(By.xpath("//*[@placeholder='Current Address']"), user.getCaddress());
        type(By.xpath("//*[@id='permanentAddress']"), user.getPaddress());
    }

    public void submitClick() {
        click(By.xpath("//*[@id='submit']"));
    }

    public void checkOutput(User user) {

        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='email']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='currentAddress']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='permanentAddress']")).getText());


        Assert.assertEquals(wd.findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText(),"Name:"+user.getName());
    }
    public void checkOutput(String name) {

        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='email']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='currentAddress']")).getText());
        System.out.println(wd.findElement(By.xpath("//div[@id='output']//p[@id='permanentAddress']")).getText());


        Assert.assertEquals(wd.findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText(),"Name:"+name);
    }

    public void goToAlertfFrameAndActivate() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(By.xpath("//span[text()='Alerts']"));
        click(By.xpath("//button[@id='alertButton']"));


    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            return false;
        }else{
            return true;
        }
    }

    public boolean doYouClickOnTheAlertButton() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        //alert.dismiss();//click cancel button
        //alert.sendKeys("email");
        System.out.println(alert.getText());
        //alert.accept();//click ok button
        String error=alert.getText();
        alert.accept();
        return error.contains("You clicked a button");
    }

    public void fillInTheForm(String name, String email, String caddress, String paddress) {
        type(By.xpath("//*[@placeholder='Full Name']"), name);
        type(By.xpath("//*[@placeholder='name@example.com']"), email);
        type(By.xpath("//*[@placeholder='Current Address']"), caddress);
        type(By.xpath("//*[@id='permanentAddress']"), paddress);
    }
}
