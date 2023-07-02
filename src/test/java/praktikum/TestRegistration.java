package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.dataprovider.UserProvider;
import praktikum.pojo.User;
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;
import praktikum.pom.RegistrationPage;

public class TestRegistration {

    private WebDriver driver;

    @Before
    public void warmup() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        String yandexDriverPath="C:\\WebDriver\\yandexdriver-23.5.0.2199-win64\\yandexdriver.exe";
//        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        driver = new ChromeDriver(options);
    }


//    Регистрация
//Проверь:
//Успешную регистрацию.


    @Test
    public void registrationSuccessful() {


        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        User user = UserProvider.getRandomUser();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.checkCreateOrderButtonIsShown());


    }

    //Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
    @Test
    public void registrationNotSuccessfulWithShortPassword() {


        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        User user = UserProvider.getRandomUserWithTooShortPassword();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertTrue(registrationPage.checkPasswordError());


    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
