package Login;

import Pages.HomePage;
import Pages.Login;
import Registration.RegistrationTest;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    RegistrationTest registration = new RegistrationTest();


    @Test
    public void validLogin() {
        String validUserName = registration.userName;
        String validPassword = registration.password;
        if(validUserName==null){
             validUserName = "Anna Adkins";
             validPassword = "abd123456";
        }

        Login login = homePage.clickOnLogin();
        login.setUserName(validUserName);
        login.setPassword(validPassword);
        homePage = login.clickOnLogIn();
        String actualName = homePage.getUserName();
        System.out.println("actualName " + actualName);
        assertTrue(actualName
                        .contains("Welcome " + validUserName),
                "incorrect user name");
    }
    @Test
    public void invalidLogin() {
        Login login = homePage.clickOnLogin();
        login.setUserName("Anna Adkins");
        login.setPassword("12345");
        homePage = login.clickOnLogIn();
        String alertMessage = login.alert_getText();
        System.out.println("actualName " + alertMessage);
        assertTrue(alertMessage
                        .contains("Wrong password."),
                "incorrect message");
    }
}
