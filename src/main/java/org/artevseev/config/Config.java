package org.artevseev.config;

import lombok.Getter;

@Getter
public class Config {
    private final String login;
    private final String password;
    private final String loginPage;

    public Config(String login, String password, String loginPage, String driverPath) {
        this.login = login;
        this.password = password;
        this.loginPage = loginPage;
    }

}
