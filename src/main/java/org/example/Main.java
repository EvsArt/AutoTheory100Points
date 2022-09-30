package org.example;

import org.example.config.Config;
import org.example.config.Login;
import org.example.funcs.AcceptWorksByParameters;
import org.example.links.LinkWithParameters;
import org.example.links.Parameters;

public class Main {
        public static void main(String[] args){
                final String LOGIN = "aevseev444@gmail.com";
                final String PASSWORD = "aevseev444@gmail.com";
                final String LOGIN_PAGE = "https://api.100points.ru/login";
                final String DRIVERPATH = "/home/artevseev/Desktop/Selenium/geckodriver";
                final String HWPAGE = "https://api.100points.ru/student_homework/index?email=&name=&course_id=&module_id=&lesson_id=";

                final String EMAIL = "aevseev444@gmail.com";
                final String NAME = "";
                final String COURSE_ID = "25";
                final String MODULE_ID = "47";
                final String LESSON_ID = "366";
        //        TODO(Написать функцию создания параметров из ссылки)
        //        TODO(Переделать функцию принятия работ (и все остальные) для класса Parameters)
        //        TODO()
        //        TODO(Придумать что-то с записью параметров из консоли)
        //        TODO(Реализовать функцию получения имейлов из таблицы)
                LinkWithParameters link = new LinkWithParameters(HWPAGE);
                Parameters parameters = new Parameters();
                parameters.setEmail(EMAIL)
                        .setName(NAME)
                        .setCourse_id(COURSE_ID)
                        .setModule_id(MODULE_ID)
                        .setLesson_id(LESSON_ID);

                Config config = new Config(LOGIN, PASSWORD, LOGIN_PAGE, DRIVERPATH);
                Login.login(config);

                AcceptWorksByParameters.acceptAllWorks(config.getDriver(), HWPAGE);
        }
}