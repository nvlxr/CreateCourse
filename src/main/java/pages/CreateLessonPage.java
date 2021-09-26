package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import static driver.HookSteps.getDriver;
public class CreateLessonPage {
    WebDriver driver;
    SelectAdvisorPage selectAdvisorPage;
    SelectCourseAndLessonTagPage selectCourseAndLessonTagPage;
    WaitUntilElementClickable waitUntilElementClickable;
    public CreateLessonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementClickable = new WaitUntilElementClickable(getDriver());
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

    @FindBy (xpath = "(//*[@class='el-scrollbar__view el-select-dropdown__list'])[7]//li")
    List<WebElement> durationHourAndMinuteList;
    @FindBy (xpath = "//input[@placeholder='hour']") WebElement btnOpenDropDownDurationHour;
    @FindBy (xpath = "//input[@placeholder='minute']") WebElement btnOpenDropDownDurationMinute;
    @FindBy (xpath = "//input[@placeholder='30']") WebElement btnOpenDropDownDurationMinuteAfterClearDefaultValue;
    @FindBy (xpath = "(//span[normalize-space(text()) = 'Select'])[1]//..//..") WebElement btnSelectTeacher;
    @FindBy (xpath = "(//span[normalize-space(text()) = 'Select'])[3]//..//..") WebElement btnSelectLessonTag;
    @FindBy (css = ".el-switch__core") WebElement toggleBatchCreate;
    @FindBy (xpath = "(//div[@class='el-dialog__wrapper eeo-el-dialog' and not(@style=\"display: none;\")])[2]/div/div[@class='el-dialog__body']/form/div[@class='el-form-item el-form-item--mini'][1]/div/div[@class='el-input el-input--mini']/input") WebElement txtLessonNumber;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[1]") WebElement btnSunday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[2]") WebElement btnMonday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[3]") WebElement btnTuesday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[4]") WebElement btnWednesday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[5]") WebElement btnThursday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[6]") WebElement btnFriday;
    @FindBy (xpath = "//*[contains(text(),\"Week's Law\")]//../div/div/label[7]") WebElement btnSaturday;
    //@FindBy (xpath = "//div[@class='el-loading-mask']") WebElement mask;
    @FindBy (xpath = "//div[@class='el-loading-spinner']") WebElement mask;

    public boolean createLesson(String startDate,String lessonTag, String weekLaws, String lessonNumber, String lessonHour,String lessonMinute, String durationHour, String durationMinute, String teacherName)
    {
//        try
//        {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if(driver.findElements(By.xpath("//div[@class='siteLoading']")).size()!=0||driver.findElements(By.xpath("//div[@class='el-loading-spinner']")).size()!=0) {
//                waitUntilElementClickable.waitUntilElementClickable(btnCreateLessons, mask);
//                System.out.println("Yes MASK is present >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//            }
//            else
            {
                try {
                    Thread.sleep(3000);
                }   catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//        WebDriverWait wait = new WebDriverWait(driver,155);
//        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text()) = 'Create Lessons']")));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", el);

          //Click Create Lesson Button
          btnCreateLessons.click();
          //Identify how many dropdown is present on the site, the dropdown list of Duration Hour and Minute are the last list
          int numberOfDropDownList = driver.findElements(By.xpath("(//*[@class='el-scrollbar__view el-select-dropdown__list'])")).size();
          String xpathDurationHourAndMinute ="(//*[@class='el-scrollbar__view el-select-dropdown__list'])["+numberOfDropDownList+"]//li";
          System.out.println("Number of the dropDown List: >>>>>>>>>> >>>> >>> >"+numberOfDropDownList);

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
            selectDurationHour(durationHour,xpathDurationHourAndMinute);
            //Select Duration Minute
            selectDurationMinute(durationMinute,xpathDurationHourAndMinute);
//        try {
//            Thread.sleep(50000);
//        }   catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            //Select week's Law
            selectWeekLaw(weekLaws);
            //Select Teacher
            selectTeacher(teacherName);
            //Select Lesson Tag
            selectLessonTag(lessonTag);
            // Close create lesson dialog
            //btnDoneCloseCreateLessonDialog.click();//now not click because of create real data on PROD
            //Close current tab and back to Create Course button tab
            switchToFirstTab();
            return true;
//        }
//        catch (Exception e)
//        {return false;}
    }
    public void uncheckCheckedDate() {

        //Remove Read Only Attribute of Start Date
        //WebElement elementName = btnSunday;
        String Sunday = btnSunday.getAttribute("aria-checked");
        String Monday = btnMonday.getAttribute("aria-checked");
        String Tuesday = btnTuesday.getAttribute("aria-checked");
        String Wednesday = btnWednesday.getAttribute("aria-checked");
        String Thursday = btnThursday.getAttribute("aria-checked");
        String Friday = btnFriday.getAttribute("aria-checked");
        String Saturday = btnSaturday.getAttribute("aria-checked");
        if(Sunday != null) {
            btnSunday.click();
        }
        if(Monday != null) {
            btnMonday.click();
        }
        if(Tuesday != null) {
            btnTuesday.click();
        }
        if(Wednesday != null) {
            btnWednesday.click();
        }
        if(Thursday != null) {
            btnThursday.click();
        }
        if(Friday != null) {
            btnFriday.click();
        }
        if(Saturday != null) {
            btnSaturday.click();
        }


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

        for (int i = 0; i < minuteList.size(); i++) {
            int j=i+1;
            String minute = minuteList.get(i).findElement(By.xpath("(//*[@class='eeo-ul options minute eeo-scroll-bar']//li)["+j+"]")).getText();
            if (minute.trim().equalsIgnoreCase(lessonMinute)) {
                System.out.println("Selected minute: " + minute);
                minuteList.get(i).click();
                break;
            }
        }
        btnCloseTimePicker.click();
        System.out.println("Selected Minute value \nClosed Time Picker...");
    }
    public void selectDurationHour(String durationHourInput,String xpathDurationHourList) {

        WebElement elementName = driver.findElement(By.xpath("//input[@placeholder='hour']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Duration Hour successfully");
        btnOpenDropDownDurationHour.clear();
        btnOpenDropDownDurationHour.sendKeys(durationHourInput);


        List<WebElement> listDurationHour = driver.findElements(By.xpath(xpathDurationHourList));
        for (int i = 0; i < listDurationHour.size(); i++) {
            int j=i+1;
            String durationHour = listDurationHour.get(i).findElement(By.xpath(xpathDurationHourList+"["+j+"]")).getText();
            if (durationHour.trim().equalsIgnoreCase(durationHourInput)) {
                System.out.println("Selected hour: " + durationHour);
                listDurationHour.get(i).click();
                break;
            }
        }
        System.out.println("Selected Duration Hour value");
    }
    public void selectDurationMinute(String durationHourInput, String xpathDurationMinuteList) {
        WebElement elementName = driver.findElement(By.xpath("//input[@placeholder='minute']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
        System.out.println("Removed Read Only attribute of Duration Minute successfully");
        btnOpenDropDownDurationMinute.clear();
        System.out.println("Cleared default Duration Minute successfully");
        btnOpenDropDownDurationMinuteAfterClearDefaultValue.sendKeys(durationHourInput);
        System.out.println("Enter search value to Duration Minute successfully");


        List<WebElement> listDurationMinute = driver.findElements(By.xpath(xpathDurationMinuteList));
        for (int i = 0; i < listDurationMinute.size(); i++) {
            int j=i+1;
            String durationMinute = listDurationMinute.get(i).findElement(By.xpath(xpathDurationMinuteList+"["+j+"]")).getText();
            if (durationMinute.trim().equalsIgnoreCase(durationHourInput)) {
                System.out.println("Selected minute: " + durationMinute);
                listDurationMinute.get(i).click();
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
        //btnSunday.click();
        uncheckCheckedDate();
        System.out.println("Unchecked default day");
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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectCourseAndLessonTagPage = new SelectCourseAndLessonTagPage(getDriver());
        selectCourseAndLessonTagPage.selectCourseAndLessonTag("lesson", lessonTag);
        //wait pop-up close completely
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void switchToFirstTab()
    {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println("Switch to first tab successfully");
    }
    public boolean checkIfThisPageIsAvailable() {
        if (driver.findElements(By.xpath("//span[normalize-space(text()) = 'Create Lessons']")).size() != 0)
            return true;
        else
            return false;

    }
    }
