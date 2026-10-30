package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {

    private final WebDriver driver;

    private final By bunsSection = By.xpath(".//h2[text()='Булки']");
    private final By saucesSection = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsSection = By.xpath(".//h2[text()='Начинки']");
    private final By activeTab = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить, что открыт конструктор")
    public boolean isConstructorDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(bunsSection))
                .isDisplayed();
    }

    @Step("Получить название активного раздела")
    public String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }
}
