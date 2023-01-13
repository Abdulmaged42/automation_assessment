package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
    private WebDriver driver;
    private By nameLocator = By.id("name");
    private By countryLocator = By.id("country");
    private By cityLocator = By.id("city");
    private By creditLocator = By.id("card");
    private By monthLocator = By.id("month");
    private By yearLocator = By.id("year");
    private By okLocator = By.xpath("//button[contains(text(),'OK')]");
    private By purchaseLocator = By.xpath("//button[contains(text(),'Purchase')]");

    public PlaceOrder(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));
        driver.findElement(nameLocator).sendKeys(name);
    }

    public void setCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void setCountry(String country) {
        driver.findElement(countryLocator).sendKeys(country);
    }

    public void setCredit(String credit) {
        driver.findElement(creditLocator).sendKeys(credit);
    }

    public void setMonth(String month) {
        driver.findElement(monthLocator).sendKeys(month);
    }

    public void setYear(String year) {
        driver.findElement(yearLocator).sendKeys(year);
    }

    public void clickOnPurchase() {
        driver.findElement(purchaseLocator).click();
    }
    public void clickOnOk(){
        driver.findElement(okLocator).click();
    }
}
