package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;
import praktikum.pom.RegistrationPage;
import praktikum.pom.RestorePasswordPage;

public class TestLogin extends BaseTest {

    //    Вход
//Проверь:
//вход по кнопке «Войти в аккаунт» на главной,
    @Test
    public void loginToAccountFromMainPage() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());

    }

    //вход через кнопку «Личный кабинет»,
    @Test
    public void loginToAccountFromAccount() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());

    }

    //вход через кнопку в форме регистрации,
    @Test
    public void loginFromRegistrationPage() {
        driver.get(BASE_PATH + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickEnterLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());

    }

    //вход через кнопку в форме восстановления пароля.
    @Test
    public void loginFromRestorePasswordPage() {
        driver.get(BASE_PATH + "/forgot-password");
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.clickEnterLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());

    }

}
