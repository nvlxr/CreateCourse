package stepdefs;
import cucumber.api.java.en.Then;
import pages.LandingPage;

import static driver.HookSteps.getDriver;

public class LandingPageDefinitions {
    LandingPage landingPage;
        //WebDriver driver;

    @Then("^I click Courses menu on Landing page$")
    public void i_click_courses_menu_on_landing_page(){
        landingPage = new LandingPage(getDriver());
        landingPage.clickCourse();
        System.out.println("Click Courses on Landing Page successfully");
    }



}
