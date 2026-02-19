package Tests;

import Base.BaseTest;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    String ValidUsername;
    String ValidPassword;
    String InvalidUsername;
    String InvalidPassword;


    @BeforeMethod(alwaysRun = true)
    public void beforMethod(Method method){
        loginPage=new LoginPage(driver);
        inventoryPage=new InventoryPage(driver);

        System.out.println("Before method: " + method.getName());

        ValidUsername=data.getData("loginWithValidCredentials","ValidUsername");
        ValidPassword=data.getData("loginWithValidCredentials","ValidPassword");

        InvalidUsername=data.getData("loginWithInvalidUserName","InvalidUsername");
        ValidPassword=data.getData("loginWithInvalidUserName","ValidPassword");

       ValidUsername=data.getData("loginWithInvalidPassword","ValidUsername");
       InvalidPassword=data.getData("loginWithInvalidPassword","InvalidPassword");

    }
    @Test

    public void loginWithValidCredentials(){
        loginPage.enterUsername(ValidUsername)
                .enterPassword(ValidPassword)
                .clickLoginButton();

    }
    @Test
    public void loginWithInvalidUserName(){
        loginPage.enterUsername(InvalidUsername)
                .enterUsername(ValidPassword)
                .clickLoginButton()
                .getUserNameErrorMessage();

    }
    @Test
    public void loginWithInvalidPassword(){
        loginPage.enterUsername(ValidUsername)
                .enterPassword(InvalidPassword)
                .clickLoginButton()
                .getPasswordErrorMessage();
    }
}
