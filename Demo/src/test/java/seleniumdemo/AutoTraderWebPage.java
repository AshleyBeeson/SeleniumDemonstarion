package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

class AutoTraderWebPage {

    public void goToWebpage(WebDriver webDriver){
        webDriver.navigate().to("http://www.autotrader.co.uk");
    }

    public WebElement getSearchForm(WebDriver webDriver){
        return webDriver.findElement(By.cssSelector
                ("#main-content > div.homepage__coverrimage--main > div.homesearchholder.cf"));
    }


    public void fillOutForm(CarData carData, WebElement searchForm) {
        WebElement postcodeInput = searchForm.findElement(By.cssSelector("#postcode"));
        WebElement distanceElement = searchForm.findElement(By.cssSelector("#radius"));
        Select distanceDropdown = new Select(distanceElement);
        WebElement makeElement = searchForm.findElement(By.cssSelector("#searchVehiclesMake"));
        Select makeDropDown = new Select(makeElement);
        WebElement modelElement = searchForm.findElement(By.cssSelector("#searchVehiclesModel"));
        Select modelDropDown = new Select(modelElement);
        WebElement minElement = searchForm.findElement(By.cssSelector("#searchVehiclesPriceFrom"));
        Select minDropDown = new Select(minElement);
        WebElement maxElement = searchForm.findElement(By.cssSelector("#searchVehiclesPriceTo"));
        Select maxDropDown = new Select(maxElement);

        postcodeInput.sendKeys(carData.getPostcode());
        distanceDropdown.selectByVisibleText(carData.getDistance());
        makeDropDown.selectByVisibleText(getMake_Model(makeDropDown,carData.getMake()));
        modelDropDown.selectByVisibleText(getMake_Model(modelDropDown,carData.getModel()));
        minDropDown.selectByVisibleText(carData.getMin_Price());
        maxDropDown.selectByVisibleText(carData.getMax_Price());

    }

    public void submitForm(WebElement searchForm) {
        searchForm.findElement(By.cssSelector("#search")).click();
    }

    private String getMake_Model(Select select, String lookup){
        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            String text = option.getText().split(" ")[0];
            if (text.equalsIgnoreCase(lookup)){
                return option.getText();
            }
        }
        return null;
    }

}
