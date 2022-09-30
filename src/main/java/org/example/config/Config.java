package org.example.config;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@Getter
public class Config {
    private final String login;
    private final String password;
    private final String loginPage;
    private final String driverPath;

    private final WebDriver driver;

    public Config(String login, String password, String loginPage, String driverPath) {
        this.login = login;
        this.password = password;
        this.loginPage = loginPage;
        this.driverPath = driverPath;

        System.setProperty("webdriver.gecko.driver", driverPath);
        this.driver = new FirefoxDriver(); // Init driver

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

}
