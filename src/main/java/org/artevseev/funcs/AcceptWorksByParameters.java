package org.artevseev.funcs;

import org.artevseev.Pages.HomeworksPage;
import org.artevseev.Pages.OneHomeworkPage;
import org.artevseev.links.ListOfParameters;
import org.artevseev.links.Parameters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class AcceptWorksByParameters {

    private static void acceptFirstWorksByParameters(WebDriver driver, Parameters parameters){
        try {
            driver.get(parameters.generateLink());
        } catch (TimeoutException ignore){
            System.out.println("Timeout with getting first hw");
        }


            HomeworksPage homeworksPage = new HomeworksPage(driver);
            homeworksPage.clickFirstHwButton(); //  Open first hw

            OneHomeworkPage oneHomeworkPage = new OneHomeworkPage(driver);

            oneHomeworkPage.clickAllLabels(); // Mark all tasks
            oneHomeworkPage.acceptHW();

    }

    public static void acceptAllWorks(WebDriver driver, Parameters parameters){

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3500));

        int chet = 0;

        while (true) {
            try {
                acceptFirstWorksByParameters(driver, parameters);
                System.out.println(Thread.currentThread().getName() + ": " + LocalTime.now() + " Работ принято: " + ++chet);
            }catch (NoSuchElementException e){
                System.out.println(Thread.currentThread().getName() + " " + LocalTime.now() + ": Идёт поиск работ");
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    System.out.println(Thread.currentThread() + " " + LocalTime.now() + ": не засыпает(((");
                }
            }
        }
    }

    public static void acceptWorksByEmails(WebDriver driver, Parameters parameters, List<String> emailList){
        while (true) {  // Work without stop
            for (String email : emailList) {
                while (true) {  // Check all works
                    try {
                        acceptFirstWorksByParameters(driver,
                                parameters.copy().setParameter(ListOfParameters.EMAIL, email));
                        System.out.println(Thread.currentThread() + " " + LocalTime.now() + ": Работа ученика " + email + " проверена");
                    } catch (NoSuchElementException e){
                        System.out.println(Thread.currentThread() + " " + LocalTime.now() + ": Все работы ученика " + email + " проверены");
                        break;
                    }
                }
            }
            try {
                System.out.println(Thread.currentThread() + " " + LocalTime.now() + ": Все работы у всех проверены!");
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + " не спит(");
            }
        }
    }
}
