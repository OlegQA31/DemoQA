import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{
    @Test(groups = {"tryone"},dataProvider = "dP", dataProviderClass = MyDataProvider.class)
    public void fillInTheFormTest(User user){

        logger.info("This test with data: "+user.getName()+" "+user.getEmail());
        app.getUserHelper().openForm();
        app.getUserHelper().fillInTheForm(user);
        app.getUserHelper().submitClick();
        app.getUserHelper().checkOutput(user);
        //app.getUserHelper().takeScreenShot("src/test/screenshots/scr1.png");
    }

    @Test(dataProvider = "regValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void fillInTheFormTestSecond(String name,String email,String caddress,String paddress){

        logger.info("This test with data: "+name+" "+email+" "+caddress+" "+paddress);
        app.getUserHelper().openForm();
        app.getUserHelper().fillInTheForm(name,email,caddress,paddress);
        app.getUserHelper().submitClick();
        app.getUserHelper().checkOutput(name);
    }

    @AfterMethod(alwaysRun = true)
    public void homePageReturn(){
        app.getUserHelper().click(By.xpath("//a[@href='https://demoqa.com']"));
    }
}
