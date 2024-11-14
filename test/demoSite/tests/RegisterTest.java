package demoSite.tests;

import juiceShop.frameworkUtils.Utils;
import juiceShop.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void successfulRegistrationTest() {
        driver.get(baseUrl + "/register"); // Asigură-te că URL-ul este corect pentru pagina de înregistrare

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("newUser", "newuser@example.com", "newpassword");

        WebElement successMessage = Utils.waitForElement(driver, 10, By.id("success-message")); // Înlocuiește "success-message" cu selectorul corect dacă e necesar
        Assert.assertTrue(successMessage.isDisplayed(), "Mesajul de succes ar trebui să fie afișat după înregistrare.");
    }

    @Test
    public void unsuccessfulRegistrationTest() {
        driver.get(baseUrl + "/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("existingUser", "existinguser@example.com", "password123");

        WebElement errorMessage = Utils.waitForElement(driver, 10, By.id("error-message")); // Înlocuiește "error-message" cu selectorul corect dacă e necesar
        Assert.assertTrue(errorMessage.isDisplayed(), "Mesajul de eroare ar trebui să fie afișat pentru înregistrare eșuată.");
    }
}
