import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SecondTest extends TestBase{
    @Test
    public void fillInTheFormTestThird(){
        User user= User.builder()
                .name("Bruce")
                .email("maga@gmail.com")
                .caddress("Israel")
                .paddress("Russia")
                .build();
        logger.info("This test with data: "+user.getName()+" "+user.getEmail());
        app.getUserHelper().openForm();
        app.getUserHelper().fillInTheForm(user);
        app.getUserHelper().submitClick();
        app.getUserHelper().checkOutput(user);
    }

    @Test
    public void fillInTheFormTestFourth(){
        User user= User.builder()
                .name("Brons")
                .email("Vince@gmail.com")
                .caddress("Israel")
                .paddress("Russia")
                .build();
        logger.info("This test with data: "+user.getName()+" "+user.getEmail());
        app.getUserHelper().openForm();
        app.getUserHelper().fillInTheForm(user);
        app.getUserHelper().submitClick();
        app.getUserHelper().checkOutput(user);
    }

    @AfterMethod
    public void homePageReturn(){
        app.getUserHelper().click(By.xpath("//a[@href='https://demoqa.com']"));
    }
}
