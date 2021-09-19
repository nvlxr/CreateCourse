package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class HookSteps {
    public static WebDriver driver;
    public  void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.classin.com/en/login.html");
    }
//
//    @AfterTest
//    public void teardown(){
//        driver.close();
//        driver.quit();
//    }
}
