package org.artevseev;

import org.artevseev.config.Config;
import org.artevseev.funcs.EmailsToList;
import org.artevseev.links.ListOfParameters;
import org.artevseev.links.Parameters;
import org.artevseev.threads.NewAcceptingByEmails;

import java.io.IOException;

public class Application {
    public static void run(String[] args) {
        /* Technical information */
        final String LOGIN = "s";
        final String PASSWORD = "s";
        final String LOGIN_PAGE = "https://api.100points.ru/login";
        final String DRIVERPATH = "/home/artevseev/Desktop/Selenium/geckodriver";
        final String EMPTYLINKSTOCK = "https://api.100points.ru/exchange/index?email=&name=&course_id=&module_id=&lesson_id=";
        final String EMPTYLINKHW = "https://api.100points.ru/student_homework/index?email=&name=&course_id=&module_id=&lesson_id=";
        System.setProperty("webdriver.gecko.driver", DRIVERPATH);

        Parameters parametersHW = new Parameters(EMPTYLINKHW);
        Parameters parametersSTOCK = new Parameters(EMPTYLINKSTOCK);  // Common parameter

        Config config = new Config(LOGIN, PASSWORD, LOGIN_PAGE, DRIVERPATH);
        Config configAdm = new Config("s", "s",
                LOGIN_PAGE, DRIVERPATH);


//        new NewAcceptingByParameters("Theory", config, parameters.copy().setLesson_id("208"));
//        new NewAcceptingByParameters("1 KW", config, "https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=141");
//        new NewAcceptingByParameters("331", config, parametersSTOCK.copy().setLesson_id("331"));
        try {

            new NewAcceptingByEmails("ХИМФАК_БИРЖА", configAdm,
                    parametersSTOCK.copy().setParameter(ListOfParameters.COURSE_ID, "26"),
                    EmailsToList.emailsToList("/home/artevseev/IdeaProjects/AutoTheory100Points/src/main/resources/EmailsForСhemistry"));
            new NewAcceptingByEmails("ХИМФАК_ДОМАШКИ", configAdm,
                    parametersHW.copy().setParameter(ListOfParameters.COURSE_ID, "26"),
                    EmailsToList.emailsToList("/home/artevseev/IdeaProjects/AutoTheory100Points/src/main/resources/EmailsForСhemistry"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
