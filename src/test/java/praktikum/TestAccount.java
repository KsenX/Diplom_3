package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.AccountPage;
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;

public class TestAccount extends BaseTest {

    //    Переход в личный кабинет
//Проверь переход по клику на «Личный кабинет».
    @Test
    public void goToAccountFromMainPage() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLinkConstructor();
        mainPage.clickButtonAccount();
        Assert.assertTrue(accountPage.checkInfoYouMayChangeDataIsShown());

    }

    //Переход из личного кабинета в конструктор
//Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
    @Test
    public void goFromAccountToMainPageClickConstructor() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLinkConstructor();
        Assert.assertTrue(mainPage.checkBunIsChosen());

    }

    @Test
    public void goFromAccountToMainPageClickLogo() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogoStellarBurgers();
        Assert.assertTrue(mainPage.checkBunIsChosen());
    }

    //Выход из аккаунта
//Проверь выход по кнопке «Выйти» в личном кабинете.
    @Test
    public void exitFromAccount() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickExitButton();
        Assert.assertTrue(loginPage.loginButtonLoginPageDisplayed());
    }

}