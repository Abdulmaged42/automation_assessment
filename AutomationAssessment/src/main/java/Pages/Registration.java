package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Registration {
    private WebDriver driver;

    private By userNameLocator = By.id("sign-username");
    private By passwordLocator = By.id("sign-password");
    private By signUpButton = By.xpath("//button[contains(text(),'Sign up')]");

    public Registration(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setUserName(String text) {
        driver.findElement(userNameLocator).sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(passwordLocator).sendKeys(text);
    }

    public void clickOnSignUp() {

        driver.findElement(signUpButton).click();
    }

    public void alert_clickToAccept() {
        waitForAlert();
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText() {
        waitForAlert();
        return driver.switchTo().alert().getText();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
