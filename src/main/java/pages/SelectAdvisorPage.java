package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static driver.HookSteps.getDriver;
import java.util.List;

public class SelectAdvisorPage {
    WaitUntilElementClickable waitUntilElementClickable;
    public SelectAdvisorPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementClickable = new WaitUntilElementClickable(getDriver());
    }
    WebDriver driver;
    @FindBy (xpath = "//input[@placeholder=\"Enter Name/Phone Number by \"]") WebElement txtSearchAdvisor;
    @FindBy (xpath = "//div[@class=\"candidateListBox\"]//ul//li")
    List<WebElement> advisorList;
    String xpathCheckIfTwoDialogIsDisplaying ="//div[@class='el-dialog__wrapper eeo-el-dialog schoolMemberBatchSelectDialog' and not(@style=\"display: none;\")]";
    @FindBy (xpath = "//div[@class='el-dialog__wrapper eeo-el-dialog schoolMemberBatchSelectDialog']/div/div[@class='el-dialog__footer']/div/div[2]/button[1]") WebElement btnDoneCloseSelectCourseAdvisor;
    @FindBy (xpath = "(//div[@class='el-dialog__wrapper eeo-el-dialog schoolMemberBatchSelectDialog' and not(@style=\"display: none;\")])[2]/div/div[@class='el-dialog__footer']/div/div[@class='eeo_buttonGroup_dialogFooter']/button[@class='el-button el-button--primary el-button--mini']") WebElement btnDoneCloseSelectLessonTeacher;
    @FindBy (xpath = "//div[@class='el-loading-mask']") WebElement mask;
    public void selectAdvisorOrTeacher(String advisorTeacherName)
    {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<advisorList.size();i++)
        {
            String advisorName = advisorList.get(i).findElement(By.xpath(".//div[@class=\"title\"]")).getText();
            if(advisorName.trim().equalsIgnoreCase(advisorTeacherName))
            {
                System.out.println("Selected Advisor or Teacher: "+advisorName+" successfully");
                advisorList.get(i).click();
            }
        }
        if(driver.findElements( By.xpath(xpathCheckIfTwoDialogIsDisplaying) ).size() > 1)
            btnDoneCloseSelectLessonTeacher.click();
        else
            btnDoneCloseSelectCourseAdvisor.click();
        //Wait to close the pop-up successfully
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


