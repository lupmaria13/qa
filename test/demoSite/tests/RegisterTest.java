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

        // Crează instanța RegistrationPage și realizează înregistrarea
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("newUser", "newuser@example.com", "newpassword");

        // Verifică dacă înregistrarea a avut succes (de exemplu, că utilizatorul a fost redirecționat la pagina de login)
        WebElement successMessage = Utils.waitForElement(driver, 10, By.id("success-message")); // Înlocuiește "success-message" cu selectorul corect dacă e necesar
        Assert.assertTrue(successMessage.isDisplayed(), "Mesajul de succes ar trebui să fie afișat după înregistrare.");
    }

    @Test
    public void unsuccessfulRegistrationTest() {
        driver.get(baseUrl + "/register");

        // Crează instanța RegistrationPage și introduce date invalide (de exemplu, un email deja existent)
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("existingUser", "existinguser@example.com", "password123");

        // Verifică mesajul de eroare pentru înregistrare eșuată
        WebElement errorMessage = Utils.waitForElement(driver, 10, By.id("error-message")); // Înlocuiește "error-message" cu selectorul corect dacă e necesar
        Assert.assertTrue(errorMessage.isDisplayed(), "Mesajul de eroare ar trebui să fie afișat pentru înregistrare eșuată.");
    }
}
