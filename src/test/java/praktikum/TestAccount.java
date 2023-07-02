package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.dataprovider.UserProvider;
import praktikum.pojo.Login;
import praktikum.pojo.User;
import praktikum.pom.AccountPage;
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;
import praktikum.rest.LoginProvider;
import praktikum.rest.UserClient;

public class TestAccount {

    private WebDriver driver;
    private String token;
    UserClient userClient = new UserClient();
    User user = UserProvider.getRandomUser();

    @Before
    public void warmup() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        String yandexDriverPath="C:\\WebDriver\\yandexdriver-23.5.0.2199-win64\\yandexdriver.exe";
//        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        driver= new ChromeDriver(options);

        //создать пользователя для тестов
        token = userClient.register(user)
                .statusCode(200)
                .extract().jsonPath().get("accessToken");
        Login login = LoginProvider.getLogin(user.getEmail(), user.getPassword());


    }

    //    Переход в личный кабинет
//Проверь переход по клику на «Личный кабинет».
    @Test
    public void goToAccountFromMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site");
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
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLinkConstructor();
        Assert.assertTrue(mainPage.checktextBun());

    }

    @Test
    public void goFromAccountToMainPageClickLogo() {
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogoStellarBurgers();
        Assert.assertTrue(mainPage.checktextBun());
    }

    //Выход из аккаунта
//Проверь выход по кнопке «Выйти» в личном кабинете.
    @Test
    public void exitFromAccount() {

        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickButtonAccount();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickExitButton();

        Assert.assertTrue(loginPage.loginButtonLoginPageDisplayed());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();

        //удалить пользователя
        if (token != null) {
            userClient.delete(token)
                    .statusCode(202);
        }

    }
}