package CheckOutTests;

import Pages.*;
import Registration.RegistrationTest;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CompleteCheckout extends BaseTest {
    RegistrationTest registration = new RegistrationTest();

    @Test
    public void selectItem() {
        String validUserName = registration.userName;
        String validPassword = registration.password;
        if (validUserName == null) {
            validUserName = "Anna Adkins";
            validPassword = "abd123456";
        }
        Login login = homePage.clickOnLogin();
        login.setUserName(validUserName);
        login.setPassword(validPassword);
        homePage = login.clickOnLogIn();
        String actualName = homePage.getUserName();
        CategoryList categoryList = homePage.choseCategory();
        String itemName = categoryList.getItemName();
        int itemPrice=categoryList.getItemPrice();
        itemPage itemPage = categoryList.selectItem();
        String actualItemName = itemPage.getItemTitle();
        System.out.println("actualItemName" + actualItemName);
        assertTrue(actualItemName.contains(itemName), "incorrect itemName name");
        itemPage.addItemToCart(2);
        ShoppingCart shoppingCart=itemPage.openCart();
        int totalPrice=shoppingCart.getTotal();
        int itemCount=shoppingCart.numberOfItemsInCart();
        int ExpectedTotal=itemCount*itemPrice;
        System.out.println("itemPrice= "+itemPrice+" itemCount= "+itemCount+" totalPrice= "+totalPrice+" ExpectedTotal= "+ExpectedTotal);
        assertEquals(totalPrice,ExpectedTotal, "incorrect total price");
        PlaceOrder placeOrder=shoppingCart.clickOnPlaceOrder();
        placeOrder.setName("Abdulmaged Abdullah");
        placeOrder.setCountry("Egypt");
        placeOrder.setCity("cairo");
        placeOrder.setCredit("111111111111");
        placeOrder.setMonth("jan");
        placeOrder.setYear("2023");
        placeOrder.clickOnPurchase();
        placeOrder.clickOnOk();

    }
@Test(dependsOnMethods ={"selectItem"})
    public void DeleteItem(){
    String validUserName = registration.userName;
    String validPassword = registration.password;
    if (validUserName == null) {
        validUserName = "Anna Adkins";
        validPassword = "abd123456";
    }
    Login login = homePage.clickOnLogin();
    login.setUserName(validUserName);
    login.setPassword(validPassword);
    homePage = login.clickOnLogIn();
    String actualName = homePage.getUserName();
    CategoryList categoryList = homePage.choseCategory();
    String itemName = categoryList.getItemName();
    int itemPrice=categoryList.getItemPrice();
    itemPage itemPage = categoryList.selectItem();
    String actualItemName = itemPage.getItemTitle();
    System.out.println("actualItemName" + actualItemName);
    assertTrue(actualItemName.contains(itemName), "incorrect itemName name");
    itemPage.addItemToCart(2);
    ShoppingCart shoppingCart=itemPage.openCart();
    int totalPrice=shoppingCart.getTotal();
    int itemCount=shoppingCart.numberOfItemsInCart();
    int ExpectedTotal=itemCount*itemPrice;
    System.out.println("itemPrice= "+itemPrice+" itemCount= "+itemCount+" totalPrice= "+totalPrice+" ExpectedTotal= "+ExpectedTotal);
    assertEquals(totalPrice,ExpectedTotal, "incorrect total price");
    shoppingCart.DeleteItem();
    int totalPriceAfterDelete=shoppingCart.getTotal();
    int itemCountAfterDelete=shoppingCart.numberOfItemsInCart();
    assertEquals(itemPrice*itemCountAfterDelete
            ,totalPriceAfterDelete,
            "incorrect total price");
}
}
