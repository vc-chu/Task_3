package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;

    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By profileHeader = By.xpath(".//a[text()='Профиль']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить, что открыт личный кабинет")
    public boolean isProfilePageDisplayed() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileHeader))
                .isDisplayed();
    }

    @Step("Нажать «Выход»")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
