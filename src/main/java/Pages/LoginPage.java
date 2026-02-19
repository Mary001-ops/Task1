package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //ElementLocators
    private static By usernameField = By.id("user-name");
    private static By passwordField = By.id("password");
    private static By loginButton = By.id("login-button");
    private static By errorMessage = By.xpath("//h3[@data-test='error']");

    //Static Locators
    private static String userNameErrorMessageLocator = "Epic sadface: Username is required\n";
    private static String passwordErrorMessageLocator = "Epic sadface: Password is required\n";

   //Action Methods

    public LoginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
    //Validation Methods

   /* public boolean getUserNameErrorMessage() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    */

    public LoginPage getUserNameErrorMessage() {
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        return this;
    }


    public LoginPage getPasswordErrorMessage() {
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        return this;
    }
}