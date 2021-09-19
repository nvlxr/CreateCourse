package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static driver.HookSteps.getDriver;

public class CreateLessonPage {
    WebDriver driver;
    SelectAdvisorPage selectAdvisorPage;
    SelectCourseAndLessonTagPage selectCourseAndLessonTagPage;
    public CreateLessonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//span[normalize-space(text()) = 'Create Lessons']") WebElement btnCreateLessons;
    @FindBy (xpath = "//label[text()='Start Date']//../div[@class='el-form-item__content']/div[@class='eeo_dateDaySelectInput']/div/input") WebElement txtStartDate;
    @FindBy (xpath = "//label[text()='Start Date']") WebElement clickHereToCloseDatePopUp;//74
    @FindBy (xpath = "//*[@class='eeo-ul options hour eeo-scroll-bar']//li")
    List<WebElement> hourList;
    @FindBy (xpath = "//*[@class='eeo-ul options minute eeo-scroll-bar']//li")
    List<WebElement> minuteList;
    @FindBy (xpath = "(//div[@class='el-dialog__wrapper eeo-el-dialog' and not(@style=\"display: none;\")])[3]/div/div[@class='el-dialog__footer']/div/div/button[@class='el-button el-button--primary el-button--mini']") WebElement btnDoneCloseCreateLessonDialog;
    @FindBy (xpath = "(//label[text()='Start Time']//../div/span/span)[1]/div/div/span") WebElement btnOpenDropDownStartTime;
    @FindBy (xpath = "//div[@class='text-right']") WebElement btnCloseTimePicker;
    @FindBy (xpath = "(//*[@class='el-scrollbar__view el-select-dropdown__list'])[8]//li")
    List<WebElement> durationHourAndMinuteList;
    @FindBy (xpath = "//input[@placeholder='hour']") WebElement btnOpenDropDownDurationHour;
    @FindBy (xpath = "//input[@placeholder='minute']") WebElement btnOpenDropDownDurationMinute;
    @FindBy (xpath = "//input[@placeholder='30']") WebElement btnOpenDropDownDurationMinuteAfterClearDefaultValue;
    @FindBy (xpath = "(//span[normalize-space(text()) = 'Select'])[1]//..//..") WebElement btnSelectTeacher;
    @FindBy (xpath = "(//span[normalize-space(text()) = 'Select'])[3]//..//..") WebElement btnSelectLessonTag;
    @FindBy (css = ".el-switch__core") WebElement toggleBatchCreate;
    @FindBy (xpath = "(//div[@class='el-dialog__wrapper eeo-el-dialog' and not(@style=\"display: none;\")])[2]/div/div[@class='el-dialog__body']/form/div[@class='el-form-item el-form-item--mini'][1]/div/div[@class='el-input el-input--mini']/input") WebElement txtLessonNumber;
    @FindBy (xpath = "//*[text()='Sunday']") WebElement btnSunday;
    @FindBy (xpath = "(//*[text()='Monday'])[2]") WebElement btnMonday;
    @FindBy (xpath = "(//*[text()='Tuesday'])") WebElement btnTuesday;
    @FindBy (xpath = "(//*[text()='Wednesday'])") WebElement btnWednesday;
    @FindBy (xpath = "(//*[text()='Thursday'])") WebElement btnThursday;
    @FindBy (xpath = "(//*[text()='Friday'])") WebElement btnFriday;
    @FindBy (xpath = "(//*[text()='Saturday'])") WebElement btnSaturday;
    public void createLesson(String startDate,String lessonTag, String weekDates, String lessonNumber, String lessonHour,String lessonMinute, String durationHour, String durationMinute, String teacherName)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCreateLessons.click();
        //Wait pop-up show successfully
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Next step
        //Turn on Batch Create
        toggleBatchCreate.click();
        //Enter lesson number
        txtLessonNumber.clear();
        txtLessonNumber.sendKeys(lessonNumber);
        //Enter StartDate
        enterStartDate(startDate);
        //Select Time: hour
        selectHour(lessonHour);
        //Select Time: minute
        selectMinute(lessonMinute);
        //Select Duration Hour
        selectDurationHour(durationHour);
        //Select Duration Minute
        selectDurationMinute(durationMinute);
        //Select week's Law
        selectWeekLaw(weekDates);
        //Select Teacher
        selectTeacher(teacherName);
        //Select Lesson Tag
        selectLessonTag(lessonTag);
        // Close create lesson dialog
        //btnDoneCloseCreateLessonDialog.click();//now not click because of create real data on PROD
    }
    public void enterStartDate(String startDate) {

        //Remove Read Only Attribute of Start Date
        WebElement elementName = txtStartDate;
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Start Date successfully");
        //Enter StartDate
        txtStartDate.clear();
        txtStartDate.sendKeys(startDate);
        System.out.println("Date entered successfully");
        //Close Calendar popup
        clickHereToCloseDatePopUp.click();
    }
    public void selectHour(String lessonHour) {

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        btnOpenDropDownStartTime.click();
        for (int i = 0; i < hourList.size(); i++) {
            int j=i+1;
            String hour = hourList.get(i).findElement(By.xpath("(//*[@class='eeo-ul options hour eeo-scroll-bar']//li)["+j+"]")).getText();
            //System.out.println("hour number "+i+": "+hour+"\n");
            if (hour.trim().equalsIgnoreCase(lessonHour)) {
                System.out.println("Selected hour: " + hour);
                hourList.get(i).click();
                break;
            }
        }
        System.out.println("Selected Hour value");
    }
    public void selectMinute(String lessonMinute) {

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i < minuteList.size(); i++) {
            int j=i+1;
            String minute = minuteList.get(i).findElement(By.xpath("(//*[@class='eeo-ul options minute eeo-scroll-bar']//li)["+j+"]")).getText();
            //System.out.println("minute number "+i+": "+minute+"\n");
            if (minute.trim().equalsIgnoreCase(lessonMinute)) {
                System.out.println("Selected minute: " + minute);
                minuteList.get(i).click();
                break;
            }
        }
        btnCloseTimePicker.click();
        System.out.println("Selected Minute value \nClosed Time Picker...");
    }
    public void selectDurationHour(String durationHourInput) {

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        WebElement elementName = driver.findElement(By.xpath("//input[@placeholder='hour']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Duration Hour successfully");
        btnOpenDropDownDurationHour.clear();
        btnOpenDropDownDurationHour.sendKeys(durationHourInput);
        for (int i = 0; i < durationHourAndMinuteList.size(); i++) {
            int j=i+1;
            String durationHour = durationHourAndMinuteList.get(i).findElement(By.xpath("(//*[@class='el-scrollbar__view el-select-dropdown__list'])[8]//li["+j+"]")).getText();
            //System.out.println("hour number "+i+": "+durationHour+"\n");
            if (durationHour.trim().equalsIgnoreCase(durationHourInput)) {
                System.out.println("Selected hour: " + durationHour);
                durationHourAndMinuteList.get(i).click();
                break;
            }
        }
        System.out.println("Selected Duration Hour value");
    }
    public void selectDurationMinute(String durationHourInput) {
        WebElement elementName = driver.findElement(By.xpath("//input[@placeholder='minute']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Duration Minute successfully");
        btnOpenDropDownDurationMinute.clear();
        System.out.println("Cleared default Duration Minute successfully");
        btnOpenDropDownDurationMinuteAfterClearDefaultValue.sendKeys(durationHourInput);
        System.out.println("Enter search value to Duration Minute successfully");
        for (int i = 0; i < durationHourAndMinuteList.size(); i++) {
            int j=i+1;
            String durationMinute = durationHourAndMinuteList.get(i).findElement(By.xpath("(//*[@class='el-scrollbar__view el-select-dropdown__list'])[8]//li["+j+"]")).getText();
            //System.out.println("minute number "+i+": "+durationMinute+"\n");
            if (durationMinute.trim().equalsIgnoreCase(durationHourInput)) {
                System.out.println("Selected minute: " + durationMinute);
                durationHourAndMinuteList.get(i).click();
                break;
            }
        }
        System.out.println("Selected Duration Minute value");
    }
    public void selectWeekLaw(String weekDate) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnSunday.click();
        System.out.println("Unchecked default Sunday");
        int n =weekDate.length();
        for(int i=0;i<n;i++)
        {
            if(weekDate.charAt(i)=='1') {
                btnSunday.click();
                System.out.println("Selected week's law: Sunday");
            }
            else if (weekDate.charAt(i)=='2') {
                btnMonday.click();
                System.out.println("Selected week's law: Monday");
            }
            else if (weekDate.charAt(i)=='3') {
                btnTuesday.click();
                System.out.println("Selected week's law: Tuesday");
            }
            else if (weekDate.charAt(i)=='4') {
                btnWednesday.click();
                System.out.println("Selected week's law: Wednesday");}
            else if (weekDate.charAt(i)=='5') {
                btnThursday.click();
                System.out.println("Selected week's law: Thursday");}
            else if (weekDate.charAt(i)=='6') {
                btnFriday.click();
                System.out.println("Selected week's law: Friday");}
            else if (weekDate.charAt(i)=='7') {
                btnSaturday.click();
                System.out.println("Selected week's law: Saturday");}

        }
    }
    public void selectTeacher(String teacherName) {
        selectAdvisorPage = new SelectAdvisorPage(getDriver());
        btnSelectTeacher.click();
        selectAdvisorPage.selectAdvisorOrTeacher(teacherName);
    }
    public void selectLessonTag(String lessonTag)
    {
        btnSelectLessonTag.click();
        //Wait popup show completely
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectCourseAndLessonTagPage = new SelectCourseAndLessonTagPage(getDriver());
        selectCourseAndLessonTagPage.selectCourseAndLessonTag("lesson", lessonTag);
        //Click Done
        //wait pop-up close completely
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
