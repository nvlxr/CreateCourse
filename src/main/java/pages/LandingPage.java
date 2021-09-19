package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    WebDriver driver;
    @FindBy (xpath = "//*[@class='el-menu-item']//*[text()='Courses']") WebElement menuCourses;
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCourse()
    {
        try {
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menuCourses.click();
        //wait until the button "Create Course available
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='el-icon-plus']/../../../..")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Loign > *Landing Page > Courses Page
}
