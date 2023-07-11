package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.dataprovider.UserProvider;
import praktikum.pojo.User;
import praktikum.pom.LoginPage;
import praktikum.pom.MainPage;
import praktikum.pom.RegistrationPage;

public class TestRegistration extends BaseTest {
//    Регистрация
//Проверь:
//Успешную регистрацию.

    @Test
    public void registrationSuccessful() {
        // переход на страницу тестового приложения
        driver.get(BASE_PATH + "/register");
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
        driver.get(BASE_PATH + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        User user = UserProvider.getRandomUserWithTooShortPassword();
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertTrue(registrationPage.checkPasswordError());

    }

}
