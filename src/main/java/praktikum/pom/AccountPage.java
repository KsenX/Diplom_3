package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для поля имя
    private By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");

    //Локатор для кнопки конструктор
    private By linkConstructor = By.xpath(".//p[text()='Конструктор']");

    //Локатор для логотипа Stellar Burgers
    private By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    //Локатор для кнопки выход
    private By exitButton = By.xpath(".//button[text()='Выход']");

    //Локатор для информации о том, что вы этом разделе вы можете изменить свои личные данные
    private By infoYouMayChangeData = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //TODO Функция проверить имя - не надо ли нормально сравнить имя
    public Boolean checkNameInput() {
        return driver.findElement(nameInput).isDisplayed();
    }

    //Функция нажать на конструктор
    public void clickLinkConstructor() {
        driver.findElement(linkConstructor).click();
    }

    //Функция нажать на логотип Stellar Burgers
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    //Функция нажать на кнопку выход
    public void clickExitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        driver.findElement(exitButton).click();
    }

    //Проверить, что показывается информация о том, что в этом разделе вы можете изменить свои личные данные
    public Boolean checkInfoYouMayChangeDataIsShown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(infoYouMayChangeData));
        return driver.findElement(infoYouMayChangeData).isDisplayed();
    }

}
