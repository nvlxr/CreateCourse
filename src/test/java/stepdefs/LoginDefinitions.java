package stepdefs;
import cucumber.api.java.en.Then;
import pages.LoginPage;

import static driver.HookSteps.getDriver;

//Then I click create a new course
//        Then I create new course
//        Then I go to lesson page - Will be modified
//        Then I create lesson

public class LoginDefinitions {

    LoginPage loginPage;

    @Then("^I enter username and password$")
    public void i_enter_username_and_password(){
        loginPage = new LoginPage(getDriver());
        loginPage.loginAs("Vietnam","+84","396011104", "d3B&s6j#");
        System.out.println("Enter phone number and password successfully");
    }
    @Then("^I wait to enter captcha$")
    public void i_wait_to_enter_captcha()
    {
        loginPage.waitUntilLandingPageReady();
//        try {
//            Thread.sleep(13000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Captcha entered successfully + Landing page loaded (Course clickable)");
    }

}
