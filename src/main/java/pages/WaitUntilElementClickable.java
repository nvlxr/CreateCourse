package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntilElementClickable {
    WebDriver driver;
    public WaitUntilElementClickable (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitUntilElementClickable(WebElement elementNeedToCheck, WebElement mask)
    {
        WebDriverWait wait = new WebDriverWait(driver,155);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(elementNeedToCheck),ExpectedConditions.invisibilityOf(mask)));
    }

}
