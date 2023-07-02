package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.pom.MainPage;

public class TestBurgerConstructor {

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
//    Раздел «Конструктор»
//    Проверь, что работают переходы к разделам:
//            «Булки»,
//            «Соусы»,
//            «Начинки».

    @Test
    public void clickChooseBunsWorks() {


        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonIngredient();
        mainPage.clickButtonBun();
        Assert.assertTrue(mainPage.checktextBun());


    }

    @Test
    public void clickChooseSauceWorks() {


        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);


        mainPage.clickButtonSauce();
        Assert.assertTrue(mainPage.checktextSauce());


    }

    @Test
    public void clickChooseIngredientWorks() {


        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonIngredient();
        Assert.assertTrue(mainPage.checktextIngredient());


    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
