package org.artevseev.Pages;

import org.artevseev.funcs.JsExecusion;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OneHomeworkPage {

    public WebDriver driver;
    WebDriverWait wait;
    public OneHomeworkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public List<WebElement> getLabels(){
        String className = "custom-control-label";
        wait.until(elementToBeClickable(By.className(className)));
        return driver.findElements(By.className(className));
    }

    public void clickAllLabels(){
        JsExecusion jsExecusion = new JsExecusion(driver);
        for(WebElement el: getLabels()){
            jsExecusion.clickOnElement(el);
        }
    }

    @FindBy(xpath = "/html/body/div/div[1]/section/div/form/div[1]/div/div/div[2]/div/div[1]/div[1]/input")
    private WebElement nameOfStudent;

    @FindBy(xpath = "/html/body/div/div[1]/section/div/form/div[1]/div/div/div[2]/div/div[1]/div[5]")
    private WebElement hisScores;

    @FindBy(className="btn-success")
    private WebElement acceptButton;

    @FindBy(id="applyBtn")
    private WebElement acceptAcceptButton;

    @FindBy(id = "change_decision")
    private WebElement changeDecision;

    @FindBy(css = "#decision_buttons > button:nth-child(2)")
    private WebElement cancelButton;

    @FindBy(xpath = "/html/body/div/div[1]/section/div/form/div[1]/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]")
    private WebElement commentDiv;

    @FindBy(id = "rejectBtn")
    private WebElement acceptCancelling;


    public void acceptHW() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(visibilityOfElementLocated(By.className("btn-success")));
            acceptButton.click();
            wait.until(visibilityOfElementLocated(By.id("applyBtn")));
            acceptAcceptButton.click();

        } catch (TimeoutException e){
            System.out.println("Timeout Exception with waiting for accepting");
        }
    }

    public void cancelHW(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//            wait.until(visibilityOfElementLocated(By.id("change_decision")));
//            changeDecision.click();
            wait.until(visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section/div/form/div[1]/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]")));
            commentDiv.sendKeys("К сожалению, ты сдал(а) домашнее задание после окончания дедлайна, поэтому твою работу проверит личный куратор");
            wait.until(visibilityOfElementLocated(By.cssSelector("#decision_buttons > button:nth-child(2)")));
            cancelButton.click();
            wait.until(visibilityOfElementLocated(By.id("rejectBtn")));
            acceptCancelling.click();
        } catch (TimeoutException e){
            System.out.println("Timeout Exception with waiting for cancelling");
        }
    }

    public String showName(){
        String res0 = nameOfStudent.getAttribute("value");
        String[] tmp = res0.split(" ");
        return tmp[1] + " " + tmp[0];
    }

    public String getScores(){
        return hisScores.getText();
    }
}
