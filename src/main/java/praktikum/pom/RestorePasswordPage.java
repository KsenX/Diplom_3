package praktikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор для кнопки вспомнили пароль - войти
    private By enterLink = By.xpath(".//a[text()='Войти']");

    //Функция нажать на кнопку вспомнили пароль - войти
    public void clickEnterLink() {
        driver.findElement(enterLink).click();
    }

}
