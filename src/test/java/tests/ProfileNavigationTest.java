package tests;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import static org.junit.Assert.assertTrue;

public class ProfileNavigationTest extends BaseTest {

    public ProfileNavigationTest(String browser) {
        super(browser);
    }

    private void login() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());
    }

    @Test
    @DisplayName("Переход в личный кабинет по кнопке «Личный кабинет»")
    public void openProfileTest() {
        login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue("Должен открыться личный кабинет", profilePage.isProfilePageDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по кнопке «Конструктор»")
    public void navigateToConstructorFromProfileTest() {
        login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        mainPage.clickConstructorButton();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertTrue("Должен открыться конструктор", constructorPage.isConstructorDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по логотипу")
    public void navigateToConstructorByLogoTest() {
        login();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        mainPage.clickLogo();

        ConstructorPage constructorPage = new ConstructorPage(driver);
        assertTrue("После клика по логотипу должен открыться конструктор",
                constructorPage.isConstructorDisplayed());
    }
}
