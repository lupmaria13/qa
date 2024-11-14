package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user"); // Selector pentru Username
    private By passwordField = By.id("pass"); // Selector pentru Password
    private By rememberMeCheckbox = By.cssSelector("input[type='checkbox']"); // Selector pentru checkbox-ul Remember Me
    private By signInButton = By.cssSelector("button.btn.btn-primary"); // Selector pentru butonul Sign in

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        Utils.waitForElement(driver, 5, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        Utils.waitForElement(driver, 5, passwordField).sendKeys(password);
    }

    public void selectRememberMe() {
        Utils.waitForElement(driver, 5, rememberMeCheckbox).click();
    }

    public void clickSignIn() {
        Utils.waitForElement(driver, 5, signInButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }
}
