package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для поля имейл
    private By emailInput = By.xpath(".//label[text()='Email']/parent::div/input");

    //Локатор для поля пароль
    private By passwordInput = By.xpath(".//label[text()='Пароль']/parent::div/input");

    //Локатор для кнопки Войти
    private By loginButton = By.xpath(".//button[text()='Войти']");

    //Функция ввод имейла
    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(emailInput).sendKeys(email);
    }

    //Функция ввод пароля
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Функция нажатия на кнопку Войти
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public Boolean loginButtonLoginPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).isDisplayed();
    }

    //Функция войти в аккаунт
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}
