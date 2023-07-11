package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.pom.MainPage;

public class TestBurgerConstructor extends BaseTest {
//    Раздел «Конструктор»
//    Проверь, что работают переходы к разделам:
//            «Булки»,
//            «Соусы»,
//            «Начинки».

    @Test
    public void clickChooseBunsWorks() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonIngredient();
        mainPage.clickButtonBun();
        Assert.assertTrue(mainPage.checkBunIsChosen());

    }

    @Test
    public void clickChooseSauceWorks() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonSauce();
        Assert.assertTrue(mainPage.checkSauceIsChosen());

    }

    @Test
    public void clickChooseIngredientWorks() {
        driver.get(BASE_PATH);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickButtonIngredient();
        Assert.assertTrue(mainPage.checkIngredientIsChosen());

    }

}
