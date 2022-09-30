package org.example.Pages;

import org.example.JsExecusion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OneHomeworkPage {

    public WebDriver driver;
    public OneHomeworkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public List<WebElement> getLabels(){
        String className = "custom-control-label";
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
        acceptButton.click();
//        acceptAcceptButton.click();
    }
}
