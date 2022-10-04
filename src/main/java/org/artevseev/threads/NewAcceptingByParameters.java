package org.artevseev.threads;

import org.artevseev.config.Config;
import org.artevseev.config.Login;
import org.artevseev.funcs.AcceptWorksByParameters;
import org.artevseev.links.LinkWithParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class NewAcceptingByParameters implements Runnable{
    Thread t;
    Config config;
    Parameters parameters;

    public NewAcceptingByParameters(String name, Config config, Parameters parameters){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = parameters;
        t.start();
    }

    NewAcceptingByParameters(String name, Config config, String link){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = new LinkWithParameters(link)
                .getParameters();
        t.start();
    }

    @Override
    public void run() {
        FirefoxOptions op = new FirefoxOptions();
        op.addArguments("--headless");  // Without GUI
        WebDriver driver = new FirefoxDriver(op); // Init driver


        Login.login(config, driver);

        AcceptWorksByParameters.acceptAllWorks(driver, parameters);
    }
}