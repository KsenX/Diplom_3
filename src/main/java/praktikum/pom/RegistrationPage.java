package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для поля имя
    private By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    //Локатор для поля имейл
    private By emailInput = By.xpath(".//label[text()='Email']/parent::div/input");
    //Локатор для поля пароль
    private By passwordInput = By.xpath(".//label[text()='Пароль']/parent::div/input");
    //Локатор для кнопки Зарегистрироваться
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Локатор для сообщения об ошибке "Некорректный пароль"
    private By errorPassword = By.xpath(".//p[text()='Некорректный пароль']");

    //Локатор для ссылки Войти
    private By enterLink = By.xpath(".//a[text()='Войти']");

    //Функция нажать на кнопку Войти
    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

    //Функция ввод имени
    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    //Функция ввод имейла
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    //Функция ввод пароля
    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Функция нажатия на кнопку Зарегистрироваться
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public Boolean checkPasswordError() {
        return driver.findElement(errorPassword).isDisplayed();
    }


    //Функция зарегистрироваться
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }


}
