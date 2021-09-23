package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static driver.HookSteps.getDriver;

public class CreateNewCoursePage {
    WebDriver driver;
    SelectCourseAndLessonTagPage selectCourseAndLessonTagPage;
    SelectAdvisorPage selectAdvisorPage;
    @FindBy (xpath = "//input[@placeholder=\"Please enter the Lesson Name\"]") WebElement txtCourseName;
    @FindBy (xpath = "//*[contains(@class,'eeo_schoolBatchMemberSelectBtn')]") WebElement btnSelectAdvisor;
    @FindBy (xpath = "(//button[contains(@class,'el-button el-button--primary el-button--mini')])[3]") WebElement btnCourseTag;
    //@FindBy (xpath = "(//*[contains(@class,'el-checkbox__inner')])[6]") WebElement chkBoxProduction;
    //@FindBy (xpath = "(//div[@class='tagName'])[1]//../div[@class='checkboxBox']/div[@class='el-checkbox']") WebElement chkBoxStaging;
    //@FindBy (xpath = "(//div[@class='tagName'])[2]//../div[@class='checkboxBox']/div[@class='el-checkbox']") WebElement chkBoxProduction;
    @FindBy (xpath = "(//button[@class='el-button el-button--primary el-button--mini'])[4]") WebElement btnDoneSelectCourseTag;
    @FindBy (xpath = "(//*[contains(@class,'el-checkbox__inner')])[2]") WebElement chkBoxAllowClass;
    @FindBy (xpath = "(//*[contains(@class,'el-input__inner')])[3]") WebElement txtCalendar;
    @FindBy (xpath = "//span[normalize-space(text()) = 'Create Immediately']") WebElement btnCreateCourse;
    public CreateNewCoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean createNewCourse(String courseName, String courseDate, String courseTag, String advisorName)
    {
        //try{
            //Switch to new opened tab
            switchToNewTab();
            //Enter Course name
            enterCourseName(courseName);
            //Select Course Advisor
            clickSelectAdvisorButton();//Open Select Advisor popup
            waitUntilAdvisorPopUpReady();
            selectAdvisorPage = new SelectAdvisorPage(getDriver());
            selectAdvisorPage.selectAdvisorOrTeacher(advisorName);
            //selectAdvisorPage.btnDoneCloseSelectCourseAdvisor.click();//Why duplicate this here?

            //Select Course Tag
            selectCourseTag(courseTag);
            //Enter Date
            enterDateToCalendarBox(courseDate);
            //Uncheck the "Allow class..." checkbox
            uncheckAllowClassCheckbox();
            //Click btnCreateCourse button to create course
            //btnCreateCourse.click();
            return true;
        //}
        //catch (Exception e)
        //{return false;}
    }

    //Switch to new opened tab
    public void switchToNewTab()
    {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Switch to new opened tab successfully");
    }
    public void enterCourseName(String courseName)
    {
        //wait some second to  page load completely
//        try {
//            Thread.sleep(1600);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        txtCourseName.sendKeys(courseName);
        System.out.println("Enter course name successfully");
    }
    public void clickSelectAdvisorButton()
    {
        btnSelectAdvisor.click();
    }
    public void selectCourseTag( String courseTag)
    {
            //Open select course tag pop-up
            btnCourseTag.click();
            //wait pop-up show completely
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Check the checkbox
            selectCourseAndLessonTagPage = new SelectCourseAndLessonTagPage(getDriver());
            selectCourseAndLessonTagPage.selectCourseAndLessonTag("course", courseTag);
            //wait pop-up close completely
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void uncheckAllowClassCheckbox()
    {
        chkBoxAllowClass.click();
        System.out.println("Uncheck 'Allow Class' checkbox successfully");
    }
    public void enterDateToCalendarBox(String date)
    {
        //Remove Read Only Attribute of Calendar text box
        WebElement elementName = driver.findElement(By.xpath("(//*[contains(@class,'el-input__inner')])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Calendar box successfully");
        //Enter Date
        txtCalendar.sendKeys(date);
        System.out.println("Enter date to Calendar box successfully");
    }
    public void goToLessonPage()//this will be changed to click Create Course
    {
        driver.navigate().to("https://console.classin.com/saas/school/index.html#/SinglePage/CourseManagement/CourseLessonManagement?courseId=179568067");
        System.out.println("Navigated to Lesson page");
        //Wait new page load successfully
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitUntilAdvisorPopUpReady()
    {

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"candidateListBox\"]//ul//li")));
    }

}
