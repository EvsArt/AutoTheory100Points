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
        this.wait = new WebDriverWait(driver, Duration.ofMillis(1000));
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


    @FindBy(className="btn-success")
    private WebElement acceptButton;

    @FindBy(id="applyBtn")
    private WebElement acceptAcceptButton;

    public void acceptHW() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOfElementLocated(By.className("btn-success")));
        acceptButton.click();
        wait.until(visibilityOfElementLocated(By.id("applyBtn")));
        acceptAcceptButton.click();
    }
}
