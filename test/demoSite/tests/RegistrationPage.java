package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    // Selectori pentru elementele din pagina de Registration
    private By usernameField = By.cssSelector("input[placeholder='Username']"); // Selector pentru Username
    private By emailField = By.cssSelector("input[placeholder='Email']"); // Selector pentru Email
    private By passwordField = By.cssSelector("input[placeholder='Password']"); // Selector pentru Password
    private By registerButton = By.cssSelector("button[type='submit']"); // Selector pentru butonul Register

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodă pentru a introduce username-ul
    public void enterUsername(String username) {
        Utils.waitForElement(driver, 5, usernameField).sendKeys(username);
    }

    // Metodă pentru a introduce email-ul
    public void enterEmail(String email) {
        Utils.waitForElement(driver, 5, emailField).sendKeys(email);
    }

    // Metodă pentru a introduce parola
    public void enterPassword(String password) {
        Utils.waitForElement(driver, 5, passwordField).sendKeys(password);
    }

    // Metodă pentru a da click pe butonul de înregistrare
    public void clickRegister() {
        Utils.waitForElement(driver, 5, registerButton).click();
    }

    // Metodă pentru a completa formularul de înregistrare
    public void register(String username, String email, String password) {
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        clickRegister();
    }
}
