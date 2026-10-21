package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By profileButton = By.xpath(".//p[text()='Личный кабинет']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logo = By.xpath(".//div[contains(@class,'AppHeader_header__logo')]");
    private final By bunsTab = By.xpath(".//span[text()='Булки']");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']");
    private final By activeTab = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get("https://qa-stellarburgers.education-services.ru/");
    }

    @Step("Нажать «Войти в аккаунт»")
    public void clickLoginButton() {
        clickClickable(loginButton);
    }

    @Step("Нажать «Личный кабинет»")
    public void clickProfileButton() {
        clickClickable(profileButton);
    }

    @Step("Нажать «Конструктор»")
    public void clickConstructorButton() {
        clickClickable(constructorButton);
    }

    @Step("Нажать логотип Stellar Burgers")
    public void clickLogo() {
        clickClickable(logo);
    }

    @Step("Открыть раздел «Булки»")
    public void clickBunsTab() {
        clickTab(bunsTab);
    }

    @Step("Открыть раздел «Соусы»")
    public void clickSaucesTab() {
        clickTab(saucesTab);
    }

    @Step("Открыть раздел «Начинки»")
    public void clickFillingsTab() {
        clickTab(fillingsTab);
    }

    @Step("Получить название активного раздела конструктора")
    public String getActiveTabText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(activeTab))
                .getText();
    }

    @Step("Проверить, что отображается кнопка «Войти в аккаунт»")
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton))
                .isDisplayed();
    }

    private void clickClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    private void clickTab(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath(".//div[contains(@class,'Modal_modal__overlay')]")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }
}