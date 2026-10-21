package tests;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.ConstructorPage;
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    public LoginTest(String browser) {
        super(browser);
    }

    private void loginAndCheck() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getEmail(), user.getPassword());

        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue("После входа должен открыться личный кабинет",
                profilePage.isProfilePageDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    public void loginFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        loginAndCheck();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromProfileButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickProfileButton();
        loginAndCheck();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterFormTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLink();

        loginAndCheck();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();

        loginAndCheck();
    }
}
