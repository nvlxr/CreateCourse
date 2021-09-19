package pages;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class CoursesPage {
    WebDriver driver;
    @FindBy (xpath = "//*[@class='el-icon-plus']/../../../..") WebElement btnCreateCourse;

    public CoursesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitCreateCourseButtonClickable()
    {
//        WebDriverWait wait = new WebDriverWait(driver, 45);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='el-icon-plus']/../../../..")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='el-icon-plus']/../../../..")));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
    public void clickCreateCourse()
    {
        
        btnCreateCourse.click();
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
    //Landing Page > Course Page > CreateNewCoursePage

}
