package seleniumdemo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class SeleniumTest extends BaseClass{

    List<WebDriver> webDrivers;

    @Before
    public void setUp() throws IOException {
        for (int i = 0; i < browserCount; i++) {
            webDrivers.add(getWebdriver(i));
        }
    }

    @Test
    public void test(){

    }

    @After
    public void tearDown(){

    }


}
