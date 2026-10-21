package tests;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTabsTest extends BaseTest {

    public ConstructorTabsTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void openBunsTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBunsTab();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertEquals("Активным должен стать раздел «Булки»",
                "Булки", constructorPage.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void openSaucesTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesTab();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertEquals("Активным должен стать раздел «Соусы»",
                "Соусы", constructorPage.getActiveTabText());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void openFillingsTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsTab();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertEquals("Активным должен стать раздел «Начинки»",
                "Начинки", constructorPage.getActiveTabText());
    }
}
