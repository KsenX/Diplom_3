package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки войти в аккаунт
    private By loginButtonMainPage = By.xpath(".//button[text()='Войти в аккаунт']");

    //Локатор для кнопки оформить заказ
    private By createOrderMainPage = By.xpath(".//button[text()='Оформить заказ']");

    //Локатор для кнопки Личный кабинет
    private By buttonAccount = By.xpath(".//p[text()='Личный Кабинет']");

    //Локатор для кнопки Булки
    private By buttonBun = By.xpath(".//span[text()='Булки']");
    //Локатор для кнопки Соусы
    private By buttonSauce = By.xpath(".//span[text()='Соусы']");
    //Локатор для кнопки Начинки
    private By buttonIngredient = By.xpath(".//span[text()='Начинки']");

    //Локатор для текста Булки
    private By textBun = By.xpath(".//h2[text()='Булки']");
    //Локатор для текста Соусы
    private By textSauce = By.xpath(".//h2[text()='Соусы']");
    //Локатор для текста Начинки
    private By textIngredient = By.xpath(".//h2[text()='Начинки']");

    //Функция нажать на Булки
    public void clickButtonBun() {
        driver.findElement(buttonBun).click();

    }

    //Функция нажать на Соусы
    public void clickButtonSauce() {
        driver.findElement(buttonSauce).click();

    }

    //Функция нажать на Начинки
    public void clickButtonIngredient() {
        driver.findElement(buttonIngredient).click();

    }

    //Функция проверить отображаются ли Булки
    public Boolean checktextBun() {
        return driver.findElement(textBun).isDisplayed();
    }

    //Функция проверить отображаются ли Соусы
    public Boolean checktextSauce() {
        return driver.findElement(textSauce).isDisplayed();
    }

    //Функция проверить отображаются ли Начинки
    public Boolean checktextIngredient() {
        return driver.findElement(textIngredient).isDisplayed();
    }

    //Функция проверить отображается ли кнопка Оформить заказ
    public Boolean checkCreateOrderButtonIsShown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderMainPage));
        return driver.findElement(createOrderMainPage).isDisplayed();
    }

    //Функция нажать на кнопку войти в аккаунт
    public void clickLoginButtonMainPage() {
        driver.findElement(loginButtonMainPage).click();
    }

    //Функция нажать на кнопку Личный кабинет
    public void clickButtonAccount() {
        driver.findElement(buttonAccount).click();
    }

}
