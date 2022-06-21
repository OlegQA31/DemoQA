import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    UserHelper userHelper;
    //WebDriver wd;
    String browser;
    EventFiringWebDriver wd;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();
            wd=new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests were launched in 'Chrome'");
        }else if(browser.equals(BrowserType.EDGE)){
            WebDriverManager.edgedriver().setup();
            wd=new EventFiringWebDriver(new EdgeDriver());
            logger.info("Tests were launched in 'EDGE'");
        }

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
