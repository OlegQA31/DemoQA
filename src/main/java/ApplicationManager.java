import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    UserHelper userHelper;
    //WebDriver wd;
    EventFiringWebDriver wd;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){
        WebDriverManager.chromedriver().setup();
        wd=new EventFiringWebDriver(new ChromeDriver());
        wd.manage().window().maximize();
        wd.navigate().to("https://demoqa.com/");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper=new UserHelper(wd);
        wd.register(new MyListener());
    }
    public void stopApp(){
        //wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
