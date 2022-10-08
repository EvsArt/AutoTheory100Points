package org.artevseev.funcs;

import org.artevseev.Pages.HomeworksPage;
import org.artevseev.Pages.OneHomeworkPage;
import org.artevseev.links.Parameters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShowScores {
    private static void showOneHW(WebDriver driver, Parameters parameters, HashMap<String, String> result, int n, int page){

//        try {
            driver.get(parameters.generateLink()+"&page="+page);
//        } catch (TimeoutException ignore){}


        HomeworksPage homeworksPage = new HomeworksPage(driver);

        homeworksPage.clickNHwButton((n-1)%15 + 1); //  Open first hw

        OneHomeworkPage oneHomeworkPage = new OneHomeworkPage(driver);

        result.put(oneHomeworkPage.showName(), oneHomeworkPage.getScores());
        System.out.println(Thread.currentThread().getName() + ": Проверен ученик " + n + " на странице " + page);

    }
    public static void showAllScores(WebDriver driver, Parameters parameters){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3500));
        int n = 1;
        int page = 1;
        HashMap<String, String> result = new HashMap<>();
        while (true) {
            try {
                if((n-1)%15 == 0 && n != 1) page ++;
                showOneHW(driver, parameters, result, n++, page);
            }catch (NoSuchElementException e){
                System.out.println(Thread.currentThread().getName() + ": ВСЁ");
                break;
            }
        }
        Map<String, String> treeMap = new TreeMap<>(result);
        System.out.println(Thread.currentThread() + ": " + treeMap.size());
        treeMap.forEach((String x, String y) -> System.out.println(Thread.currentThread() + ": " + x + " набрал(а) " + y));
    }
}
