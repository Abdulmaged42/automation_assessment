package base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }
//
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
