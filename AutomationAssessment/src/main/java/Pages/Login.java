package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    private By userNameLocator = By.id("loginusername");
    private By passwordLocator = By.id("loginpassword");
    private final By logInButton = By.xpath("//button[contains(text(),'Log in')]");

    public Login(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void setUserName(String text) {
        driver.findElement(userNameLocator).sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(passwordLocator).sendKeys(text);
    }

    public HomePage clickOnLogIn() {

        driver.findElement(logInButton).click();
        return new HomePage(driver);
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
