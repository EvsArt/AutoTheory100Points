package org.example;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.time.LocalTime;

public class Main {
        public static void main(String[] args){
        final String LOGIN = "MyLogin";
        final String PASSWORD = "MyPassword";
        final String LOGIN_PAGE = "https://api.100points.ru/login";
        final String GECKODRIVER = "/home/artevseev/Desktop/Selenium/geckodriver";
        final String HWPAGE = "https://api.100points.ru/student_homework/index?email=&name=&course_id=25&module_id=47&lesson_id=208";

        System.setProperty("webdriver.gecko.driver", GECKODRIVER);
        WebDriver driver = new FirefoxDriver(); // Init driver

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputLogin(LOGIN);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLoginButton();   // Зарегались

        int chet = 0;
        while (true) {
            try {

                driver.get(HWPAGE);
                HomeworksPage homeworksPage = new HomeworksPage(driver);
                homeworksPage.clickFirstHwButton(); //  Открыли первую дз из списка

                OneHomeworkPage oneHomeworkPage = new OneHomeworkPage(driver);
                oneHomeworkPage.clickAllLabels(); // Отметили все задания
                oneHomeworkPage.acceptHW();
                System.out.println(LocalTime.now() + " Работ принято: " + ++chet);
            } catch (NoSuchElementException e) {
                System.out.println("РАБОТЫ ЗАКОНЧИЛИСЬ!!!");
                break;
            }
        }
    }

}