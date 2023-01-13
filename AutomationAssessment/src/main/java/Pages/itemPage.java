package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ranges.RangeException;

public class itemPage {
    private WebDriver driver;
    private By itemNameLocator = By.tagName("h2");
    private By addItemToCartLocator = By.xpath("//a[contains(text(),'Add to cart')]");

    private By cartLocator = By.xpath("//a[@id='cartur']");

    public itemPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public String getItemTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemNameLocator));
        return driver.findElement(itemNameLocator).getText();
    }

    public void addItemToCart(int numberOfItems) {
        for (int i = 1; i <= numberOfItems; i++) {
            driver.findElement(addItemToCartLocator).click();
            alert_clickToAccept();
        }
    }

    public void alert_clickToAccept() {
        waitForAlert();
        driver.switchTo().alert().accept();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public ShoppingCart openCart() {
        driver.findElement(cartLocator).click();
        return new ShoppingCart(driver);
    }

}
