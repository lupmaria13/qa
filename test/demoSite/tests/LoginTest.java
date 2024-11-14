package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        driver.get(baseUrl + "/signin");

        // Crează instanța LoginPage și realizează login-ul
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("zebra", "zebrapassword");

        // Verifică dacă autentificarea a avut succes verificând un element specific
        WebElement profileElement = Utils.waitForElement(driver, 10, By.id("profile-icon")); // Înlocuiește "profile-icon" cu ID-ul corect
        Assert.assertTrue(profileElement.isDisplayed(), "Elementul de profil ar trebui să fie afișat după login.");
    }

    @Test
    public void unsuccessfulLoginTest() {
        driver.get(baseUrl + "/signin");

        // Crează instanța LoginPage și introduce date incorecte
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "wrongPassword");

        // Verifică mesajul de eroare
        WebElement errorMessage = Utils.waitForElement(driver, 10, By.id("login-error")); // Înlocuiește "login-error" cu ID-ul corect
        Assert.assertTrue(errorMessage.isDisplayed(), "Mesajul de eroare ar trebui să fie afișat pentru credențiale incorecte.");
    }
}
