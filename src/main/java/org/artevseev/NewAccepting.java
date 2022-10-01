package org.artevseev;

import org.artevseev.config.Config;
import org.artevseev.config.Login;
import org.artevseev.funcs.AcceptWorksByParameters;
import org.artevseev.links.LinkWithParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccepting implements Runnable{
    Thread t;
    Config config;
    Parameters parameters;

    NewAccepting(String name, Config config, Parameters parameters){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = parameters;
        t.start();
    }

    NewAccepting(String name, Config config, String link){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = new LinkWithParameters(link)
                .getParameters();
        t.start();
    }

    @Override
    public void run() {

        WebDriver driver = new FirefoxDriver(); // Init driver

        Login.login(config, driver);

        AcceptWorksByParameters.acceptAllWorks(driver, parameters);
    }
}