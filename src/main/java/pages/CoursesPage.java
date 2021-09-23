package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage {
    WebDriver driver;
    @FindBy (xpath = "//*[@class='el-icon-plus']/../../../..") WebElement btnCreateCourse;
    @FindBy (xpath = "//div[@class='el-loading-mask']") WebElement mask;

    public CoursesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitUntilElementClickable()
    {
//        try{
//            Thread.sleep(1000);
//        }
//        catch (Exception e){}
        WebDriverWait wait = new WebDriverWait(driver,155);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(btnCreateCourse),ExpectedConditions.invisibilityOf(mask)));
    }
    public void clickCreateCourse()
    {
        waitUntilElementClickable();
        btnCreateCourse.click();
    }
    //Landing Page > Course Page > CreateNewCoursePage

}
