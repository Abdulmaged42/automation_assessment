package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ranges.RangeException;

public class ShoppingCart {
    private WebDriver driver;
    private By totalLocator = By.id("totalp");
    private By numberOfItemsLocator = By.xpath("//tbody[@id='tbodyid']/tr");
    private By placeOrderLocator = By.xpath("//button[contains(text(),'Place Order')]");
    private By deleteLocator = By.xpath("(//a[contains(text(),'Delete')])[1]");


    public ShoppingCart(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public int getTotal() {
        waitFor(totalLocator);
        String total = driver.findElement(totalLocator).getText();
        int number = Integer.parseInt(total);
        return number;
    }

    public int numberOfItemsInCart() {
        return driver.findElements(numberOfItemsLocator).size();
    }

    public PlaceOrder clickOnPlaceOrder() {
        waitFor(placeOrderLocator);
        driver.findElement(placeOrderLocator).click();
        return new PlaceOrder(driver);
    }

    public void DeleteItem() {
        driver.findElement(deleteLocator).click();
    }

    public void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
