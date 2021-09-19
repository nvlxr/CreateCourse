package stepdefs;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CoursesPage;
import pages.LandingPage;

import static driver.HookSteps.getDriver;

public class CoursesPageDefinitions {
    CoursesPage coursesPage;
    @Then("^I click create a new course$")
    public void i_click_create_a_new_course(){
        coursesPage = new CoursesPage(getDriver());
        coursesPage.clickCreateCourse();
        System.out.println("Click create new course successfully");

    }

}
