package org.artevseev.funcs;

import org.artevseev.Pages.HomeworksPage;
import org.artevseev.Pages.OneHomeworkPage;
import org.artevseev.links.LinkWithParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

public class AcceptWorksByParameters {
    public static void acceptAllWorks(WebDriver driver, Parameters parameters){
        LinkWithParameters link = new LinkWithParameters(parameters);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        int chet = 0;
        while (true) {

            try {
                driver.get(link.getLink());
            } catch (TimeoutException ignore){}



            try {
                HomeworksPage homeworksPage = new HomeworksPage(driver);
                homeworksPage.clickFirstHwButton(); //  Open first hw

                OneHomeworkPage oneHomeworkPage = new OneHomeworkPage(driver);

                oneHomeworkPage.clickAllLabels(); // Mark all tasks
                oneHomeworkPage.acceptHW();
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now() + " Работ принято: " + ++chet);
            } catch (NoSuchElementException e) {
                System.out.println(Thread.currentThread().getName() + ": Идёт поиск работ");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    System.out.println("Поток не засыпает(((");
                }
            }
        }
    }
}
