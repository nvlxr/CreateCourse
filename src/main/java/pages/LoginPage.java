package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@class=\"el-select-dropdown el-popper phoneAreaNumSelect\"]//ul//li")
    List<WebElement> countryList;
    @FindBy (xpath = "//button[contains(@class,'submitBtn')]") WebElement loginButton;
    @FindBy (name = "phoneCode") WebElement phoneCode;
    @FindBy (name = "phoneNum") WebElement phoneNum;
    @FindBy (xpath = "//input[@type=\"password\"]") WebElement password;

    public void enterPhoneCode(String phoneCodeInput)
    {
        this.phoneCode.clear();
        this.phoneCode.sendKeys(phoneCodeInput);
    }

    public void enterPhoneNum(String phoneNumInput)
    {
        phoneNum.clear();
        phoneNum.sendKeys(phoneNumInput);
    }
    public void enterPassword(String pwd)
    {
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickLogin()
    {
        loginButton.click();
    }
    //wait to manually enter captcha successfully and new page is loaded completely
    public void waitUntilLandingPageReady()
    {

        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='el-menu-item']")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='el-menu-item']//*[text()='Courses']")));
    }
    public void loginAs(String countryNameInput, String phoneCode, String phoneNum, String password)
    {
        enterPhoneCode(phoneCode);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<countryList.size();i++)
        {

            String countryName = countryList.get(i).findElement(By.xpath("//div[@class='label title']")).getText();
            //System.out.println(countryName);
            if(countryName.trim().equalsIgnoreCase(countryNameInput))
            {
                System.out.println("Selected country phone code of "+countryName);
                countryList.get(i).click();
            }
        }
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        enterPhoneNum(phoneNum);
        enterPassword(password);
        clickLogin();
    }
    //Login > Landing




}
