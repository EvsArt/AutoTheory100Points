package org.artevseev;

import org.artevseev.config.Config;
import org.artevseev.links.LinkWithParameters;
import org.artevseev.links.Parameters;

public class Application {
    public static void run(String[] args) {
        /* Technical information */
        final String LOGIN = "aevseev444@gmail.com";
        final String PASSWORD = "aevseev444@gmail.com";
        final String LOGIN_PAGE = "https://api.100points.ru/login";
        final String DRIVERPATH = "/home/artevseev/Desktop/Selenium/geckodriver";
        final String HWPAGE = "https://api.100points.ru/exchange/index?email=&name=&course_id=&module_id=&lesson_id=";
        System.setProperty("webdriver.gecko.driver", DRIVERPATH);


        Parameters parametersTheory = new LinkWithParameters("https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=208")
                .getParameters();
//        Parameters parametersKW1 = new LinkWithParameters("https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=141")
//                .getParameters();


        Config config = new Config(LOGIN, PASSWORD, LOGIN_PAGE, DRIVERPATH);

        new NewAccepting("Theory", config, parametersTheory);
        new NewAccepting("1 KW", config, "https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=141");

    }
}
