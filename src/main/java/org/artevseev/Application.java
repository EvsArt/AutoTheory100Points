package org.artevseev;

import org.artevseev.config.Config;
import org.artevseev.links.ListOfParameters;
import org.artevseev.links.Parameters;
import org.artevseev.threads.NewAcceptingByParameters;
import org.artevseev.threads.NewCancellingAfterDeadline;
import org.checkerframework.checker.units.qual.C;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void run(String[] args) {
        /* Technical information */
        final String LOGIN = "s";
        final String PASSWORD = "s";
        final String LOGIN_PAGE = "https://api.100points.ru/login";
        final String DRIVERPATH = "/home/artevseev/Desktop/Selenium/geckodriver";
        final String CHEMISTRYEMAILSPATH = "/home/artevseev/IdeaProjects/AutoTheory100Points/src/main/resources/EmailsForСhemistry";
        final String EMPTYLINKSTOCK = "https://api.100points.ru/exchange/index?email=&name=&course_id=&module_id=&lesson_id=";
        final String EMPTYLINKHW = "https://api.100points.ru/student_homework/index?email=&name=&course_id=&module_id=&lesson_id=";
        final String EMPTYLINKFORDEADLINES = "https://api.100points.ru/exchange/index?email=&name=&course_id=&module_id=&lesson_id=&sort=sent_to_review_at&sort_direct=desc";
        final Date DEADLINEOF1PLAN = new Date(2022-1900, Calendar.OCTOBER, 5, 23, 55);
        System.setProperty("webdriver.gecko.driver", DRIVERPATH);

        Parameters parametersHW = new Parameters(EMPTYLINKHW);
        Parameters parametersSTOCK = new Parameters(EMPTYLINKSTOCK);  // Common parameter
        Parameters parametersCancellingAfterDeadline = new Parameters(EMPTYLINKFORDEADLINES);

        Config config = new Config(LOGIN, PASSWORD, LOGIN_PAGE, DRIVERPATH);
        Config configAdm = new Config("s", "s",
                LOGIN_PAGE, DRIVERPATH);

//        new NewCancellingAfterDeadline("KW2", configAdm, new Date(2022-1900,Calendar.SEPTEMBER,26),
//                parametersSTOCK.copy().setParameter(ListOfParameters.LESSON_ID, "315"));
//
//        new NewCancellingAfterDeadline("KW3", configAdm, new Date(2022-1900, Calendar.OCTOBER,3),
//                parametersSTOCK.copy().setParameter(ListOfParameters.LESSON_ID, "366"));

        new NewAcceptingByParameters("Theory", configAdm,
                parametersSTOCK.copy().setParameter(ListOfParameters.LESSON_ID, "208"));

//        new NewAcceptingByParameters("1 KW", configAdm,
//                parametersSTOCK.copy().setParameter(ListOfParameters.LESSON_ID, "141"));

        new NewCancellingAfterDeadline("1 планик", configAdm, DEADLINEOF1PLAN,
                parametersCancellingAfterDeadline.copy().setParameter(ListOfParameters.LESSON_ID, "330"));

        //        try {
//
//            new NewAcceptingByEmails("ХИМФАК_БИРЖА", configAdm,
//                    parametersSTOCK.copy().setParameter(ListOfParameters.COURSE_ID, "26"),
//                    EmailsToList.emailsToList(CHEMISTRYEMAILSPATH));
//            new NewAcceptingByEmails("ХИМФАК_ДОМАШКИ", configAdm,
//                    parametersHW.copy().setParameter(ListOfParameters.COURSE_ID, "26"),
//                    EmailsToList.emailsToList(CHEMISTRYEMAILSPATH));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
