package stepdefs;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class CloseBrowserDefinitions {
    WebDriver driver;
    @AfterTest
    @Then ("^I close Chrome browser$")
    public void close_chrome_browser(){
        //driver.close();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
}
