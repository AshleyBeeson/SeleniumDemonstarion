package seleniumdemo;

import net.anthavio.phanbedder.Phanbedder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class BaseClass {

    WebDriver webDriver;
    static Properties properties = new Properties();

    @BeforeClass
    public static void beforeClass() throws IOException {
        properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/demo.properties"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separatorChar + "chromedriver.exe");
    }

    WebDriver getWebdriver(){
        WebDriver driver = getDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

    WebDriver getDriver(){
        String s = properties.getProperty("browser").toLowerCase();
        if (s.equals("firefox")) {
            return new FirefoxDriver();
        } else if (s.equals("chrome")) {
            return new ChromeDriver();
        } else if (s.equals("ie")) {
            return new InternetExplorerDriver();
        } else if (s.equals("phantomjs")) {
            File phantomjs = Phanbedder.unpack(new File("."));
            DesiredCapabilities phantomJSDCaps = new DesiredCapabilities();
            String[] phantomArgs = new String[]{
                    "--webdriver-loglevel=NONE",
                    "--ignore-ssl-errors=true"
            };
            phantomJSDCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
            phantomJSDCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
            return new PhantomJSDriver(phantomJSDCaps);
        } else {
            return new FirefoxDriver();
        }
    }

    WebElement getResult(WebDriver driver, int result){
        WebElement allResults = driver.findElement(By.cssSelector("#rso"));
        List<WebElement> resultBlocks = allResults.findElements(By.cssSelector("._NId"));
        WebElement header;
        try{
            header = resultBlocks.get(result).findElement(By.cssSelector(".r"));
        }catch (Exception ignore){
            header = resultBlocks.get(result + 1).findElement(By.cssSelector(".r"));
        }
        return header.findElement(By.cssSelector("a"));
    }



    @Before
    public void setUp() throws IOException {
        webDriver = getWebdriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
