package org.artevseev.config;

import org.artevseev.Pages.LoginPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Login {
    public static void login(Config config, WebDriver driver){

        driver.get(config.getLoginPage());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin(config.getLogin());
        loginPage.inputPassword(config.getPassword());
        loginPage.clickLoginButton();

    }
}
