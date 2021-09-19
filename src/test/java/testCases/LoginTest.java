package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src\\main\\java\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://console.classin.com/saas/school/index.html#/singlePage/CourseManagement/courseInfoEditor?courseId=");
    }
    @DataProvider (name="registrationFailedsData")
    public static Object[][]dataProviderMethod()
    {
        return new Object[][]{};
    }
    @Test(dataProvider = "registrationFailedsData")
    public void testRegistration(String email, String pwd, String errorMessage)
    {
//        objLogin = new LoginPage(driver);
//        objLandingPage = new LandingPage(driver);
//        objCoursesPage = new CoursesPage(driver);
//        objCreateNewCoursesPage = new CreateNewCoursePage(driver);
//        objSelectAdvisorPage = new SelectAdvisorPage(driver);


    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
