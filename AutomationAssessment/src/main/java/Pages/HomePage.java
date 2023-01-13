package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private String loginIframeId = "logInModal";
    private By nameOfUserLocator=By.xpath("//a[@id='nameofuser']");
    private By catLocator=By.xpath("//a[@id='cat']");



    public static final long WAIT = 20;

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private void clickLink(String linkText) {

        driver.findElement(By.linkText(linkText)).click();

    }

    public Registration clickOnRegister() {

        clickLink("Sign up");
        WebElement signInModalLabel = driver.findElement(By.id("signInModalLabel"));

        waitForVisibility(signInModalLabel);
        return new Registration(driver);
    }

    public Login clickOnLogin() {
        clickLink("Log in");
        WebElement logInModalLabel = driver.findElement(By.id("logInModalLabel"));
        waitForVisibility(logInModalLabel);
        return new Login(driver);
    }
    public String getUserName(){
        waitFor(nameOfUserLocator);
        return driver.findElement(nameOfUserLocator).getText();
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public CategoryList choseCategory(){
        waitFor(catLocator);
        driver.findElement(By.xpath("//a[@id='cat']")).click();
        return new CategoryList(driver);
    }
    public void waitFor(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
