import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger= LoggerFactory.getLogger(MyListener.class);
    public MyListener() {
        super();
    }



    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element--->"+by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element--->"+by+" was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("'We faced the problem' "+throwable.getMessage());
        logger.info(String.valueOf(throwable.fillInStackTrace()));

        int index=(int)(System.currentTimeMillis()/1000)%3600;

        String link="src/test/screenshots/screen"+index+".png";

        logger.info("This is link to 'your screen with error'--->"+link);

//        HelperBase base=new HelperBase(driver);
//        base.takeScreenShot(link);

        File tmp=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen=new File(link);

        try{
            Files.copy(tmp,screen);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
