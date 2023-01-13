package Registration;

import Pages.Registration;
import base.BaseTest;
import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.NameGenerator;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    public String password = "abd123456";
    NameGenerator generator = new NameGenerator();
    public static String userName;

    @Test(priority = 1)
    public void validRegistration() {
        userName=String.valueOf(generator.generateName(Gender.FEMALE));
        System.out.println("username " + userName);
        Registration registration = homePage.clickOnRegister();
        registration.setUserName(userName);
        registration.setPassword(password);
        registration.clickOnSignUp();
        String alertMessage = registration.alert_getText();
        assertTrue(alertMessage
                        .contains("Sign up successful."),
                "message is incorrect");
        registration.alert_clickToAccept();
    }
    @Test
    public void invalidRegistration() {

        Registration registration = homePage.clickOnRegister();
        registration.setUserName(userName);
        registration.setPassword(password);
        registration.clickOnSignUp();
        String alertMessage = registration.alert_getText();
        assertTrue(alertMessage
                        .contains("This user already exist."),
                "message is incorrect");
        registration.alert_clickToAccept();
    }
}
