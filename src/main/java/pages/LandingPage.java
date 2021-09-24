package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.HookSteps.getDriver;

public class LandingPage {
    WebDriver driver;
    WaitUntilElementClickable waitUntilElementClickable;
    @FindBy (xpath = "//*[@class='el-menu-item']//*[text()='Courses']") WebElement menuCourses;
    @FindBy (xpath = "//div[@class='el-loading-mask']") WebElement mask;
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementClickable = new WaitUntilElementClickable(getDriver());
    }
    //Click course on left menu to open Course page
    public void clickCourse()
    {
        waitUntilElementClickable.waitUntilElementClickable(menuCourses,mask);
        menuCourses.click();
    }
//    public void waitUntilElementClickable()
//    {
////        try{
////            Thread.sleep(1000);
////        }
////        catch (Exception e){}
//        WebDriverWait wait = new WebDriverWait(driver,155);
//        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(menuCourses),ExpectedConditions.invisibilityOf(mask)));
//    }
    //Login > *Landing Page > Courses Page
}
