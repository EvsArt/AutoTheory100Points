package org.example.config;

import org.example.Pages.LoginPage;

public class Login {
    public static void login(Config config){

        config.getDriver().get(config.getLoginPage());
        LoginPage loginPage = new LoginPage(config.getDriver());
        loginPage.inputLogin(config.getLogin());
        loginPage.inputPassword(config.getPassword());
        loginPage.clickLoginButton();

    }
}
