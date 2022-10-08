package org.artevseev.threads;

import org.artevseev.config.Config;
import org.artevseev.config.Login;
import org.artevseev.funcs.ShowScores;
import org.artevseev.links.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class NewShowScoreThread implements Runnable{
    Thread t;
    Config config;
    Parameters parameters;

    NewShowScoreThread(String name, Config config, Parameters parameters){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = parameters;
        t.start();
    }

    NewShowScoreThread(String name, Config config, String link){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = new Parameters(link);
        t.start();
    }

    @Override
    public void run() {
        FirefoxOptions op = new FirefoxOptions();
        op.setCapability("pageLoadStrategy", "eager");  // Without full loading
        op.addArguments("--headless");  // Without GUI
        WebDriver driver = new FirefoxDriver(op); // Init driver

        Login.login(config, driver);

        ShowScores.showAllScores(driver, parameters);
    }
}