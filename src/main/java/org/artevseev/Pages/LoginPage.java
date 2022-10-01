package org.artevseev.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id="email")
    private WebElement loginField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(xpath="/html/body/div/div/div[2]/form/div[4]/button")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }

}
