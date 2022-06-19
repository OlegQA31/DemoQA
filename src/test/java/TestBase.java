import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app=new ApplicationManager();

    Logger logger= LoggerFactory.getLogger(TestBase.class);
    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Test starts "+m.getName());
    }
    @AfterMethod
    public void endLogger(Method m){
        logger.info("End of the test "+m.getName());
    }

    @BeforeSuite
    public void startApp(){
        app.init();
    }
    @AfterSuite
    public void closeApp(){
        app.stopApp();
    }
}
