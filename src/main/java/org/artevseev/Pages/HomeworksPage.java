package org.artevseev.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeworksPage {

    public WebDriver driver;

    public HomeworksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/div[2]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[2]/div[1]/b")
    private WebElement dateOfFirstHw;

    public Date getFirstHwDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy hh:mm:ss");
        try {
            return format.parse(dateOfFirstHw.getText());
        } catch (ParseException e) {
            System.out.println("Не удалось отпарсить дату!");
            throw new RuntimeException(e);
        }
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

    public void clickNHwButton(int n){
        getHwByNum(n).click();
    }

}
