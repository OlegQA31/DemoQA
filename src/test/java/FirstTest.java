import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{
    @Test
    public void fillInTheFormTest(){
        User user= User.builder()
                .name("John")
                .email("maga@gmail.com")
                .caddress("Israel")
                .paddress("Russia")
                .build();
        logger.info("This test with data: "+user.getName()+" "+user.getEmail());
        app.getUserHelper().openForm();
        app.getUserHelper().fillInTheForm(user);
        app.getUserHelper().submitClick();
        app.getUserHelper().checkOutput(user);
        //app.getUserHelper().takeScreenShot("src/test/screenshots/scr1.png");
    }

    @Test
    public void fillInTheFormTestSecond(){
        User user= User.builder()
                .name("Vince")
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
