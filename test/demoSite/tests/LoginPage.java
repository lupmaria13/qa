package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Selectori pentru elementele din pagina de Login
    private By usernameField = By.id("user"); // Selector pentru Username
    private By passwordField = By.id("pass"); // Selector pentru Password
    private By rememberMeCheckbox = By.cssSelector("input[type='checkbox']"); // Selector pentru checkbox-ul Remember Me
    private By signInButton = By.cssSelector("button.btn.btn-primary"); // Selector pentru butonul Sign in

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodă pentru a introduce username-ul
    public void enterUsername(String username) {
        Utils.waitForElement(driver, 5, usernameField).sendKeys(username);
    }

    // Metodă pentru a introduce parola
    public void enterPassword(String password) {
        Utils.waitForElement(driver, 5, passwordField).sendKeys(password);
    }

    // Metodă pentru a da click pe butonul "Remember me"
    public void selectRememberMe() {
        Utils.waitForElement(driver, 5, rememberMeCheckbox).click();
    }

    // Metodă pentru a da click pe butonul "Sign in"
    public void clickSignIn() {
        Utils.waitForElement(driver, 5, signInButton).click();
    }

    // Metodă pentru a efectua login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }
}
