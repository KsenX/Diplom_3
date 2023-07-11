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

    //Локатор для проверки, выбраны ли Булки
    private By divBun = By.xpath(".//span[text()='Булки']/parent::div");
    //Локатор для проверки, выбраны ли Соусы
    private By divSauce = By.xpath(".//span[text()='Соусы']/parent::div");
    //Локатор для проверки, выбраны ли Начинки
    private By divIngredient = By.xpath(".//span[text()='Начинки']/parent::div");

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

    //Функция проверить выбраны ли Булки
    public Boolean checkBunIsChosen() {
        return driver.findElement(divBun).getAttribute("class").contains("current");
    }

    //Функция проверить выбраны ли Соусы
    public Boolean checkSauceIsChosen() {
        return driver.findElement(divSauce).getAttribute("class").contains("current");
    }

    //Функция проверить выбраны ли Начинки
    public Boolean checkIngredientIsChosen() {
        return driver.findElement(divIngredient).getAttribute("class").contains("current");
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
