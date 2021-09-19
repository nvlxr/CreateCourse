package stepdefs;
import cucumber.api.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import driver.HookSteps.*;

import java.util.concurrent.TimeUnit;

import static driver.HookSteps.setup;

public class OpenBrowserDefinitions {
    //WebDriver driver;

    @BeforeTest
    @Given("^I open Chrome browser and go to Main page$")
    public void i_open_chrome_browser(){
        setup();
        System.out.println("Open browser and open page successfully");
//        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://practice.automationtesting.in/");
    }
}