package seleniumdemo;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SeleniumTests extends BaseClass{

    @Test
    public void googleSearchTest() throws InterruptedException {

        webDriver.navigate().to("http://www.google.com");
        WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
        searchBar.sendKeys(properties.getProperty("search_term"));
        searchBar.sendKeys("\n");
        TimeUnit.SECONDS.sleep(5);
        WebElement result = getResult(webDriver, 0);
        result.click();
        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    public void autoTraderCarSearch() throws InterruptedException {
        AutoTraderWebPage autoTraderWebPage = new AutoTraderWebPage();
        autoTraderWebPage.goToWebpage(webDriver);
        WebElement searchForm = autoTraderWebPage.getSearchForm(webDriver);
        CarData carData = new CarData();
        autoTraderWebPage.fillOutForm(carData,searchForm);
        autoTraderWebPage.submitForm(searchForm);

    }


}
