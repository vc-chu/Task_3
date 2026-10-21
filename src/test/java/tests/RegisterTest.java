package tests;

import base.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    public RegisterTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Успешная регистрация нового пользователя")
    public void successfulRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        assertTrue("После успешной регистрации должна открыться страница входа",
                loginPage.isLoginPageDisplayed());
    }

    @Test
    @DisplayName("Ошибка при регистрации с паролем короче шести символов")
    public void shortPasswordRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getName(), user.getEmail(), "12345");

        assertTrue("Должна отображаться ошибка «Некорректный пароль»",
                registerPage.isPasswordErrorDisplayed());
    }
}
