
package juiceShop.tests;

import juiceShop.frameworkUtils.Selectors;
import juiceShop.frameworkUtils.Utils;
import juiceShop.pages.LoginPage;
import juiceShop.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegisterTest extends BaseTest {

    @DataProvider(name = "RegistrationDataProvider")
    public Iterator<Object[]> registerDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"alex@alex.com", "Alex98876%", "alex"});
        return dp.iterator();
    }

    @Test(dataProvider = "RegistrationDataProvider")
    public void positiveRegistrationTest(String username, String password, String securityAns) {
        driver.get(baseUrl + "/#/login");

        LoginPage lp = new LoginPage(driver);
        lp.awaitDismissModal();
        lp.newUser();

        RegistrationPage rp = new RegistrationPage(driver);
        Assert.assertEquals(rp.getRegisterHeader(), rp.getRegisterPageStatic());

        rp.register(username, password, securityAns);
    }

    @DataProvider(name = "NegativeRegistrationDataProvider")
    public Iterator<Object[]> negativeRegisterDp() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new Object[]{"", "invalidPassword", "answer", "Email is required"}); // Exemplu pentru email lipsă
        dp.add(new Object[]{"test@test.com", "", "answer", "Password is required"}); // Exemplu pentru parolă lipsă
        dp.add(new Object[]{"test@test.com", "password", "", "Security answer is required"}); // Exemplu pentru răspuns lipsă
        return dp.iterator();
    }

    @Test(dataProvider = "NegativeRegistrationDataProvider")
    public void negativeRegistrationTest(String username, String password, String securityAns, String expectedErrorMsg) {
        driver.get(baseUrl + "/#/login");

        LoginPage lp = new LoginPage(driver);
        lp.awaitDismissModal();
        lp.newUser();

        RegistrationPage rp = new RegistrationPage(driver);
        Assert.assertEquals(rp.getRegisterHeader(), rp.getRegisterPageStatic());

        rp.register(username, password, securityAns);

        WebElement errorElement = driver.findElement(By.cssSelector("selector-ul-mesajului-de-eroare"));
        String actualErrorMsg = errorElement.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Mesajul de eroare neasteptat.");
    }

    @AfterMethod
    public void closeBrowser() {
        try {
            driver.close();
        } catch (Exception ex) {
            driver.quit();
        }
    }
}