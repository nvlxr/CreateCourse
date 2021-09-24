package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static driver.HookSteps.getDriver;
public class SelectCourseAndLessonTagPage {
    WebDriver driver;
    WaitUntilElementClickable waitUntilElementClickable;
    public SelectCourseAndLessonTagPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementClickable = new WaitUntilElementClickable(getDriver());
    }
    @FindBy (xpath = "(//div[@class='tagName'])[1]//../div[@class='checkboxBox']/div[@class='el-checkbox']") WebElement chkBoxStaging;
    @FindBy (xpath = "(//div[@class='tagName'])[2]//../div[@class='checkboxBox']/div[@class='el-checkbox']") WebElement chkBoxProduction;
    @FindBy (xpath = "//span[normalize-space(text()) = 'Selected tags:1/2' or normalize-space(text()) = 'Selected tags:0/2']//..//..//../div[@class='el-dialog__footer']/div/div[@class='eeo_buttonGroup_dialogFooter']/button[@class='el-button el-button--primary el-button--mini']") WebElement btnDone;
    @FindBy (xpath = "//div[@class='el-loading-mask']") WebElement mask;
    public void selectCourseAndLessonTag( String type, String courseLessonTag)
    {
        //wait the pop-up show completely
        waitUntilElementClickable.waitUntilElementClickable(chkBoxProduction,mask);
        //Check the checkbox
        if(courseLessonTag.equalsIgnoreCase("production"))
        {
            chkBoxProduction.click();
            System.out.println("Select "+type+" tag: "+courseLessonTag+" successfully");
        }
        else if (courseLessonTag.equalsIgnoreCase("staging"))
        {
            chkBoxStaging.click();
            System.out.println("Select "+type+" tag: "+courseLessonTag+" successfully");
        }
        else
        {
            System.out.println("Incorrect "+type+" tag, did not selected");
        }
        //close the Pop-up
        btnDone.click();
    }
}
