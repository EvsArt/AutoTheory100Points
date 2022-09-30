package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecusion {  // Реализуем клики через Js, т.к. через Selenium не выходит...

    private final JavascriptExecutor js;

    public JsExecusion(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * execute the script with parameters
     * @param expr	js expression
     * @param arguments	parameters
     * @return	Object result of execution
     */
    private Object execScript(final String expr, Object... arguments) {
        return js.executeScript(expr, arguments);
    }

    /**
     * clicks on elem/home/artevseev/IdeaProjects/AutoTheory100Points/src/main/java/org/example/Pagesents with JS executor
     * @param element	what WebElement to click
     */
    public void clickOnElement(WebElement element) {
        execScript("arguments[0].click();", element);
    }
}