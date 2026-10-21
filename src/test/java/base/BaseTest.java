package base;

import io.qameta.allure.Step;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@RunWith(Parameterized.class)
public abstract class BaseTest {

    protected static final String BASE_URL =
            "https://qa-stellarburgers.education-services.ru/";

    protected final String browser;
    protected WebDriver driver;
    protected User user;

    @Parameterized.Parameters(name = "Браузер: {0}")
    public static Object[][] browsers() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    protected BaseTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        driver = createDriver(browser);
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        user = User.random();
        new client.UserClient().create(user);
    }

    @Step("Создать браузер: {browser}")
    private WebDriver createDriver(String browser) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-search-engine-choice-screen");

        if ("yandex".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
            return new ChromeDriver(options);
        }

        return new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        try {
            if (user != null) {
                new client.UserClient().delete(user);
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}