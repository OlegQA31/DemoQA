import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app=new ApplicationManager(System
            .getProperty("browser", BrowserType.CHROME));//if won't be any browser. will be chrome by default

    Logger logger= LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m){
        logger.info("Test starts "+m.getName());
    }
    @AfterMethod
    public void endLogger(Method m){
        logger.info("End of the test "+m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void startApp(){
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void closeApp(){
        app.stopApp();
    }
}
