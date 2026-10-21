package tests;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    public LogoutTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выход»")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        mainPage.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();

        assertTrue("После выхода должна открыться страница входа",
                loginPage.isLoginPageDisplayed());
    }
}
