package seleniumdemo;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    protected static Properties properties = new Properties();
    protected static int browserCount;
    @BeforeClass
    public static void beforeClass() throws IOException {
        properties.load(new FileInputStream("src/main/resource/demo.properties"));
        String number_of_browsers = properties.getProperty("number_Of_Browsers");
        browserCount = Integer.parseInt(number_of_browsers);
    }

    protected WebDriver getWebdriver(int browser){
        String s = properties.getProperty("browser." + browser).toLowerCase();
        if (s.equals("firefox")) {
            return new FirefoxDriver();
        } else if (s.equals("chrome")) {
            return new ChromeDriver();
        } else if (s.equals("ie")) {
            return new InternetExplorerDriver();
        } else if (s.equals("phantomjs")) {
            return new PhantomJSDriver();
        } else {
            return new FirefoxDriver();
        }
    }
}
