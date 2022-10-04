package org.artevseev.threads;

import org.artevseev.config.Config;
import org.artevseev.config.Login;
import org.artevseev.funcs.AcceptWorksByParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class NewAcceptingByEmails implements Runnable{
    Thread t;
    Config config;
    Parameters parameters;
    List<String> emailList;

    public NewAcceptingByEmails(String name, Config config, Parameters parameters, List<String> emailList){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = parameters;
        this.emailList = emailList;
        t.start();
    }

    NewAcceptingByEmails(String name, Config config, String link, List<String> emailList){
        t = new Thread(this, name);
        this.config = config;
        this.parameters = new Parameters(link);
        this.emailList = emailList;
        t.start();
    }

    @Override
    public void run() {
        FirefoxOptions op = new FirefoxOptions();
        op.addArguments("--headless");  // Without GUI
        WebDriver driver = new FirefoxDriver(); // Init driver


        Login.login(config, driver);

        AcceptWorksByParameters.acceptWorksByEmails(driver, parameters, emailList);
    }
}
