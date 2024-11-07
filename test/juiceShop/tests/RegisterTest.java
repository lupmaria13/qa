//package juiceShop.tests;
//
//import juiceShop.frameworkUtils.Selectors;
//import juiceShop.frameworkUtils.Utils;
//import juiceShop.pages.LoginPage;
//import juiceShop.pages.RegistrationPage;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Iterator;
//
////public class RegisterTest {
////    static final String baseUrl = Utils.getConfigProperty("baseUrl");
////    WebDriver driver;
////    @BeforeMethod
////    public void initDriver() {
////        // OLD version !! Do not use unless the server you are testing does not have internet
//////        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myuser\\Downloads\\chromedirver.exe");
////        driver = Utils.getDriver();
////    }
//    public class RegisterTest extends BaseTest{
//
//        @DataProvider(name = "RegistrationDataProvider")
//        public Iterator<Object[]> registerDp () {
//            Collection<Object[]> dp = new ArrayList<>();
//            dp.add(new String[] {"alex@alex.com", "Alex98876%", "alex"});
//            return dp.iterator();
//        }
//
//        @Test(dataProvider = "RegistrationDataProvider")
//        //public void loginRegister(String username, String password, String securityAns) {
//            public void loginRegister2(String username, String password, String securityAns) {
//                driver.get(baseUrl + "/#/login");
////                WebElement dismissModalElement = Utils.waitForElement(driver, 5,
////                        By.cssSelector(Selectors.MODAL_OK_BUTTON)
////                );
////                dismissModalElement.click();
////                WebElement registerLink = driver.findElement(By.cssSelector(Selectors.REGISTER_URL));
////                registerLink.click();
////                Assert.assertEquals(
////                        driver.findElement(By.cssSelector(Selectors.REGISTER_HEADER)).getText(),
////                        "User Registration"
////                );
////                WebElement usernameElement = driver.findElement(By.id(Selectors.REGISTER_EMAIL));
////                usernameElement.clear();
////                usernameElement.sendKeys("alex@alex.com");
////                WebElement passwordElement = driver.findElement(By.id(Selectors.REGISTER_PASSWORD));
////                passwordElement.clear();
////                passwordElement.sendKeys("Alex98765$");
////                WebElement passwordConfirm = driver.findElement(By.id(Selectors.REGISTER_CONFIRM));
////                passwordConfirm.clear();
////                passwordConfirm.sendKeys("Alex98765$");
////                WebElement securityQuestion = Utils.waitForElement(driver, 5,
////                        By.cssSelector(Selectors.SECURITY_QUESTION)
////                );
////                securityQuestion.click();
////                WebElement securityQuestionChoice = driver.findElement(By.cssSelector(Selectors.SECURITY_OPTION1));
////                securityQuestionChoice.click();
////                WebElement securityAnswer = driver.findElement(By.id(Selectors.SECURITY_ANSWER));
////                securityAnswer.clear();
////                securityAnswer.sendKeys("alex");
////                WebElement submitButton = driver.findElement(By.id(Selectors.REGISTER_SUBMIT_BUTTON));
////                submitButton.click();
////            }
////            @AfterMethod
////            public void closeBrowser() {
////                try {
////                    driver.close();
////                }
////                catch (Exception ex) {
////                    driver.quit();
////                }
//                LoginPage lp = new LoginPage(driver);
//                lp.awaitDismissModal();
//                lp.newUser();
//                RegistrationPage rp = new RegistrationPage(driver);
//                Assert.assertEquals(rp.getRegisterHeader(), rp.getRegisterPageStatic());
//                rp.register(username, password, securityAns);
//            }
//
//        }

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

        // Verificăm dacă apare mesajul de eroare
        WebElement errorElement = driver.findElement(By.cssSelector("selector-ul-mesajului-de-eroare"));
        String actualErrorMsg = errorElement.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Mesajul de eroare nu este cel așteptat.");
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