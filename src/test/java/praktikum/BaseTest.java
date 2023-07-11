package praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.configuration.ConfigFileReader;
import praktikum.dataprovider.UserProvider;
import praktikum.pojo.User;
import praktikum.rest.UserClient;

public class BaseTest {

    final static String BASE_PATH = "https://stellarburgers.nomoreparties.site";
    protected WebDriver driver;
    private String token;
    UserClient userClient = new UserClient();
    User user = UserProvider.getRandomUser();

    @Before
    public void warmup() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ConfigFileReader configFileReader = new ConfigFileReader();
        if (configFileReader.getBrowser().equals("yandex")) {
            String yandexDriverPath = configFileReader.getYandexPath();
            System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        } else if (configFileReader.getBrowser().equals("chrome")) {
        } else throw new IllegalArgumentException("Browser type not supported: " + configFileReader.getBrowser());
        driver = new ChromeDriver(options);
        //создать пользователя для тестов
        token = userClient.register(user)
                .statusCode(200)
                .extract().jsonPath().get("accessToken");

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
        //удалить пользователя
        if (token != null) {
            userClient.delete(token)
                    .statusCode(202);
        }

    }
}
