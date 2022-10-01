package org.artevseev.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeworksPage {

    public WebDriver driver;
    public HomeworksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement getHwByNum(int n) throws NoSuchElementException {
        final String xpath = "/html/body/div/div[1]/section/div/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr["
                        + n + "]/td[1]/a";

            return driver.findElement(By.xpath(xpath));
    }

    private WebElement getFirstHw(){
        return getHwByNum(1);
    }

    public void clickFirstHwButton(){

        getFirstHw().click();
    }
}
