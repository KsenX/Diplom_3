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
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;
import praktikum.pom.RegistrationPage;
import praktikum.pom.RestorePasswordPage;
import praktikum.rest.LoginProvider;
import praktikum.rest.UserClient;

public class TestLogin {

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
        driver = new ChromeDriver(options);

        //создать пользователя для тестов
        token = userClient.register(user)
                .statusCode(200)
                .extract().jsonPath().get("accessToken");
        Login login = LoginProvider.getLogin(user.getEmail(), user.getPassword());
    }

    //    Вход
//Проверь:
//вход по кнопке «Войти в аккаунт» на главной,
    @Test
    public void loginToAccountFromMainPage() {

        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());


    }

    //вход через кнопку «Личный кабинет»,
    @Test
    public void loginToAccountFromAccount() {


        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());


    }

    //вход через кнопку в форме регистрации,
    @Test
    public void loginFromRegistrationPage() {


        driver.get("https://stellarburgers.nomoreparties.site/register");


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


        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.clickEnterLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());


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
