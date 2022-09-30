package org.example.funcs;

import org.example.Pages.HomeworksPage;
import org.example.Pages.OneHomeworkPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

public class AcceptWorksByParameters {
    public static void acceptAllWorks(WebDriver driver, String HwPageWithParameters /*Вмето ссылки сделать параметры*/){
        int chet = 0;
        while (true) {
            try {
                driver.get(HwPageWithParameters);
                HomeworksPage homeworksPage = new HomeworksPage(driver);
                homeworksPage.clickFirstHwButton(); //  Open first hw

                OneHomeworkPage oneHomeworkPage = new OneHomeworkPage(driver);
                oneHomeworkPage.clickAllLabels(); // Mark all tasks
                oneHomeworkPage.acceptHW();
                System.out.println(LocalTime.now() + " Работ принято: " + ++chet);
            } catch (NoSuchElementException e) {
                System.out.println("РАБОТЫ ЗАКОНЧИЛИСЬ!!!");
                break;
            }
        }
    }
}
