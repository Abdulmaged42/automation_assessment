package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ranges.RangeException;

public class CategoryList {
    private By itemLocator = By.xpath("(//div[@id='tbodyid']/div/div/a)[1]");
    private By itemNameLocator = By.xpath("(//div[@id='tbodyid']/div/div//a[@class='hrefch'])[1]");
    private By itemPriceLocator = By.xpath("(//div[@id='tbodyid']//div[@class='card-block']/h5)[1]");
    private WebDriver driver;

    public CategoryList(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public itemPage selectItem() {
        waitFor(itemLocator);
        driver.findElement(itemLocator).click();
        return new itemPage(driver);
    }

    public String getItemName() {
        waitFor(itemNameLocator);
        return driver.findElement(itemNameLocator).getText();
    }

    public int getItemPrice() {
        String total = driver.findElement(itemPriceLocator).getText();
        String[] parts = total.split("\\$");
        int number = 0;
        try {
            number = Integer.parseInt(parts[1]);

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (RangeException e) {
            throw e;
        } finally {
            System.out.println("Thank you for using the program!");
        }
        return number;
    }

    public void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
