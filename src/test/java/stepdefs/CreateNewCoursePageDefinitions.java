package stepdefs;
import cucumber.api.java.en.Then;
import pages.CreateNewCoursePage;
import pages.SelectAdvisorPage;

import static driver.HookSteps.getDriver;
public class CreateNewCoursePageDefinitions {
    CreateNewCoursePage createNewCoursePage;
    SelectAdvisorPage selectAdvisorPage;
    @Then("^I create new course$")
    public void i_create_new_course(){
        createNewCoursePage = new CreateNewCoursePage(getDriver());
        createNewCoursePage.createNewCourse("test Course Name tp38","2021-10-31","staging","tung");
        System.out.println("Create new course successfully");
    }
    @Then("^I go to lesson page - Will be modified$")
    public void i_go_to_Lesson_page()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createNewCoursePage = new CreateNewCoursePage(getDriver());
        createNewCoursePage.goToLessonPage();
    }
}
