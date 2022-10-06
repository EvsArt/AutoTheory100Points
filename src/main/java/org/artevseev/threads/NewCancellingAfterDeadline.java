package org.artevseev.threads;

import org.artevseev.config.Config;
import org.artevseev.config.Login;
import org.artevseev.funcs.CancelWorksByParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Date;

public class NewCancellingAfterDeadline implements Runnable{
    Thread t;
    Config config;
    Parameters parameters;
    Date deadline;

    public NewCancellingAfterDeadline(String name, Config config, Date deadline, Parameters parameters){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = parameters;
        this.deadline = deadline;
        t.start();
    }

    NewCancellingAfterDeadline(String name, Config config, Date deadline, String link){
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

        CancelWorksByParameters.cancelAllWorks(driver, parameters, deadline);
    }
}